package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import data.Usuario;
import dto.ReservaDTO;
import dto.VueloDTO;
import services.AeroIbService;
import services.DBService;
import services.LoginService;
import services.PagoService;





public class AuctionServer  extends UnicastRemoteObject implements IAuction {
	private static final long serialVersionUID = 1L;
	private static AuctionServer instance;
	public Usuario state;


	private AuctionServer() throws RemoteException {
		super();		
	}
	
	public static AuctionServer getInstance() {
		if (instance == null) {
			try {
				instance = new AuctionServer();
			} catch (Exception ex) {
				System.err.println("# Error creating RemoteFacade: " + ex);
			}
		}
		
		return instance;
	}

	@Override
	public boolean login(String aEmail, String aPassword) throws RemoteException {
		System.out.println(" * RemoteFaçade login: " + aEmail + " / " + aPassword);
		System.out.println("Hoallalalalal");
		this.state = LoginService.getInstance().login(aEmail, aPassword);
		
		return state != null;
	}

	@Override
	public List<VueloDTO> getVuelos() throws RemoteException {
		System.out.println("Buscando vuelos");
		
		return AeroIbService.getInstance().getVuelos();
	}

	

	@Override
	public boolean registro(String email) throws RemoteException {
			System.out.println("Entra remote registro");
			this.state = LoginService.getInstance().registro(email);
			return this.state !=null;
		
	}

	@Override
	public boolean pagar(String usuario, int importe) throws RemoteException {
		int a=0;
		a=PagoService.getInstance().pagar(usuario, importe);
		System.out.println("El int es "+a);
		if(a>0) {
			System.out.println("Pago completado con exito");
			return true;
		}
		System.out.println("Pago no completado, supera su saldo");
		return false;
	}

	@Override
	public void guardardato(ReservaDTO dto) throws RemoteException {
		 DBService.getInstance().guardardato(dto);
		
	}
	@Override
	public boolean close() throws RemoteException {
		boolean b=PagoService.getInstance().close();
		return b;
	}


}
