package IberiaRMI;

import java.rmi.Naming;

import iberia_remote.IberiaFacade;


public class ServiceLocatorIberia {
	private IberiaFacade service;

	public void setService(String ip, String port, String serverName) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		try {		
			String URL = "//" + ip + ":" + port + "/" + serverName;
			this.service = (IberiaFacade) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating remote facade: " + ex);
		}		
	}

	public IberiaFacade getService() {
		return this.service;
	}
	
}