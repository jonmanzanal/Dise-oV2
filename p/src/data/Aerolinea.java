package data;



import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Aerolinea {

	@Persistent
	private String idaer;
	@NotPersistent
	@Persistent(mappedBy = "aerolinea")
	private Set<Vuelo> vuelo;
	@NotPersistent
	private String nombre;

	public Aerolinea() {
		super();
		this.idaer = "";
		this.vuelo = new HashSet<Vuelo>();
		this.nombre = "";
	}

	public String getId_aer() {
		return idaer;
	}

	public void setId_aer(String id_aer) {
		this.idaer = id_aer;
	}

	public Set<Vuelo> getVuelo() {
		return vuelo;
	}

	public void setVuelo(Set<Vuelo> vuelo) {
		this.vuelo = vuelo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}