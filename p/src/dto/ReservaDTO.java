package dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;



public class ReservaDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int res;
	private int numasientos;
	private List<String> listapasajeros;
	private Date fecha;
	private double importetotal;
	private UsuarioDTO usuariodto;
	private VueloDTO vuelodto;
	
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
	public List<String> getListapasajeros() {
		return listapasajeros;
	}
	public void setListapasajeros(List<String> listapasajeros) {
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
	public UsuarioDTO getUsuariodto() {
		return usuariodto;
	}
	public void setUsuariodto(UsuarioDTO usuariodto) {
		this.usuariodto = usuariodto;
	}
	public VueloDTO getVuelodto() {
		return vuelodto;
	}
	public void setVuelodto(VueloDTO vuelodto) {
		this.vuelodto = vuelodto;
	}
	
	
	
}
