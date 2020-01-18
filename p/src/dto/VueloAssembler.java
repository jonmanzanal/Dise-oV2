package dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		;
		Date d= new Date(100,2,8);
		dto.setFecha(d);
		
		dto.setHora_llegada(vuelo.getHora_llegada());
		dto.setHora_salida(vuelo.getHora_salida());
	
		dto.setImporte(Math.random()*100);
		
		dto.setDestino(AeropuertoAssembler.getInstance().entityToDTO(vuelo.getAeropuerto()));
		
		System.out.println(vuelo.getAeropuerto().getNombre());
		dto.setOrigen(AeropuertoAssembler.getInstance().entityToDTO(vuelo.getAeropuerto2()));
		System.out.println(vuelo.getAeropuerto2().getNombre());
		
		
		
				
		return dto;
	}
	
	public Set<VueloDTO> entityToDTOs(Set<Vuelo> vuelos) {
		Set<VueloDTO> dtos = new HashSet<>();
		
		for (Vuelo v : vuelos) {
			dtos.add(this.entityToDTO(v));
		}
		
		return dtos;		
	}
	public Set<Vuelo> DTOtoentitys(Set<VueloDTO> dto) {
		Set<Vuelo> vuelos = new HashSet<>();
		
		for (VueloDTO v : dto) {
			vuelos.add(this.DTOToentity(v));
		}
		
		return vuelos;		
	}
	public Vuelo DTOToentity(VueloDTO dto) {
		System.out.println("entro a vueloassembler");
		Vuelo v = new Vuelo();
		
		
		v.setId_vu(dto.getIdvu());
		v.setHora_llegada(dto.getHora_llegada());
		v.setHora_salida(dto.getHora_salida());
		v.setAeropuerto(AeropuertoAssembler.getInstance().DTOToentity(dto.getDestino()));
		v.setAeropuerto2(AeropuertoAssembler.getInstance().DTOToentity(dto.getOrigen()));
		
				
		return v;
	}
}