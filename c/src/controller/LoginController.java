package controller;

import java.rmi.RemoteException;
import java.util.List;


import remote.ServiceLocator;

public class LoginController {
	public ServiceLocator serviceLocator;

	public LoginController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}
	
	public boolean login(String email, String password) {
		System.out.println("hhjhjhj");
		try {
			return this.serviceLocator.getService().login(email, password);
		} catch (RemoteException e) {
			System.err.println("# Error during login: " + e);
			return false;
		}
	}
	
	public boolean registro(String email) {
		System.out.println("entra controller registro");
		try {
			return this.serviceLocator.getService().registro(email);
		}catch(RemoteException e){
			return false;
		}
	}

	
	
}
