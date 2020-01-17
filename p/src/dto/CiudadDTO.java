package dto;

import java.io.Serializable;

public class CiudadDTO implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String cod_ciudad;
private String nombre;
public CiudadDTO(String cod_ciudad, String nombre) {
	super();
	this.cod_ciudad = cod_ciudad;
	this.nombre = nombre;
}
public String getCod_ciudad() {
	return cod_ciudad;
}
public void setCod_ciudad(String cod_ciudad) {
	this.cod_ciudad = cod_ciudad;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}



}
