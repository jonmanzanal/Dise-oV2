package dto;

import data.Aerolinea;

public class AerolineaAssembler {
	private static AerolineaAssembler instance;

	private AerolineaAssembler() { }
	
	public static AerolineaAssembler getInstance() {
		if (instance == null) {
			instance = new AerolineaAssembler();
		}

		return instance;
	}

	public AerolineaDTO entityToDTO(Aerolinea aerolinea) {
		AerolineaDTO dto = new AerolineaDTO();
		
		dto.setIdaer(aerolinea.getId_aer());
		dto.setNombre(aerolinea.getNombre());
		dto.setVuelo(aerolinea.getVuelo());
		
		
		
				
		return dto;
	}
}
