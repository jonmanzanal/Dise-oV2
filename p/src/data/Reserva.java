package data;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reserva {

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.INCREMENT)
	long idres;
	
	
	private int numasientos;
	
	 @Column(name="idvu")
	    Vuelo vuelo;
	private Set<String> listapasajeros;
	private Date fecha;
	private double importetotal;
	private Metodo_pago metodo;
	private int res;
	public Reserva() {
		super();

		this.numasientos = 0;
		this.vuelo = null;
		this.listapasajeros = new HashSet<>();
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

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public Set<String> getLista_pasajeros() {
		return listapasajeros;
	}

	public void setLista_pasajeros(Set<String> lista_pasajeros) {
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

	public int getRes() {
		return res;
	}

	public void setRes(int res) {
		this.res = res;
	}

}