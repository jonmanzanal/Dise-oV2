package iberia_server;

import java.rmi.Naming;

import iberia_remote.Iberia;
import iberia_remote.IberiaFacade;


public class ServerIberia {

	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];		
		
		try {
			IberiaFacade remoteFacade = Iberia.getInstance();			
			Naming.rebind(name, remoteFacade);
			System.out.println(" * Google server '" + name + "' started!!");
		} catch (Exception ex) {
			System.err.println(" # Google Server Exception: " + ex.getMessage());
			ex.printStackTrace();
		}

	}
}
