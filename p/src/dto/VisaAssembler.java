package dto;


import data.Visa;

public class VisaAssembler {
	private static VisaAssembler instance;

	private VisaAssembler() { }
	
	public static VisaAssembler getInstance() {
		if (instance == null) {
			instance = new VisaAssembler();
		}

		return instance;
	}

	public VisaDTO entityToDTO(Visa visa) {
		VisaDTO dto = new VisaDTO();
		
		dto.setCvc(visa.getCvc());
		dto.setFechacaduc(visa.getFecha_caduc());
		dto.setNumtarjeta(visa.getNum_tarjeta());
		
		
		
				
		return dto;
	}
}
