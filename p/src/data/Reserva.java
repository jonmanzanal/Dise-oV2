package data;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	private long idres;
	
	private int numasientos;
	private Usuario usuario;
	private Vuelo vuelo;
	private List<String> listapasajeros;
	private Date fecha;
	private double importetotal;
	private Metodo_pago metodo;

	public Reserva() {
		super();

		this.numasientos = 0;
		this.usuario = null;
		this.vuelo = null;
		this.listapasajeros = new ArrayList<>();
		this.fecha = null;
		this.importetotal = 0.0;
		this.metodo = null;
	}

	public int getNum_asientos() {
		return numasientos;
	}

	public void setNum_asientos(int num_asientos) {
		this.numasientos = num_asientos;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public List<String> getLista_pasajeros() {
		return listapasajeros;
	}

	public void setLista_pasajeros(List<String> lista_pasajeros) {
		this.listapasajeros = lista_pasajeros;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getImporte() {
		return importetotal;
	}

	public void setImporte(double importe) {
		this.importetotal = importe;
	}

	public Metodo_pago getMetodo() {
		return metodo;
	}

	public void setMetodo(Metodo_pago metodo) {
		this.metodo = metodo;
	}

	

}