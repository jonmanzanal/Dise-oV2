package gui;

import javax.swing.JFrame;

import controller.LoginController;
import controller.VueloController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Registro extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LoginController controller;
	public VueloController vuelocontroller;
	private JTextField textField;
	public Registro(LoginController controller, VueloController vuelocontrol) {
		this.controller = controller;
		this.vuelocontroller=vuelocontrol;
		iniciarRegistro();
	}
	
	private void iniciarRegistro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setSize(600,400);
		textField = new JTextField();
		textField.setBounds(48, 142, 96, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(48, 105, 48, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblUsuarioARegistrar = new JLabel("Usuario a registrar");
		lblUsuarioARegistrar.setBounds(48, 38, 328, 29);
		getContentPane().add(lblUsuarioARegistrar);
		
		JButton btnNewButton = new JButton("Registro");
		btnNewButton.setBounds(48, 192, 89, 23);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				registro(textField.getText());
				}
		});
		
	}
	public void registro(String email) {
		boolean b = controller.registro(email);
		if(b) {
			JOptionPane.showMessageDialog(null, "Registro OK.Inicie sesion");
			Inicio ini=new Inicio(controller,vuelocontroller);
			ini.setVisible(true);
			dispose();
			System.out.println("registro ok");
		}

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}