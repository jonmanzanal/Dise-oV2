package remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import data.Paypal;
import data.Usuario;
import dto.ReservaDTO;
import dto.UsuarioDTO;
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
	public List<VueloDTO> getVuelos() throws RemoteException, ParseException {
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
			Paypal p=new Paypal();
			p.setImporte(importe);
			p.setUsuario(usuario);
			DBService.getInstance().guardarpago(p);			
			System.out.println("Pago completado con exito");
			
			return true;
		}
		System.out.println("Pago no completado, supera su saldo");
		return false;
	}

	@Override
	public boolean close() throws RemoteException {
		boolean b=PagoService.getInstance().close();
		return b;
	}

	
	@Override
	public void guardardato(ReservaDTO resdto) throws RemoteException {
		System.out.println("Entra fachada server");
		 DBService.getInstance().guardardato(resdto);
		
	}

	@Override
	public boolean disminuirasientos(int asientos, String cod) {
		System.out.println("asientos-entra fachada");
		boolean c=AeroIbService.getInstance().disminuirasientos(asientos, cod);
		return c;
	}



}
