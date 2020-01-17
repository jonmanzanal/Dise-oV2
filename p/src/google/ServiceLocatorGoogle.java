package google;

import java.rmi.Naming;

import gremote.IGoogle;

public class ServiceLocatorGoogle {
	private IGoogle service;

	public void setService(String ip, String port, String serverName) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		try {		
			String URL = "//" + ip + ":" + port + "/" + serverName;
			this.service = (IGoogle) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote facade: " + ex);
		}		
	}

	public IGoogle getService() {
		return this.service;
	}
	
}