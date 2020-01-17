package gui;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

import controller.VueloController;
import dto.VueloDTO;
import javax.swing.JScrollBar;

public class Busqueda extends JFrame {
	public List <VueloDTO> vuelos=new ArrayList<VueloDTO>();
	public VueloController controller;
	private JTextField textField;
	private JTextField textField_1;
	private String c;
	private String u;
	public Busqueda(VueloController controller) {
		this.controller = controller;
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		this.setSize(600,400);
		
		DefaultListModel<VueloDTO> modelo = new DefaultListModel<VueloDTO>();
		JButton btnNewButton = new JButton("BuscarVuelos");
		btnNewButton.setBounds(37, 216, 109, 23);
		getContentPane().add(btnNewButton);
		
		JList<VueloDTO> list_1 = new JList<VueloDTO>(modelo );
		list_1.setBounds(37, 24, 410, 151);
		getContentPane().add(list_1);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(457, 24, 17, 151);
		getContentPane().add(scrollBar);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vuelos= controller.buscarVuelos();
				modelo.addAll(vuelos);
				}
			
		});
		
		
		
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
		
		String s=null;
		MouseListener mouseListener = new MouseAdapter() 
		{
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 2) // Se mira si es doble click
		        {
		            int posicion = list_1.locationToIndex(e.getPoint());
		            
		            VueloDTO s=(VueloDTO) modelo.getElementAt(posicion);
		          
		            Pago p=new Pago(controller);
		            p.setVisible(true);
		            dispose();
		            
		         }
		    }
		};
		list_1.addMouseListener(mouseListener);
		
		
	}
}