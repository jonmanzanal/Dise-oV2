package dto;

import java.io.Serializable;
import java.util.Set;

import data.Vuelo;

public class AerolineaDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idaer;
	private String nombre;
	private Set<Vuelo> vuelo;
	

	public String getIdaer() {
		return idaer;
	}

	public void setIdaer(String idaer) {
		this.idaer = idaer;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Vuelo> getVuelo() {
		return vuelo;
	}

	public void setVuelo(Set<Vuelo> vuelo) {
		this.vuelo = vuelo;
	}
	
	
	
	
}
