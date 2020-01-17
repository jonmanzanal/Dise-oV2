package server;

import data.Monedero;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PaypalService extends Thread {
	private DataInputStream in;
	private DataOutputStream out;
	private Socket tcpSocket;

	private static List<Monedero> monederos = new ArrayList<Monedero>();
	private static String DELIMITER = "#";
	
	public PaypalService(Socket socket) {
		try {
			this.tcpSocket = socket;
		    this.in = new DataInputStream(socket.getInputStream());
			this.out = new DataOutputStream(socket.getOutputStream());
			this.start();
			monederos.add(new Monedero("jorge",50));
			monederos.add(new Monedero("pepe",270));
			monederos.add(new Monedero("persa",410));
			
		} catch (IOException e) {
			System.err.println("# TranslationService - TCPConnection IO error:" + e.getMessage());
		}
	}

	public void run() {
		try {
			String data = this.in.readUTF();			
			System.out.println("   - TranslationService - Received data from '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data + "'");					
			data = this.translate(data);
			this.out.writeUTF(data);					
			System.out.println("   - TranslationService - Sent data to '" + tcpSocket.getInetAddress().getHostAddress() + ":" + tcpSocket.getPort() + "' -> '" + data.toUpperCase() + "'");
		} catch (EOFException e) {
			System.err.println("   # TranslationService - TCPConnection EOF error" + e.getMessage());
		} catch (IOException e) {
			System.err.println("   # TranslationService - TCPConnection IO error:" + e.getMessage());
		} finally {
			try {
				tcpSocket.close();
			} catch (IOException e) {
				System.err.println("   # TranslationService - TCPConnection IO error:" + e.getMessage());
			}
		}
	}
	
	public String translate(String msg) {
		System.out.println(msg);
		
		StringTokenizer stk= new StringTokenizer(msg,DELIMITER);
		String username= stk.nextToken();
		String importe= stk.nextToken();
		String respuesta="";
		double cantidad=Double.parseDouble(importe);
		for(Monedero m:monederos) {
			if(username.equals(m.getUsuario())) {
				double saldo=m.getSaldo();
				double restante=saldo-cantidad;
				m.setSaldo((int)restante);
				respuesta=Double.toString(restante);
			}
		}
		return respuesta;
	}
}