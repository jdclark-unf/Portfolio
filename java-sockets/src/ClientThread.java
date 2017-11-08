package server;

import java.io.*;
import java.net.*;

/**
 * Creates a thread to handle a single client
 * @author Justin Clark (primary coding)
 * @author Marcus Hagans (testing and tweaks)
 * @author Jason Reim (testing and documentation)
 * @author Sam Lockwood (testing and documentation)
 */
public class ClientThread extends Thread
  {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String host;
    
    // Constructor
    public ClientThread(Socket socket)
    {
        super("MultiThreadServer");
        this.socket = socket;
        host = socket.getInetAddress().getCanonicalHostName();
    } // end constructor
    
    @Override // Run a thread
    public void run()
    {
        try
        {
            // Create data I/O streams
            in = new BufferedReader(new 
                    InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            
            // Declare incoming command string
            String commandIn;
            
            // Continuously serve clients
            while ((commandIn = in.readLine()) != null)
            {                
                // Convert command number to command string
                switch (Integer.parseInt(commandIn))
                {
                    case 1: commandIn = "date";
                        break;
                    case 2: commandIn = "uptime";
                        break;
                    case 3: commandIn = "free";
                        break;
                    case 4: commandIn = "netstat";
                        break;
                    case 5: commandIn = "who";
                        break;
                    case 6: commandIn = "ps -e";
                        break;
                }
                
                // Print command status and output
                System.out.println("\n* Executing command: " + commandIn +
                        " for client " +  host);
                String commandOut = commandExec(commandIn);                
                out.println(commandOut);
            
            }
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
        finally
        {
            try
            {
                in.close();
                out.close();
                socket.close();
            }
            catch (IOException e)
            {
                System.err.println(e);
            }
            
        }
    } // end run()
    
    /**
     * Executes a shell command and captures its output
     * @param command The command to be executed
     * @return Output from command
     */
    private String commandExec(String command)
    {
        // Strings for command output
       String line;
       String output = "";
       
       try
       {
           Process proc = Runtime.getRuntime().exec(command);
           BufferedReader input = new BufferedReader(
                   new InputStreamReader(proc.getInputStream()));
           while ((line = input.readLine()) != null)
               output += line + "\n";           
           
           input.close();
       }
       catch (Exception e)
       {
           System.out.println(e);
       }
       
       return output + "END_MESSAGE";
    } // end commandExec()
    
    /**
     * Getter method for hostname
     * @return string representation of hostname
     */
    public String getHost()
    {
        return host;
    }
  } // end class ClientThread
