package remote;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import dto.ReservaDTO;
import dto.VueloDTO;

public interface IAuction extends Remote{
	public boolean login(String aEmail, String aPassword) throws RemoteException;
	public boolean registro(String email) throws RemoteException;
	public List<VueloDTO> getVuelos() throws RemoteException;
	public void guardardato(ReservaDTO dto) throws RemoteException;
	public boolean pagar(String usuario, int importe) throws RemoteException;
	boolean close() throws RemoteException;
}
