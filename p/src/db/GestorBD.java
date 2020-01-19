package db;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import data.Aerolinea;
import data.Aeropuerto;
import data.Paypal;
import data.Reserva;
import data.Usuario;
import data.Visa;
import data.Vuelo;





public class GestorBD implements IGestionDAO{
	private static GestorBD instance = null;
	private static PersistenceManager persistentManager=null;
	private PersistenceManagerFactory pmf = null;
	 
	private GestorBD() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");		
	}
	
	private void initializeData() {
		System.out.println(" * Initializing data base");
		//Create Sample data
		Set<Reserva> lires = new HashSet<>();
		Set<String> pas = new HashSet<>();
		Set<Vuelo> vu = new HashSet<>();
		Date fecha = new Date();
		String f = "12/03/2013";
		DateFormat format = new SimpleDateFormat("DD/MM/YYYY");
		try {
			fecha = format.parse(f);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		pas.add("Jesus");
		pas.add("Marcos");
		Aeropuerto a = new Aeropuerto();
		Aerolinea ar = new Aerolinea();
		Vuelo v = new Vuelo();
		v.setAerolinea(ar);
		v.setAeropuerto(a);
		v.setId_avion(1);
		v.setId_vu(1);
		v.setReserva(lires);
		vu.add(v);
		a.setCiudad("Bilbao");
		a.setIdaero("BIB");
		a.setNombre("Loiu");
		a.setPais("Spain");
		a.setVuelos(vu);

		v.setAerolinea(ar);
		Paypal p = new Paypal();
		p.setUsuario("Jon");
		Visa vi = new Visa();
		vi.setCvc(123);
		vi.setFecha_caduc(fecha);
		vi.setNum_tarjeta(1234);
		//Usuario u = new Usuario();
		//u.setAeropuertopordefecto(a);
		//u.setApellidos("Manzanal");
		//u.setEmail("jese");
		//u.setNombre("dd");
		//u.setTiporedsocial(1);
		//u.setReserva(lires);
/*
		Reserva r = new Reserva();
		r.setFecha(fecha);
		r.setImporte(100);
		r.setLista_pasajeros(pas);
		r.setMetodo(p);
		r.setNum_asientos(1);
		//r.setUsuario(u);
		r.setVuelo(v);
		lires.add(r);
*/
		ar.setId_aer("HH");
		ar.setNombre("Iberia");
		ar.setVuelo(vu);
		
		try {
			//Store users in DB
			//GestorBD.getInstance().store(u);
			
			
		} catch (Exception ex) {
			System.out.println(" $ Error initializing data: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	public void store(Usuario user) {
		GestorBD.getInstance().storeObjectInDB(user);	
	}
	public void store(Reserva r) {
		GestorBD.getInstance().storeObjectInDB(r);	
	}
	public void storeObjectInDB(Object object) {
		Transaction transaction = null;
		
		try {
			System.out.println("Store object");
			persistentManager = pmf.getPersistenceManager();
			transaction = persistentManager.currentTransaction();
			transaction.begin();

			persistentManager.makePersistent(object);

			transaction.commit();
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
			e.printStackTrace();
		} finally {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			persistentManager.close();
		}
	}
	public static GestorBD getInstance() {
		if (instance == null) {
			instance = new GestorBD();
			instance.initializeData();
		}		
		
		return instance;
	}
	
	public Usuario getUsuario(String email) {
		persistentManager = pmf.getPersistenceManager();
		Transaction transaction = null;
		transaction = persistentManager.currentTransaction();
		Usuario usuario=null;
		try {
			transaction.begin();
			// Usuario
			Query<?> usuQuery = persistentManager.newQuery("SELECT FROM " + Usuario.class.getName() +" WHERE email == '"+ email+"'");
			usuQuery.setUnique(true);
			usuario=(Usuario) usuQuery.execute();
			//System.out.println(usuario.getEmail());
			transaction.commit();
	} catch (Exception ex) {
		System.err.println("* Exception executing a query: " + ex.getMessage());
	} finally {
		if (transaction.isActive()) {
			System.out.println("paso1");
			transaction.rollback();
		}
		System.out.println("paso2");
		persistentManager.close();
	}
		System.out.println("pasousuario");
		return usuario;
	}
	public List<Reserva> getReserva() {
		// Reserva
		persistentManager = pmf.getPersistenceManager();
		Transaction transaction = null;
		transaction = persistentManager.currentTransaction();
		List<Reserva> reservas = new ArrayList<>();
		try {
			transaction.begin();
		Extent<Reserva> reserExtent = persistentManager.getExtent(Reserva.class);

					for (Reserva reserva : reserExtent) {
						System.out.println("  -> " + reserva);
									
					}

					transaction.commit();
				} catch (Exception ex) {
					System.err.println("* Exception executing a query: " + ex.getMessage());
				} finally {
					if (transaction.isActive()) {
						transaction.rollback();
					}

					persistentManager.close();
				}
		return reservas;
	}
	public Reserva getUsuario(int res) {
		persistentManager = pmf.getPersistenceManager();
		Transaction transaction = null;
		transaction = persistentManager.currentTransaction();
		Reserva reserva=null;
		try {
			transaction.begin();
			// Usuario
			Query<?> usuQuery = persistentManager.newQuery("SELECT FROM " + Reserva.class.getName() +"WHERE email== "+ res);
			usuQuery.setUnique(true);
			reserva=(Reserva) usuQuery.execute();
	transaction.commit();
	} catch (Exception ex) {
		System.err.println("* Exception executing a query: " + ex.getMessage());
	} finally {
		if (transaction.isActive()) {
			transaction.rollback();
		}
		persistentManager.close();
	}
		return reserva;
	}
	public void updateReservas(String id_usuario,Reserva reserva) {
	    persistentManager = pmf.getPersistenceManager();
	    Transaction transaction=null;
	    transaction=persistentManager.currentTransaction();
	    
	    try {
	        transaction.begin();

	        Usuario u = persistentManager.getObjectById(Usuario.class,id_usuario);
	        Set <Reserva> reservas= u.getReservas();
	        reservas.add(reserva);
	        u.setReservas(reservas);
	       
	        

	        transaction.commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	        transaction.rollback();
	    } finally {
	        persistentManager.close();
	    }
	}
	
}
