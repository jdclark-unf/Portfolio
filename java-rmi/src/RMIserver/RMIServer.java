import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RMISecurityManager;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.concurrent.atomic.*;

public class RMIServer {

	public static void main(String[] args) {
		
		try{
			RMIProcessor cp = new RMIProcessor();
			final String objName = "cp";
			RMIProcessorInterface server = (RMIProcessorInterface) 
					UnicastRemoteObject.exportObject(cp, 8080);
			final Registry registry = LocateRegistry.getRegistry(15432);
			registry.bind(objName, server);
			System.out.println("Registered command processor");
			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					try {
						registry.unbind(objName);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
				}
			});
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
}
