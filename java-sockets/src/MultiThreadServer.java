package server;

import java.io.*;
import java.net.*;

/**
 * A multithreaded socket server
 * @author Justin Clark (primary coding)
 * @author Marcus Hagans (testing and tweaks)
 * @author Jason Reim (testing and documentation)
 * @author Sam Lockwood (testing and documentation)
 */
public class MultiThreadServer
{
    private ServerSocket sSocket;
        
    /**
     * Constructor
     * @param port port number for server to listen to
     */
    public MultiThreadServer(int port) throws IOException
    {
        // Create a server socket
        sSocket = new ServerSocket(port);        
    } // end constructor
    
    /**
     * Listens on assigned port
     */
    public void listen() throws IOException
    {
        System.out.println("\n* Listening on port " + sSocket.getLocalPort());
        
        // Loop indefinitely
        while (true)
        {
            // Start new thread for client
            ClientThread task = new ClientThread(sSocket.accept());
            Thread worker = new Thread(task);
            System.out.println("\n* Starting thread for client " + 
                    task.getHost());
            worker.start();        
        } // end while
    } // end listen()
} // end class MultiThreadServer
