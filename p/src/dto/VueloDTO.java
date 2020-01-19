package dto;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

public class VueloDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idvu;
	private String hora_salida;
	private String hora_llegada;
	private Date fecha;
	private double importe;
	private String origen;
	private String destino;
	private int numplazas;
	
	
	public int getNumplazas() {
		return numplazas;
	}
	public void setNumplazas(int numplazas) {
		this.numplazas = numplazas;
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
	
	
	public String getIdvu() {
		return idvu;
	}
	public void setIdvu(String idvu) {
		this.idvu = idvu;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	@Override
	public String toString() {
		
		DecimalFormat format = new DecimalFormat("#.00");
		
		return "Idvu="+ idvu +" (" + hora_salida + "-" + hora_llegada + ") "
				+ fecha.getDay()+"/"+fecha.getMonth()+1+"/"+fecha.getYear() + " " + format.format(importe)+ "€ " + origen + " - " + destino + "Disp:"
				+ numplazas;
	}
	
	
	
	
	
}
