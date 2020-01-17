package main;

import controller.LoginController;
import controller.VueloController;
import gui.Inicio;
import gui.Google;
import remote.ServiceLocator;

public class Main {

	public static void main(String[] args) {
		ServiceLocator serviceLocator = new ServiceLocator();
		serviceLocator.setService(args[0], args[1], args[2]);
		
		LoginController loginController = new LoginController(serviceLocator);
		VueloController vuelocontroller = new VueloController(serviceLocator);
		
		Inicio inicio = new Inicio(loginController,vuelocontroller);			
		//Google g=new Google(loginController);
		inicio.setVisible(true);
			
				
	}

}
