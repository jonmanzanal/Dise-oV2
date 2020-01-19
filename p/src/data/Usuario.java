package data;

import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Usuario {
	
	@PrimaryKey
	private String email;
	
	private long idusu;
	
	private String nombre;
	private String apellidos;
	private Aeropuerto aeropuertopordefecto;
	private int tiporedsocial;
	@Element(column="email")
	private Set<Reserva> reserva;

	public Usuario() {
		super();
		this.email = "";
		this.nombre="";
		this.apellidos = "";
		this.aeropuertopordefecto = null;
		this.tiporedsocial = 0;
		this.reserva = new HashSet<Reserva>(); //;
	}

	public long getId_usu() {
		return idusu;
	}

	public void setId_usu(long id_usu) {
		this.idusu = id_usu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Aeropuerto getAeropuertopordefecto() {
		return aeropuertopordefecto;
	}

	public void setAeropuertopordefecto(Aeropuerto aeropuertopordefecto) {
		this.aeropuertopordefecto = aeropuertopordefecto;
	}

	public int getTiporedsocial() {
		return tiporedsocial;
	}

	public void setTiporedsocial(int tiporedsocial) {
		this.tiporedsocial = tiporedsocial;
	}

	public Set<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(Set<Reserva> reserva) {
		this.reserva = reserva;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}