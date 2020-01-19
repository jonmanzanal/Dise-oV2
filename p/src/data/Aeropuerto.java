package data;

import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class Aeropuerto {

	@Persistent
	private String idaero;
	@NotPersistent
	private String nombre;
	@NotPersistent
	private String ciudad;
	@NotPersistent
	private String pais;
	@NotPersistent
	private Set<Vuelo> vuelos;
	@NotPersistent
	private int num_terminales;

	public Aeropuerto() {
		super();
		this.idaero = "";
		this.nombre = "";
		this.ciudad = "";
		this.pais = "";
		this.vuelos = new HashSet<Vuelo>();
		this.num_terminales=0;
	}

	public String getIdaero() {
		return idaero;
	}

	public void setIdaero(String idaero) {
		this.idaero = idaero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Set<Vuelo> getVuelos() {
		return vuelos;
	}

	public void setVuelos(Set<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}

	public int getNum_terminales() {
		return num_terminales;
	}

	public void setNum_terminales(int num_terminales) {
		this.num_terminales = num_terminales;
	}

}