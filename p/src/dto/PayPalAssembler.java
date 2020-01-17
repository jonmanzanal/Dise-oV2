package dto;

import data.Paypal;

public class PayPalAssembler {
	private static PayPalAssembler instance;

	private PayPalAssembler() { }
	
	public static PayPalAssembler getInstance() {
		if (instance == null) {
			instance = new PayPalAssembler();
		}

		return instance;
	}

	public PayPalDTO entityToDTO(Paypal paypal) {
		PayPalDTO dto = new PayPalDTO();
		
		dto.setUsername(paypal.getUsuario());;
		
		
		
				
		return dto;
	}
}
