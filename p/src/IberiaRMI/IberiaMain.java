package IberiaRMI;

//import services.LoginService;

public class IberiaMain {
	public static void main(String[] args) {
		ServiceLocatorIberia serviceLocator = new ServiceLocatorIberia();
		serviceLocator.setService(args[0], args[1], args[2]);
		ConexionIberia ci = new ConexionIberia(serviceLocator);
		
		
	}
	
	public static ConexionIberia Loko() {
		ServiceLocatorIberia serviceLocator = new ServiceLocatorIberia();
		serviceLocator.setService("127.0.0.1","1099","IberiaRMI");
		ConexionIberia ci = new ConexionIberia(serviceLocator);
		
		return ci;
	}
	
	

	
}
