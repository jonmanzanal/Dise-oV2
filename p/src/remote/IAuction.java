package remote;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import dto.ReservaDTO;
import dto.UsuarioDTO;
import dto.VueloDTO;

public interface IAuction extends Remote{
	public boolean login(String aEmail, String aPassword) throws RemoteException;
	public boolean registro(String email) throws RemoteException;
	public List<VueloDTO> getVuelos() throws RemoteException, ParseException;
	public boolean pagar(String usuario, int importe) throws RemoteException;
	public void guardardato(ReservaDTO resdto) throws RemoteException;
	public boolean close() throws RemoteException;
	public boolean disminuirasientos(int asientos,String cod)throws RemoteException;
}
