package dto;


import java.util.HashSet;
import java.util.Set;

import data.Reserva;

public class ReservaAssembler {
	private static ReservaAssembler instance;

	private ReservaAssembler() { }
	
	public static ReservaAssembler getInstance() {
		if (instance == null) {
			instance = new ReservaAssembler();
		}

		return instance;
	}

	public ReservaDTO entityToDTO(Reserva reserva) {
		ReservaDTO dto = new ReservaDTO();
		
		dto.setRes(reserva.getRes());
		dto.setFecha(reserva.getFecha());
		dto.setImportetotal(reserva.getImporte());
		//dto.setListapasajeros(reserva.getLista_pasajeros());
		dto.setNumasientos(reserva.getNum_asientos());
		
		
		
				
		return dto;
	}
	
public Reserva DTOToReserva(ReservaDTO dto) {
		
		Reserva r=new Reserva();
		
		r.setRes(dto.getRes());
		r.setFecha(dto.getFecha());
		r.setImporte(dto.getImportetotal());
		
		Set<String>pasajeros= new HashSet<String>();
		
		for(String s:dto.getListapasajeros()) {
			pasajeros.add(s);
		}
		r.setLista_pasajeros(pasajeros);
		r.setNum_asientos(dto.getNumasientos());
		//r.setUsuario(UsuarioAssembler.getInstance().DTOtoentity(dto.getUsuariodto()));
		r.setVuelo(VueloAssembler.getInstance().DTOToentity(dto.getVuelodto()));
		
		return r;
		
	}
	
	
}
