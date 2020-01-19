package services;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import data.Usuario;
import db.GestorBD;
import google.ConexionGoogle;
import google.GoogleMain;

public class PagoService {
private static PagoService instance;

	
	private PagoService() { }
	
	public static PagoService getInstance() {
		if (instance == null) {
			instance = new PagoService();
		}
		
		return instance;
	}
	
	
	public int pagar(String email,double importe) {
		System.out.println("PagoService");
		String ip="localhost";
		int port= 35670;
		int data2=0;
		DataOutputStream out;
		try {
			Socket s= new Socket(ip,port);
			String datos= email+"#"+Double.toString(importe);
			out = new DataOutputStream(s.getOutputStream());
			out.writeUTF(datos);
			
			DataInputStream in = new DataInputStream(s.getInputStream());
			String data= in.readUTF();
			Double data1= Double.parseDouble(data);
			data2= data1.intValue();
			
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return data2;
}
	
	public boolean close() {
		System.out.println("PagoService");
		String ip="localhost";
		int port= 35670;
		DataOutputStream out;
		try {
			System.out.println("pagoservice close");
			Socket s= new Socket(ip,port);
			String datos= "close";
			out = new DataOutputStream(s.getOutputStream());
			out.writeUTF(datos);
			s.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
