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
		//dto.setVuelos(VueloAssembler.getInstance().entityToDTOs(aeropuerto.getVuelos()));
		
		
				
		return dto;
	}
	
	public Aeropuerto DTOToentity(AeropuertoDTO dto) {
		Aeropuerto aeropuerto = new Aeropuerto();
		
		aeropuerto.setIdaero(dto.getIdaero());
		aeropuerto.setNombre(dto.getNombre());
		aeropuerto.setNum_terminales(dto.getNum_terminales());
		//aeropuerto.setVuelos(VueloAssembler.getInstance().DTOtoentitys(dto.getVuelos()));
		
		
				
		return aeropuerto;
	}
}