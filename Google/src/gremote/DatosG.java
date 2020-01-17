package gremote;

public class DatosG {

	
	private String email;
	private String contrasena;
	private String nombre;
	private String apellidos;



	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public DatosG(String email, String contrasena, String nombre, String apellidos) {
		super();
		this.email = email;
		this.contrasena = contrasena;
		this.nombre= nombre;
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	
}
