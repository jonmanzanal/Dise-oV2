package dto;

import java.io.Serializable;
import java.util.Set;

import data.Aeropuerto;
import data.Reserva;

public class UsuarioDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
	private String nombre;
	private String apellidos;
	private int tiporedsocial;
	private Set<Reserva> reserva;
	public Set<Reserva> getReserva() {
		return reserva;
	}
	public void setReserva(Set<Reserva> reserva) {
		this.reserva = reserva;
	}
	public Aeropuerto getAeropuertopordefecto() {
		return aeropuertopordefecto;
	}
	public void setAeropuertopordefecto(Aeropuerto aeropuertopordefecto) {
		this.aeropuertopordefecto = aeropuertopordefecto;
	}
	private Aeropuerto aeropuertopordefecto;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public int getTiporedsocial() {
		return tiporedsocial;
	}
	public void setTiporedsocial(int tiporedsocial) {
		this.tiporedsocial = tiporedsocial;
	}
	
	
	
}
