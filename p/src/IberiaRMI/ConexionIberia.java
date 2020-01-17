package IberiaRMI;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import data.Aeropuerto;
import data.Vuelo;
import iberia_remote.Flight;


public class ConexionIberia implements IGatewayIberia {
	public ServiceLocatorIberia serviceLocator;
	
	public ConexionIberia(ServiceLocatorIberia serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

	@Override
	public List<Vuelo> buscarVuelos() {
		try {
			System.out.println("conexion iberia buscar vuelos");
			List<Flight> flights= this.serviceLocator.getService().getVuelos();
			List<Vuelo> vuelos = new ArrayList <Vuelo>();
			for(Flight f:flights) {
				System.out.println("syso para f");
				System.out.println(f.getCod_avion());
				Vuelo v =new Vuelo();
				Aeropuerto a= new Aeropuerto();
				a.setNombre(f.getOrigen());
				Aeropuerto b= new Aeropuerto();
				b.setNombre(f.getDestino());
				System.out.println("aeropuerto");
				System.out.println(b.getNombre());
				long id_av= Long.parseLong(f.getCod_avion());
				long id_vu= Long.parseLong(f.getCod_vuelo());
				v.setId_avion(id_av);
				v.setAeropuerto(a);
				v.setId_vu(id_vu);
				v.setAeropuerto2(b);
				v.setHora_llegada("10:30");
				v.setHora_salida("8:00");
				vuelos.add(v);
				System.out.println("syso para v");
				System.out.println(v.getId_avion());
			}
			System.out.println("conexion iberia retorno vuelos");
			return vuelos;
		} catch (RemoteException e) {
			System.err.println("# Error during buscarVuelos: " + e);
			return null;
		}
	}

}
