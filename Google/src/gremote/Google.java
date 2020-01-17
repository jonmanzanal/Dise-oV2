package gremote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class Google extends UnicastRemoteObject implements IGoogle {
	
	private static List<DatosG> usuarios=new ArrayList<DatosG>();
	private static Google instance;
		/**
		 * 
		 */
	
	
	public static Google getInstance() {
		if (instance == null) {
			try {
				instance = new Google();
				usuarios.add(new DatosG("jese","joso","Ramon","Mcpato"));
				System.out.println("aa");
			} catch (Exception ex) {
				System.err.println("# Error creating RemoteFacade: " + ex);
			}
		}
		
		return instance;
	}
		private static final long serialVersionUID = 1L;
		private Google() throws RemoteException {
			super();		
		}
	@Override
	public boolean login(String aEmail, String aPassword) throws RemoteException {
		System.out.println("Remote Facade login: " + aEmail + " / " + aPassword);
		System.out.println("ha llegado a google");
		for (DatosG datosG : usuarios) {
			if(datosG.getEmail().equals(aEmail) && datosG.getContrasena().equals(aPassword)){
				return true;
			}
		}
		return false;
}

	@Override
	public String[] registro(String email) throws RemoteException {
		String[] s = new String[3];
		System.out.println("llega google");
		for (DatosG usuario : usuarios) {
			if(usuario.getEmail().equals(email)) {
				s[0]=usuario.getEmail();
				s[1]=usuario.getContrasena();
				s[2]=usuario.getApellidos();
				System.out.println("retorna array string");
				System.out.println(s[0]);
				return s;
				
			}
		}
		return null;
	}

	
}
