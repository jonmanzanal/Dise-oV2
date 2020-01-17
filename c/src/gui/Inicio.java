package gui;

import controller.LoginController;
import controller.VueloController;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicio extends JFrame {
	public LoginController controller;
	public VueloController vuelocontroller;
	public Inicio(LoginController controller, VueloController vuelocontroller) {
		this.controller = controller;
		this.vuelocontroller= vuelocontroller;
		Inicio();
	}
	
	private void Inicio() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setVisible(true);
		this.setSize(600,400);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Google login=new Google(controller,vuelocontroller);
				login.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(70, 214, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registro");
		btnNewButton_1.setBounds(296, 214, 89, 23);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Registro registro= new Registro(controller);
				registro.setVisible(true);
				dispose();
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("Bienvenido a EasyBooking");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel.setBounds(59, 69, 326, 48);
		getContentPane().add(lblNewLabel);
		
	}
	
	public static void main(String[] args) {
		

	}
}
