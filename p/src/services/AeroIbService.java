package services;

import java.util.List;

import IberiaRMI.ConexionIberia;
import IberiaRMI.IberiaMain;
import data.Usuario;
import db.GestorBD;
import dto.VueloAssembler;
import dto.VueloDTO;


public class AeroIbService {
	
private static AeroIbService instance;
	
	private AeroIbService() { }
	
	public static AeroIbService getInstance() {
		if (instance == null) {
			instance = new AeroIbService();
		}
		
		return instance;
	}
	
	public List<VueloDTO> getVuelos() {
		ConexionIberia ci= IberiaMain.Loko();
		System.out.println("service despues de iberia");
		return VueloAssembler.getInstance().entityToDTO(ci.buscarVuelos());

}
}