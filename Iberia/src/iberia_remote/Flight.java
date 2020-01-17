package iberia_remote;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class Flight implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String cod_vuelo;
	private String cod_avion;
	//private LocalDateTime fecha_salida;
	//private LocalDateTime fecha_destino;
	private String fecha_salida;
	private String fecha_destino;
	private String origen;
	private String destino;
	private int numplazas;
	private int precioxplaza;
	public Flight(String cod_vuelo, String cod_avion, String fecha_salida, String fecha_destino, String origen,
			String destino, int numplazas, int precioxplaza) {
		super();
		this.cod_vuelo = cod_vuelo;
		this.cod_avion = cod_avion;
		this.fecha_salida = fecha_salida;
		this.fecha_destino = fecha_destino;
		this.origen = origen;
		this.destino = destino;
		this.numplazas = numplazas;
		this.precioxplaza = precioxplaza;
	}
	public String getCod_vuelo() {
		return cod_vuelo;
	}
	public void setCod_vuelo(String cod_vuelo) {
		this.cod_vuelo = cod_vuelo;
	}
	public String getCod_avion() {
		return cod_avion;
	}
	public void setCod_avion(String cod_avion) {
		this.cod_avion = cod_avion;
	}
	public String getFecha_salida() {
		return fecha_salida;
	}
	public void setFecha_salida(String fecha_salida) {
		this.fecha_salida = fecha_salida;
	}
	public String getFecha_destino() {
		return fecha_destino;
	}
	public void setFecha_destino(String fecha_destino) {
		this.fecha_destino = fecha_destino;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public int getNumplazas() {
		return numplazas;
	}
	public void setNumplazas(int numplazas) {
		this.numplazas = numplazas;
	}
	public int getPrecioxplaza() {
		return precioxplaza;
	}
	public void setPrecioxplaza(int precioxplaza) {
		this.precioxplaza = precioxplaza;
	}
	
}