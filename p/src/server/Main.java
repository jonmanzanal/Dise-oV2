package server;

import java.rmi.Naming;

import remote.AuctionServer;
import remote.IAuction;



public class Main {

	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];		
		
		try {
			IAuction remoteFacade = AuctionServer.getInstance();			
			Naming.rebind(name, remoteFacade);
			System.out.println(" * EasyBooking server '" + name + "' started!!");
		} catch (Exception ex) {
			System.err.println(" # EasyBooking Server Exception: " + ex.getMessage());
			ex.printStackTrace();
		}

	}

}
