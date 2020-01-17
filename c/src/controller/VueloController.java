package controller;

import java.rmi.RemoteException;
import java.util.List;

import dto.VueloDTO;
import remote.ServiceLocator;

public class VueloController {
	public ServiceLocator serviceLocator;

	public VueloController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public List<VueloDTO> buscarVuelos() {
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
	
	
	}
