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
import javax.swing.JOptionPane;

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
		/*
		Usuario usu= new Usuario();
		usu.setEmail("prueba");
		usu.setApellidos("probando");
		usu.setId_usu(21L);
		usu.setNombre("test");
		usu.setTiporedsocial(0);
		
		Set<Reserva> dos_reservas= new HashSet<Reserva>();
		
		
		Reserva r1= new Reserva();
		r1.setRes(902);
		r1.setImporte(54);
		Set<String> pasajeros= new HashSet<String>();
		pasajeros.add("Luasdsacas");
		pasajeros.add("Paisandy");
		r1.setLista_pasajeros(pasajeros);
		r1.setNum_asientos(1490);
		Vuelo v1= new Vuelo();
		v1.setId_vu(999);
		v1.setId_avion(77);
		r1.setVuelo(v1);
		
		dos_reservas.add(r1);
		usu.setReservas(dos_reservas);
		
		*/
		/*
		Reserva r2= new Reserva();
		r2.setRes(2);
		r2.setImporte(71);
		Set<String> pasajeros2= new HashSet<String>();
		pasajeros2.add("Novak");
		pasajeros2.add("Rafa");
		r2.setLista_pasajeros(pasajeros2);
		r2.setNum_asientos(104);
		Vuelo v2= new Vuelo();
		v2.setId_vu(3123);
		v2.setId_avion(412);
		r2.setVuelo(v2);
		
		
		
		
		dos_reservas.add(r1);
		dos_reservas.add(r2);
		
		usu.setReservas(dos_reservas);
		*/
		/*
		Reserva r3= new Reserva();
		r3.setRes(2);
		r3.setImporte(71);
		Set<String> pasajeros3= new HashSet<String>();
		pasajeros3.add("Griezman");
		pasajeros3.add("Felix");
		r3.setLista_pasajeros(pasajeros3);
		r3.setNum_asientos(222);
		Vuelo v4= new Vuelo();
		v4.setId_avion(9023);
		r3.setVuelo(v4);
		
		*/
		try {
			//Store users in DB
			//GestorBD.getInstance().store(usu);
			//GestorBD.getInstance().updateReservas("rodolfo@gmail.com", r3);
			
		} catch (Exception ex) {
			System.out.println(" $ Error initializing data: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	public void store(Usuario user) {
		GestorBD.getInstance().storeObjectInDB(user);	
	}
	public void store(Reserva r) {
		System.out.println("entra store reserva");
		GestorBD.getInstance().storeObjectInDB(r);	
	}
	public void store(Paypal pay) {
		System.out.println("entra store reserva");
		GestorBD.getInstance().storeObjectInDB(pay);	
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
			JOptionPane.showMessageDialog(null, "Valor duplicado");
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
	    Vuelo vuelo=null;
	    transaction=persistentManager.currentTransaction();
	    
	    try {
	        transaction.begin();

	        Usuario u = persistentManager.getObjectById(Usuario.class,id_usuario);
	        Set <Reserva> reservas= u.getReservas();
	        
	        Query<?> vueloQuery = persistentManager.newQuery("SELECT FROM " + Vuelo.class.getName() +" WHERE idvu == '"+reserva.getVuelo().getId_vu()+"'");
			vueloQuery.setUnique(true);
			vuelo=(Vuelo) vueloQuery.execute();
	        
	        
	        //Vuelo v= persistentManager.getObjectById(Vuelo.class,reserva.getVuelo().getId_vu());
	        if(vuelo==null) {
	        	System.out.println("BD entra nulo ");
	        	reservas.add(reserva);
	        	u.setReservas(reservas);
	        }else {
	        	System.out.println("BD entra else");
	        	reserva.setVuelo(vuelo);
	        	reservas.add(reserva);
	        	u.setReservas(reservas);
	        }
	      
	        transaction.commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	        transaction.rollback();
	    } finally {
	        persistentManager.close();
	    }
	}
	
	
}
