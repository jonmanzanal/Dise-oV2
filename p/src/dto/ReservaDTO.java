package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;



public class ReservaDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int res;
	private int numasientos;
	private Set<String> listapasajeros;
	private Date fecha;
	private double importetotal;
	
	public int getRes() {
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	public int getNumasientos() {
		return numasientos;
	}
	public void setNumasientos(int numasientos) {
		this.numasientos = numasientos;
	}
	public Set<String> getListapasajeros() {
		return listapasajeros;
	}
	public void setListapasajeros(Set<String> listapasajeros) {
		this.listapasajeros = listapasajeros;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getImportetotal() {
		return importetotal;
	}
	public void setImportetotal(double importetotal) {
		this.importetotal = importetotal;
	}
	
	
	
}
