package controller;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.List;

import dto.ReservaDTO;
import dto.VueloDTO;
import remote.ServiceLocator;

public class VueloController {
	public ServiceLocator serviceLocator;

	public VueloController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public List<VueloDTO> buscarVuelos() throws ParseException {
		System.out.println("controller vuelo");
		try {
			return this.serviceLocator.getService().getVuelos();
		} catch (RemoteException e) {
			System.err.println("# Error during buscar vuelos: " + e);
			return null;
		}
	}
	
	public boolean pagar(String usuario,int importe) {
		
		
		try {
			return this.serviceLocator.getService().pagar(usuario, importe);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean close() {
		try {
			return this.serviceLocator.getService().close();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean almacenarReserva(ReservaDTO res) {
		try {
			System.out.println("entra vuelocontroller");
			this.serviceLocator.getService().guardardato(res);
			System.out.println("despues vuelocontroller");
			return true;
		}catch (RemoteException e) {
			System.out.println("Excepcion aqui en controller");
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public boolean disminuirasientos(int asientos,String cod) {
		try {
			System.out.println("Asinentos-Entra vuelocontroller ");
			return this.serviceLocator.getService().disminuirasientos(asientos, cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	
	}
