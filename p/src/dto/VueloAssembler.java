package dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import data.Aeropuerto;
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

	public VueloDTO entityToDTO(Vuelo vuelo) throws ParseException {
		System.out.println("entro a vueloassembler");
		VueloDTO dto = new VueloDTO();
		
		dto.setIdvu(vuelo.getId_vu());
		String entrada = "12/03/2016"; // Entrada recogida como sea (scanner)
		DateFormat format = new SimpleDateFormat("DD/MM/YYYY");
		Date d= format.parse(entrada);
		dto.setFecha(d);
		
		dto.setHora_llegada(vuelo.getHora_llegada());
		dto.setHora_salida(vuelo.getHora_salida());
	
		dto.setImporte(Math.random()*100);
		dto.setNumplazas(vuelo.getNumplazas());
		
		dto.setOrigen(vuelo.getAeropuerto().getNombre());
		//System.out.println(vuelo.getAeropuerto().getNombre());
		dto.setDestino(vuelo.getAeropuerto2().getNombre());
		//System.out.println(vuelo.getAeropuerto2().getNombre());
				
		return dto;
	}
	
	public List<VueloDTO> entityToDTOs(List<Vuelo> vuelos) throws ParseException {
		List<VueloDTO> dtos = new ArrayList<>();
		
		for (Vuelo v : vuelos) {
			dtos.add(this.entityToDTO(v));
		}
		
		return dtos;		
	}
	
	
	public Vuelo DTOToentity(VueloDTO dto) {
		System.out.println("Entro a VueloAssembler");
		Vuelo v = new Vuelo();
		v.setId_vu(dto.getIdvu());
		int random= (int)(Math.random() * 10000) + 20; 
		v.setId_avion(Long.valueOf(random));
		//v.setId_avion(Math.random());
		
		//v.setHora_salida(dto.getHora_salida());
		/*Aeropuerto a1= new Aeropuerto();
		Aeropuerto a2= new Aeropuerto();
		
		a1.setIdaero("ID_"+dto.getOrigen());
		a1.setNombre(dto.getOrigen());
		
		a2.setIdaero("ID_"+dto.getDestino());
		a2.setNombre(dto.getOrigen());

		v.setAeropuerto(a1);
		v.setAeropuerto2(a2);
		*/

		return v;
	}
	
	
	public List<Vuelo> DTOtoentitys(List<VueloDTO> dto) {
		List<Vuelo> vuelos = new ArrayList<>();
		
		for (VueloDTO v : dto) {
			vuelos.add(this.DTOToentity(v));
		}
		
		return vuelos;		
	}
	
}