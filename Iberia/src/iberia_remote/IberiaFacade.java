package iberia_remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;

public interface IberiaFacade extends Remote {
	public Set<Flight> getVuelos() throws RemoteException;

}
