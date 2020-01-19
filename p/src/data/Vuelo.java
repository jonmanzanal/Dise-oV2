package data;

import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.NotPersistent;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Vuelo {

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private long idvu;
	
	private long idavion;
	@NotPersistent
	private String hora_salida;
	@NotPersistent
	private String hora_llegada;
	
	private Aerolinea aerolinea;
	private Aeropuerto aeropuerto;
	@NotPersistent
	private Aeropuerto aeropuerto2;
	@NotPersistent
	private int numplazas;
	
	public int getNumplazas() {
		return numplazas;
	}

	public void setNumplazas(int numplazas) {
		this.numplazas = numplazas;
	}
	public Aeropuerto getAeropuerto2() {
		return aeropuerto2;
	}

	public void setAeropuerto2(Aeropuerto aeropuerto2) {
		this.aeropuerto2 = aeropuerto2;
	}

	private Set<Reserva> reserva = new HashSet<Reserva>();

	public Vuelo() {
		super();
		this.idvu = 0;
		this.idavion = 0;
		this.hora_salida="";
		this.hora_llegada="";
		this.aerolinea = null;
		this.aeropuerto = null;
		this.numplazas=0;
	}

	public String getHora_salida() {
		return hora_salida;
	}

	public void setHora_salida(String hora_salida) {
		this.hora_salida = hora_salida;
	}

	public String getHora_llegada() {
		return hora_llegada;
	}

	public void setHora_llegada(String hora_llegada) {
		this.hora_llegada = hora_llegada;
	}

	public long getId_vu() {
		return idvu;
	}

	public void setId_vu(long id_vu) {
		this.idvu = id_vu;
	}

	public long getId_avion() {
		return idavion;
	}

	public void setId_avion(long id_avion) {
		this.idavion = id_avion;
	}

	public Aerolinea getAerolinea() {
		return aerolinea;
	}

	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}

	public Aeropuerto getAeropuerto() {
		return aeropuerto;
	}

	public void setAeropuerto(Aeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}

	public Set<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(Set<Reserva> reserva) {
		this.reserva = reserva;
	}

}