package data;

import javax.jdo.annotations.Discriminator;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Discriminator(value = "Paypal")
public class Paypal extends Metodo_pago {
	private String usuario;

	public Paypal() {
		super();
		this.usuario = "";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
