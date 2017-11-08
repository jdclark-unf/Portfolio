import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIProcessorInterface extends Remote {
	 public String run(String command) throws RemoteException;

}
