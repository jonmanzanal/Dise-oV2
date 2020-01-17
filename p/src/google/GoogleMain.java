package google;

import services.LoginService;

public class GoogleMain {
	public static void main(String[] args) {
		ServiceLocatorGoogle serviceLocator = new ServiceLocatorGoogle();
		serviceLocator.setService(args[0], args[1], args[2]);
		ConexionGoogle co = new ConexionGoogle(serviceLocator);
		LoginService o= LoginService.getInstance();
		o.login("jese", "joso");
		
		//boolean js = conexion.login("borra","txotxo");
		//LoginController loginController = new LoginController(serviceLocator);
		//Inicio inicio = new Inicio(loginController);			
		//Google g=new Google(loginController);
		//inicio.setVisible(true);
		
			
				
	}
	
	public static ConexionGoogle Loko() {
		ServiceLocatorGoogle serviceLocator = new ServiceLocatorGoogle();
		serviceLocator.setService("127.0.0.1","1099","Google");
		ConexionGoogle co = new ConexionGoogle(serviceLocator);
		
		return co;
	}
	
	

	
}
