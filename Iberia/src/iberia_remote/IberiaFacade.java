package iberia_remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IberiaFacade extends Remote {
	public List<Flight> getVuelos() throws RemoteException;
	public boolean disminuirasientos(int asientos,String cod) throws RemoteException;

}
