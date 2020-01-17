package dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import data.Vuelo;



public class VueloAssembler {
	
	private static VueloAssembler instance;

	private VueloAssembler() { }
	
	public static VueloAssembler getInstance() {
		if (instance == null) {
			instance = new VueloAssembler();
		}

		return instance;
	}

	public VueloDTO entityToDTO(Vuelo vuelo) {
		System.out.println("entro a vueloassembler");
		VueloDTO dto = new VueloDTO();
		
		dto.setIdvu(vuelo.getId_vu());
		System.out.println("parselong");
		Date d= new Date(100,2,8);
		dto.setFecha(d);
		System.out.println("llego date");
		dto.setHora_llegada(vuelo.getHora_llegada());
		dto.setHora_salida(vuelo.getHora_salida());
		System.out.println("horas");
		dto.setImporte(10);
		System.out.println("importe");
		dto.setDestino(vuelo.getAeropuerto().getNombre());
		System.out.println("print1");
		System.out.println(vuelo.getAeropuerto().getNombre());
		dto.setOrigen(vuelo.getAeropuerto2().getNombre());
		System.out.println(vuelo.getAeropuerto2().getNombre());
		System.out.println("print2");
		
		System.out.println("entitytodto");
				
		return dto;
	}
	
	public List<VueloDTO> entityToDTO(List<Vuelo> vuelos) {
		List<VueloDTO> dtos = new ArrayList<>();
		
		for (Vuelo v : vuelos) {
			dtos.add(this.entityToDTO(v));
		}
		
		return dtos;		
	}
}