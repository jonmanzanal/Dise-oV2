package controller;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;

import dto.ReservaDTO;
import dto.VueloDTO;
import remote.ServiceLocator;

public class VueloController {
	public ServiceLocator serviceLocator;

	public VueloController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public Set<VueloDTO> buscarVuelos() {
		System.out.println("controller vuelo");
		try {
			return this.serviceLocator.getService().getVuelos();
		} catch (RemoteException e) {
			System.err.println("# Error during buscar vuelos: " + e);
			return null;
		}
	}
	
	public boolean pagar(String usuario,int importe) {
		
		boolean b;
		try {
			b=this.serviceLocator.getService().pagar(usuario, importe);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return true;
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
			System.out.println("Entra VueloController");
			this.serviceLocator.getService().guardardato(res);
			return true;
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	public boolean disminuirasientos(int asientos,String cod) {
		try {
			this.serviceLocator.getService().disminuirasientos(asientos, cod);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	}
