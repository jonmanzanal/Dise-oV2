package data;

import java.util.Date;

import javax.jdo.annotations.Discriminator;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Discriminator(value = "Visa")
public class Visa extends Metodo_pago {
	private long numtarjeta;
	private Date fechacaduc;
	private int cvc;

	public Visa() {
		super();
		this.numtarjeta = 0;
		this.fechacaduc = null;
		this.cvc = 0;
	}

	public long getNum_tarjeta() {
		return numtarjeta;
	}

	public void setNum_tarjeta(long num_tarjeta) {
		this.numtarjeta = num_tarjeta;
	}

	public Date getFecha_caduc() {
		return fechacaduc;
	}

	public void setFecha_caduc(Date fecha_caduc) {
		this.fechacaduc = fecha_caduc;
	}

	public int getCvc() {
		return cvc;
	}

	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

}
