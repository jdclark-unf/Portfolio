package server;

import java.io.*;

/**
 * Creates a multithreaded server that executes commands from clients
 * @author Justin Clark (primary coding)
 * @author Marcus Hagans (testing and tweaks)
 * @author Jason Reim (testing and documentation)
 * @author Sam Lockwood (testing and documentation)
 */
public class Main
{    
    /**
     * Entry point of program
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        if (args.length != 1)
        {
            // Print error message
            System.out.println("\nInvalid parameters");
            System.out.println("Usage: server <portnumber>");
        }
        else
        {
            int port = Integer.parseInt(args[0]);
            
            if (port < 1024 || port > 65535)
            {
                System.out.println("\nInvalid port number");
                System.out.println("Port number must be in range 1024 to 65535");
            }
            else
            {
                try
                {
                    MultiThreadServer mts = new MultiThreadServer(port);
                    mts.listen();
                }
                catch (IOException e)
                {
                    System.err.println(e);
                    System.exit(-1);
                }                
            } // end inner else
        } // end outer else  
    } // end main()    
} // end class Main
