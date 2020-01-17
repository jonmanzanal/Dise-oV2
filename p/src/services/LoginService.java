package services;

import data.Usuario;
import db.GestorBD;
import google.ConexionGoogle;
import google.GoogleMain;


public class LoginService {
private static LoginService instance;
	
	private LoginService() { }
	
	public static LoginService getInstance() {
		if (instance == null) {
			instance = new LoginService();
		}
		
		return instance;
	}

	public Usuario login(String email, String password) {
		System.out.println("tftyfdtyfyt");
		Usuario user =GestorBD.getInstance().getUsuario(email);
		ConexionGoogle go= GoogleMain.Loko();
		boolean google=go.login(email,password);
		
		System.out.println("Google dice que " + google);
		if (user != null) {
			if(google) {
				return user;
			}
			System.out.println("entro");
			return null;
	}
		System.out.println("nulo");
		return null;
}
	
	public Usuario registro(String email) {
		System.out.println("loginservice registro");
		ConexionGoogle go= GoogleMain.Loko();
		String[] a = go.registrarUsuario(email);
		Usuario u;
		System.out.println(a[0]);
		if(a!=null) {
			System.out.println("no null");
			u = new Usuario();
			u.setEmail(a[0]);
			u.setNombre(a[1]);
			u.setApellidos(a[2]);
			GestorBD.getInstance().store(u);
			
			return u;
		}
		
		System.out.println("null");
		return null;
		
	}
}
