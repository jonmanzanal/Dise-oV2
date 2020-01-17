package iberia_remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IberiaFacade extends Remote {
	public List<Flight> getVuelos() throws RemoteException;

}
