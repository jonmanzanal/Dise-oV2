package services;

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
		Reserva r=new Reserva();
		r=ReservaAssembler.getInstance().DTOToReserva(dto);
		GestorBD.getInstance().store(r);
	
	}
}
