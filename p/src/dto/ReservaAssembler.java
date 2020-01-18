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
		dto.setUsuariodto(UsuarioAssembler.getInstance().entityToDTO(reserva.getUsuario()));
		dto.setVuelodto(VueloAssembler.getInstance().entityToDTO(reserva.getVuelo()));
		
		
		
				
		return dto;
	}
	public Reserva DTOToReserva(ReservaDTO dto) {
		
		Reserva r=new Reserva();
		r.setFecha(dto.getFecha());
		r.setRes(dto.getRes());
		r.setImporte(dto.getImportetotal());
		r.setLista_pasajeros(dto.getListapasajeros());
		r.setNum_asientos(dto.getNumasientos());
		r.setUsuario(UsuarioAssembler.getInstance().DTOtoentity((dto.getUsuariodto())));
		r.setVuelo(VueloAssembler.getInstance().DTOToentity(dto.getVuelodto()));
		
	
		
		
		return r;
		
	}
}
