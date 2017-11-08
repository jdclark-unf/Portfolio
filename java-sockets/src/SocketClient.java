package client;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

import javax.swing.*;

/**
 * @author Marcus Hagans (primary coding)
 * @author Justin Clark (testing and tweaks)
 * @author Jason Reim (testing and documentation)
 * @author Sam Lockwood (testing and documentation)
 */
public class SocketClient{
	
	// create a variable to initialize new threads with
	private static Thread thrd = null;
		
	// This AtomicLong is used to keep track of the current # of running threads
	private static AtomicLong runningThreads = new AtomicLong(0);
	
	// Used for telling when to print
	private static boolean printOutput = true;
	
	// Keeps the total Time
	private static AtomicLong totalTime = new AtomicLong(0);
	
	// Stores threads in a LIst
	private static LinkedList<Thread> list = new LinkedList<Thread>();
	
	// Stores server name
	private static String hostName;
	
	public static void main(String[] args) throws InterruptedException{
		
		int choice = 0;
		int clientCount = 1;
		
		// Checks to see if a hostname was entered
		if(args.length == 0){
			System.out.println("User did not enter a hostname, Shutting Down!");
			System.exit(1);
		}
		else while(choice != 8){
			hostName = args[0];
			
			// Calls menu for user to choose an option
			new mainMenu();
			choice = mainMenu.getChoice();
			
			// Exit the program if 8 is choosen
			if(choice == 8){
				System.out.println("\nQuitting Program.\n");
				System.exit(0);
			}
			
			// Prompt user what command will be run in Multiple Client Mode
			if(choice == 7){
				printOutput = false;
				new MultiMode();
				new NumClientMenu();
				choice = MultiMode.getChoice();
				clientCount = NumClientMenu.getClientCount();
			}
			totalTime.set(0);
			runningThreads.set(clientCount);
			
			// Create new Threads for additional Clients and tell it the hostName
			// Run the thread, and pass totalTime object to record how much
			// time it took the thread to complete its task.
			for(int i = 0; i < clientCount; i++){
				
				thrd = new Thread(new MultipleClient(hostName, choice, totalTime,
						printOutput, runningThreads));
				thrd.start();
				list.add(thrd);
			}
			
			// wait for all the threads to finish before looping again, to ensure all 
			// threads finish before the menu pops again.
			for(int i = 0; i < clientCount; i++){
				try{
					// wait for the thread to finish
					list.get(i).join();
				}catch(InterruptedException e){
					// if the join interrupts the thread, print an error
					e.printStackTrace();
				}
			}
			
			// while runningThreads is not 0, there are still clients waiting for the server 
			// to respond so keep looping utill they are finished.
			while(runningThreads.get() != 0){
				;
			}// End of do nothing loop
			
			// Reset clientCount to 1 and printOutput to true
			System.out.println("\nAverage response time: " + (totalTime.get() / clientCount) + " ms\n");
			clientCount = 1;
			printOutput = true;
			
		}// End of while loop
			
	}// End of Main
		
}
//********************mainMenu***************************
class mainMenu{
	private String menu = "Choose from the following selections\n" +
			"1. Host current Date and Time\n" +
			"2. Host uptime\n" +
			"3. Host Memory\n" +
			"4. Host Netstat\n" +
			"5. Host current users\n" +
			"6. Host running processes\n" +
			"7. Run Multiple Client Mode\n" +
			"8. Quit\n";
	
	 private static int choice = 0 ;

	// Display menu for user and returns the selection
	@SuppressWarnings("resource")
	mainMenu(){
		// Added to stop
		choice = 0;
		while((choice <= 0) || (choice > 8)){
			System.out.println(menu);
			Scanner input = new Scanner(System.in);
			if(input.hasNext()){
				choice = input.nextInt();
			}	
		}	
	}
	// Returns user choice
	public static int getChoice() {
		
		return choice;
	}
	
}
//**********************MultiMode*************************
class MultiMode{
	private String multiMenu = "Which command would you like to run in Multi Client Mode\n" +
			"1. Host current Date and Time\n" +
			"2. Host uptime\n" +
			"3. Host Memory\n" +
			"4. Host Netstat\n" +
			"5. Host current users\n" +
			"6. Host running processes\n";
	
	 private static int choice = 0 ;
	 
	@SuppressWarnings("resource")
	MultiMode(){
		choice = 0;
		while((choice <= 0) || (choice > 7)){
			System.out.println(multiMenu);
			Scanner input = new Scanner(System.in);
			if(input.hasNextInt()){
				choice = input.nextInt();
			}
		}
		
	}
	
	// Returns user choice
	public static int getChoice() {
		return choice;
	}
	
}// End MultiMode
//**********************NumClient************************
class NumClientMenu{
	private static int clientCount;
	@SuppressWarnings("static-access")
	NumClientMenu(){
		this.clientCount = 0;
		while((clientCount <= 0) || (clientCount > 100)){
			System.out.println("Enter the number of clients you would like to run between (1-50).\n");
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			if(input.hasNextInt()){
				clientCount = input.nextInt();
			}
		}
		
	}
	public static int getClientCount() {
		return clientCount;
	}
}// End NumClienMenu
//MultipleClient*****************************************
class MultipleClient extends Thread {
	// Each client needs the server and port to connect to
	private String hostName;
	private Socket socket = null;
	private int port = 8080;
	
	// totalTime is used to compute the times for all the threads
	private AtomicLong totalTime;
	
	// Keeps the total number of threads running and decrease as the threads finish
	// there tasks
	private AtomicLong runningThreads;
	
	// Used to tell the program to hold off from outputing information to the screen
	// to avoid clutter of the window.
	private boolean printOutput;
	
	// User selected task from the menu
	private int choice;
	
	// Used to get keep track the start time(when client sends request) and the
	// the time the last bit was received from the server.
	private long startTime;
	private long endTime;
		
	public MultipleClient(String hostName, int choice, AtomicLong totalTime,
			boolean printOutput, AtomicLong runningThreads) {
		this.choice = choice;
		this.hostName = hostName;
		this.totalTime = totalTime;
		this.printOutput = printOutput;
		this.runningThreads = runningThreads;
		
	}
	
	public void run(){
		PrintWriter out = null;
		BufferedReader input = null;
		
		// Create a new Socket object and names it Socket
		// Create connection to server
		try {
			// Creates a new Socket for each client Thread and establishes
			// a connection between the client and server.
			socket = new Socket(hostName, port);
			if(printOutput){
				System.out.println("Establishing connection\n");
			}
			// opens the Printwriter on the socket
			out = new PrintWriter(socket.getOutputStream(), true);
			
			// opens the BufferredReader on the socket
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			if(printOutput){
				System.out.println("Requesting output for the '" + choice + "' command from '" + hostName + "'.\n");
			}
			
			// get the Start time the command was sent to the server
			startTime = System.currentTimeMillis();
			
			// Create output path to the server
			out.println(Integer.toString(choice));
			if(printOutput){
				System.out.println("Sent command to server.\n");
			}
			
			// Create a input path from the server
			String outputString;
			while(((outputString = input.readLine()) != null) && (!outputString.equals("END_MESSAGE"))){
				if(printOutput){
					System.out.println(outputString);
				}
			}// End of while loop
			
			//get the current time after last bit is read from server
			endTime = System.currentTimeMillis();
			
			// endTime - startTime = the time it took to get the response from the server
			totalTime.addAndGet(endTime - startTime);
			
			
		} // End of try block
		catch (UnknownHostException e) {
			System.err.println("Unknown host: " + hostName);
			System.exit(1);
		}
		catch (ConnectException e) {
			System.err.println("Connection refused by host: " + hostName);
			System.exit(1);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		// finally, close the socket and decrement runningThreads
		finally {
			if (printOutput) System.out.println("\nclosing\n");
			try {
				socket.close();
				runningThreads.decrementAndGet();
				System.out.flush();
			}
			catch (IOException e ) {
				System.out.println("Couldn't close socket");
			}
		}
	}
}
// MultipleClient End

