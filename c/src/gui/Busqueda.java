package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.LoginController;
import controller.VueloController;
import dto.UsuarioDTO;
import dto.VueloDTO;



import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;

import dto.VueloDTO;
import javax.swing.JScrollBar;

public class Busqueda extends JFrame {
 
	
	private static int contadorClose=0;
	public VueloController controller;
	public LoginController logincontroller;
	public List <VueloDTO> vuelos=new ArrayList<VueloDTO>();
	private JTextField textField;
	private JTextField textField_1;
	private String c;
	private String u;
	private  String usu;
	public Busqueda(VueloController controller,String conexion,String usuario,LoginController logincont) {
		this.controller = controller;
		this.usu=usuario;
		this.logincontroller=logincont;
		if(conexion.equals("si")) {
			contadorClose++;
		}
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setSize(600,400);
		
		DefaultListModel<VueloDTO> modelo = new DefaultListModel<VueloDTO>();
		
		JButton btnNewButton4 = new JButton("BuscarVuelos");
		btnNewButton4.setBounds(37, 216, 109, 23);
		getContentPane().add(btnNewButton4);

		JList<VueloDTO> list_1 = new JList<VueloDTO>(modelo );
		list_1.setBounds(37, 24, 530, 151);
		getContentPane().add(list_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(457, 24, 17, 151);
		getContentPane().add(scrollBar);
		
		/*
		JButton btnNewButton = new JButton("Vuelos");
		btnNewButton.setBounds(284, 203, 89, 23);
		getContentPane().add(btnNewButton);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				List <VueloDTO> vuelos= controller.buscarVuelos();
				for(VueloDTO v:vuelos) {
					System.out.println(v.toString());
				}
			}
		});
		
		*/
btnNewButton4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					vuelos= controller.buscarVuelos();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				modelo.addAll(vuelos);
				}
			
		});
		
	


			if(contadorClose>1) {
				
				JButton btnNewButton = new JButton("Close");
				btnNewButton.setBounds(219, 216, 89, 23);
				getContentPane().add(btnNewButton);
				
				btnNewButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						boolean close= controller.close();
						
					}
					
				});
				
			}
		
		
		list_1.setCellRenderer((ListCellRenderer) new DefaultListCellRenderer(){

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				 Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				 if (renderer instanceof JLabel && value instanceof VueloDTO) {
	                    
	                    ((JLabel) renderer).setText(((VueloDTO) value).toString());
	                }
	                return renderer;
				
			}
			
	        
		});
		
		JButton btnNewButton_1 = new JButton("Log Out");
		btnNewButton_1.setBounds(37, 327, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Inicio ini= new Inicio(logincontroller,controller);
				ini.setVisible(true);
				dispose();
				
			}
		});
		
		
		String s=null;
		MouseListener mouseListener = new MouseAdapter() 
		{
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 2) // Se mira si es doble click
		        {
		            int posicion = list_1.locationToIndex(e.getPoint());
		            
		            VueloDTO s=(VueloDTO) modelo.getElementAt(posicion);
		            UsuarioDTO user= new UsuarioDTO();
		            user.setEmail(Busqueda.this.usu);
		          
		            Pago p=new Pago(controller,s,user);
		            p.setVisible(true);
		            dispose();
		            
		         }
		    }
		};
		list_1.addMouseListener(mouseListener);
		
		
		
	}
}
