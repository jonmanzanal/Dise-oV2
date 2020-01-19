package gui;

import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.LoginController;
import controller.VueloController;
import dto.ReservaDTO;
import dto.UsuarioDTO;
import dto.VueloDTO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;

public class Pago extends JFrame {
	public VueloController controller;
	public LoginController logincontroller;
	private VueloDTO vuelodto;
	private UsuarioDTO usu;
	private static int numres=0;
	
	public Pago(VueloController controller,VueloDTO vuelo,UsuarioDTO usuario) {
		this.controller = controller;
		this.vuelodto=vuelo;
		this.usu=usuario;
		initcomponentes();
	}
	public void initcomponentes() {
		JTextField anadir = new JTextField();
		Set<String> c=new HashSet<String>();
		
		
		getContentPane().setLayout(null);
		
		
		anadir.setBounds(37, 41, 96, 20);
		getContentPane().add(anadir);
		anadir.setColumns(10);
		setSize(480, 480);
		
		JLabel lblNewLabel = new JLabel("Introducir Pasajeros");
		lblNewLabel.setBounds(38, 16, 117, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("RealizarReserva");
		btnNewButton.setBounds(37, 101, 124, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Anadir pasajero");
		btnNewButton_1.setBounds(141, 40, 89, 23);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				c.add(anadir.getText().trim());
				System.out.println("Pasajero "+anadir.getText()+ " añadido.");
				System.out.println("Anadir mas o pagar");
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				boolean pagoresult= controller.pagar(usu.getEmail(),(int)Pago.this.vuelodto.getImporte()*c.size());
				
				if(pagoresult) {
					System.out.println("Pago realizado con exito");
					numres++;
					ReservaDTO reserva= new ReservaDTO();
					reserva.setUsuariodto(Pago.this.usu);
					
					
					reserva.setVuelodto(Pago.this.vuelodto);
					
				
					long yourmilliseconds = System.currentTimeMillis();
					SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
					Date resultdate = new Date(yourmilliseconds);
					reserva.setFecha(resultdate);
					
					reserva.setRes(numres);
					
					reserva.setNumasientos(c.size());
					
					reserva.setImportetotal(c.size()*Pago.this.vuelodto.getImporte());
					
					
					List<String> pasajeros= new ArrayList<String>();
					
					for(String cs:c) {
						pasajeros.add(cs);
					}
					reserva.setListapasajeros(pasajeros);
					System.out.println("pasajeros");
					System.out.println("antes de reserva bucle");
					
					boolean almacenado= controller.almacenarReserva(reserva);
					if(almacenado) {
						System.out.println("Reserva creada y almacenada");
						boolean disminuir=controller.disminuirasientos(c.size(),vuelodto.getIdvu());
						if(disminuir) {
							System.out.println("Actualizados datos aerolinea");
							JOptionPane.showMessageDialog(null, "Reserva realizada");
							
							Busqueda bus=new Busqueda(controller,"si",Pago.this.usu.getEmail(),logincontroller);
							bus.setVisible(true);
							dispose();
						}
					}
				}
				//Joption volver al menu > OK > crear ventana de Busqueda con string si.
				
			}
		});
		
		
		JButton btnNewButton3 = new JButton("Close");
		btnNewButton3.setBounds(246, 40, 70, 23);
		getContentPane().add(btnNewButton3);
		
		btnNewButton3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean close= controller.close();
				
			}
			
		});
		
	
		
		
		
	}
}