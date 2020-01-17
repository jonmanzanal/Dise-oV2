package data;

public class Monedero {

	private String usuario;
	private int saldo;
	public Monedero(String usuario, int saldo) {
		super();
		this.usuario = usuario;
		this.saldo = saldo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	
	
}
