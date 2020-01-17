package dto;


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
		dto.setListapasajeros(reserva.getLista_pasajeros());
		dto.setNumasientos(reserva.getNum_asientos());
		
		
		
				
		return dto;
	}
}
