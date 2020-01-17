package dto;

import java.io.Serializable;
import java.util.Date;

public class VisaDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long numtarjeta;
	private Date fechacaduc;
	private int cvc;
	
	public long getNumtarjeta() {
		return numtarjeta;
	}
	public void setNumtarjeta(long numtarjeta) {
		this.numtarjeta = numtarjeta;
	}
	public Date getFechacaduc() {
		return fechacaduc;
	}
	public void setFechacaduc(Date fechacaduc) {
		this.fechacaduc = fechacaduc;
	}
	public int getCvc() {
		return cvc;
	}
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
	
	
}
