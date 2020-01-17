package dto;

import java.io.Serializable;

public class PaisDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cod_pais;
	private String nombre;
	public PaisDTO(String cod_pais, String nombre) {
		super();
		this.cod_pais = cod_pais;
		this.nombre = nombre;
	}
	public String getCod_pais() {
		return cod_pais;
	}
	public void setCod_pais(String cod_pais) {
		this.cod_pais = cod_pais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
