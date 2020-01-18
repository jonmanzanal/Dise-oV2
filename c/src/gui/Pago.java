package gui;

import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.VueloController;
import dto.ReservaDTO;
import dto.UsuarioDTO;
import dto.VueloDTO;

import javax.swing.JLabel;

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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	public VueloController controller;
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
		setSize(720, 480);
		JTextField anadir = new JTextField();;
		List<String> c=new ArrayList<String>();
		
		
		getContentPane().setLayout(null);
		
		
		anadir.setBounds(37, 41, 96, 20);
		getContentPane().add(anadir);
		anadir.setColumns(10);
		
		
		JLabel lblNewLabel = new JLabel("Introducir Pasajeros");
		lblNewLabel.setBounds(38, 16, 117, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("RealizarReserva");
		btnNewButton.setBounds(270, 196, 124, 23);
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(37, 134, 41, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(141, 40, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(269, 40, 89, 23);
		getContentPane().add(btnClose);
		
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean close= controller.close();
				
			}
			
		});
		
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
					reserva.setUsuariodto(usu);
					reserva.setVuelodto(vuelodto);
					long yourmilliseconds = System.currentTimeMillis();
					SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
					Date resultdate = new Date(yourmilliseconds);
					reserva.setFecha(resultdate);
					reserva.setRes(numres);
					reserva.setNumasientos(c.size());
					reserva.setImportetotal(c.size()*vuelodto.getImporte());
					reserva.setListapasajeros(c);
					
					boolean almacenado= controller.almacenarReserva(reserva);
					if(almacenado) {
						System.out.println("Reserva creada y almacenada");
					}
				}
				//Joption volver al menu > OK > crear ventana de Busqueda con string si.
				
			}
				boolean pagoresult= controller.pagar("pepe", (int) (c.size()*Pago.this.vuelodto.getImporte()));
				
			
		});
		
		
	}
}
