import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;

public class RMIProcessor implements RMIProcessorInterface {

	public RMIProcessor() throws RemoteException {
		
	}
		
		public String run(String command)
	    {
	        // Strings for command output
	        String line;
	        String output = "";
	        
	        try
	        {
	            Process proc = Runtime.getRuntime().exec(parseCommand(command));
	            
	            BufferedReader out = new BufferedReader(new 
	                    InputStreamReader(proc.getInputStream()));
	            
	            while ((line = out.readLine()) != null)
	            {
	               output = output.concat(line);
	               output = output.concat("\n");
	            }
	            
	            output = output.concat("END_MESSAGE");
	            out.close();
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        
	        return output;
	    } // end run()
	    
	    private String parseCommand(String input)
	    {
	        String command = "";
	        
	        // Convert command number to command string
	        switch (Integer.parseInt(input))
	        {
	            case 1: command = "date";
	                break;
	            case 2: command = "uptime";
	                break;
	            case 3: command = "free";
	                break;
	            case 4: command = "netstat";
	                break;
	            case 5: command = "who";
	                break;
	            case 6: command = "ps -e";
	                break;
	        }
	        
	        return command;
	    } // end parseCommand()
	} // end class CommandProcessor

