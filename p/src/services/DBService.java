package services;

import data.Paypal;
import data.Reserva;
import db.GestorBD;
import dto.ReservaAssembler;
import dto.ReservaDTO;

public class DBService {
private static DBService instance;
	
	private DBService() { }
	
	public static DBService getInstance() {
		if (instance == null) {
			instance = new DBService();
		}
		
		return instance;
	}
	
	public void guardardato(ReservaDTO dto) {
		System.out.println("Entra DBService");
		Reserva r=new Reserva();
		System.out.println("antes de assembler");
		r=ReservaAssembler.getInstance().DTOToReserva(dto);
		System.out.println("despues de assembler va al store");
		GestorBD.getInstance().updateReservas(dto.getUsuariodto().getEmail(), r);
	
	}
	public void guardarpago(Paypal pay) {
		System.out.println("Entra DBService p");
		System.out.println("pay");
		GestorBD.getInstance().store(pay);
		
	
	}
	
	
	}