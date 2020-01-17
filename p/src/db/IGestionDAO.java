package db;

import java.util.List;

import data.Reserva;
import data.Usuario;

public interface IGestionDAO {
	public Reserva getUsuario(int res);
	public List<Reserva> getReserva() ;
	public Usuario getUsuario(String email);
	public void storeObjectInDB(Object object);
}
