package dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;



import data.Vuelo;

public class AeropuertoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idaero;
	private String nombre;
	private int num_terminales;
	private List<VueloDTO> vuelos;
	
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
	public int getNum_terminales() {
		return num_terminales;
	}
	public void setNum_terminales(int num_terminales) {
		this.num_terminales = num_terminales;
	}
	public List<VueloDTO> getVuelos() {
		return vuelos;
	}
	public void setVuelos(List<VueloDTO> vuelos) {
		this.vuelos = vuelos;
	}
	
}
