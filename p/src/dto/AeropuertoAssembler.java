package dto;


import data.Aeropuerto;

public class AeropuertoAssembler {
	private static AeropuertoAssembler instance;

	private AeropuertoAssembler() { }
	
	public static AeropuertoAssembler getInstance() {
		if (instance == null) {
			instance = new AeropuertoAssembler();
		}

		return instance;
	}

	public AeropuertoDTO entityToDTO(Aeropuerto aeropuerto) {
		AeropuertoDTO dto = new AeropuertoDTO();
		
		dto.setIdaero(aeropuerto.getIdaero());
		dto.setNombre(aeropuerto.getNombre());
		dto.setNum_terminales(aeropuerto.getNum_terminales());
		dto.setVuelos(aeropuerto.getVuelos());
		
		
				
		return dto;
	}
	
}
