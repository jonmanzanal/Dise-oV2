package gserver;

import java.rmi.Naming;

import gremote.Google;
import gremote.IGoogle;


public class ServerGoogle {

	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];		
		
		try {
			IGoogle remoteFacade = Google.getInstance();			
			Naming.rebind(name, remoteFacade);
			System.out.println(" * Google server '" + name + "' started!!");
		} catch (Exception ex) {
			System.err.println(" # Google Server Exception: " + ex.getMessage());
			ex.printStackTrace();
		}

	}
}
