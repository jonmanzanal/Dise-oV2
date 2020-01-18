package gui;

import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.VueloController;

import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JButton;

public class Pago extends JFrame {
	private JTextField textField;
	public VueloController controller;
	
	public Pago(VueloController controller) {
		this.controller = controller;
		initcomponentes();
	}
	public void initcomponentes() {
		JTextField anadir = new JTextField();;
		Set<String> c=new HashSet<String>();
		
		
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
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				c.add(anadir.getText().trim());
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for (String string : c) {
					textField.setText(string);
				
				}
				
				boolean pagoresult= controller.pagar("pepe", 20*c.size());
				
			}
		});
		
		
	}
}
