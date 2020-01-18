package gui;

import javax.swing.JFrame;

import controller.LoginController;
import controller.VueloController;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Google  extends JFrame  {
	public LoginController controller;
	public VueloController vuelocontroller;
	private JTextField textField;
	private JTextField textField_1;
	private String c;
	private String u;
	//private VueloController vuelocontroller;
	public Google(LoginController controller, VueloController vuelocontroller) {
		this.controller = controller;
		this.vuelocontroller=vuelocontroller;
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setSize(600,400);
		
		textField = new JTextField();
		textField.setBounds(159, 109, 135, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(159, 161, 135, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(161, 84, 48, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setBounds(159, 140, 76, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Google");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 25));
		lblNewLabel_2.setBounds(161, 30, 117, 43);
		getContentPane().add(lblNewLabel_2);
		
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(284, 203, 89, 23);
		getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				u=textField.getText();
				c=textField_1.getText();
				login(u,c);
			}
		});
		
	}
	
	public void login(String u, String p) {
		System.out.println(" - Login into the server: '" + u + "' - '" + p + "'");
		
		boolean loginResult = controller.login(u, p);
		
		System.out.println("    * Login result: " + loginResult);
		if(loginResult) {
			JOptionPane.showMessageDialog(null, "Login correcto");
			Busqueda bus=new Busqueda(vuelocontroller,"no",u);
			bus.setVisible(true);
			dispose();	
		}else {
			int b= JOptionPane.showOptionDialog(null, "Usuario o contrasena incorrectos", "Login incorrecto", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null,null);
			if(b==0){
				
			}
			
		}
		
	}
	public static void main(String[] args) {
		
		

	}
}
