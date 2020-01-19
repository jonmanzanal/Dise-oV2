package iberia_remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import iberia_remote.IberiaFacade;

public class Iberia  extends UnicastRemoteObject implements IberiaFacade {
	
	private static Set<Flight> vuelos=new HashSet<Flight>();
	private static Iberia instance;
		/**
		 * 
		 */
	
	
	public static Iberia getInstance() {
		if (instance == null) {
			try {
				instance = new Iberia();
				String strDatewithTime = "2015-08-04T10:11:30";
				//LocalDateTime d1 = LocalDateTime.parse(strDatewithTime);
				
				String strDatewithTime2 = "2019-09-02T15:20:59";
				//LocalDateTime d2 = LocalDateTime.parse(strDatewithTime2);
				
				vuelos.add(new Flight("1","1",strDatewithTime,strDatewithTime2,"Zimbawe", "Johanesburg",200,10));
				vuelos.add(new Flight("2","2",strDatewithTime,strDatewithTime2,"Varsovia", "Bilbao",200,10));
				System.out.println("Inicializando aerolinea Iberia");
			} catch (Exception ex) {
				System.err.println("# Error creating RemoteFacade: " + ex);
			}
		}
		
		return instance;
	}
		private static final long serialVersionUID = 1L;
		private Iberia() throws RemoteException {
			super();		
		}

	@Override
	public Set<Flight> getVuelos() throws RemoteException {
		System.out.println("entra a iberia para consguir vuelos flight");
		return vuelos;
	}

	@Override
	public boolean disminuirasientos(int asientos, String cod) throws RemoteException {
		int res=0;
		for (Flight flight : vuelos) {
			if(flight.getCod_vuelo()==cod) {
				res=flight.getNumplazas();
				res=res-asientos;
				flight.setNumplazas(res);
				if(res<flight.getNumplazas()) {
					return true;
				}
			}
		}
		return false;
	}

}
