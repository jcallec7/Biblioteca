package biblioteca.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import biblioteca.gestion.Conexion;
import biblioteca.controlador.Operacion;
import biblioteca.controlador.OperacionEditorial;


	public class VistaInsertarEditorial extends JInternalFrame implements ActionListener{
	
	private JTextField txtbib_edi_codigo,txtbib_edi_nombre,txtbib_edi_direccion,txtbib_edi_telf,txtbib_edi_ciudad;//id
	private JLabel lblbib_edi_codigo,lblbib_edi_nombre,lblbib_edi_direccion,lblbib_edi_telf,lblbib_edi_ciudad;//id
	
	private JButton insertarEditorial;

	private OperacionEditorial ope;
	private Conexion cone;
	private Operacion co;

	
	public void initComponents(){
		
		setTitle(" INSERTAR ");
		setSize(1000,300);
		
	}
	
	public VistaInsertarEditorial(OperacionEditorial ope, Conexion cone) {
		this.ope=ope;
		this.cone=cone;
		
		initComponents();
		
		txtbib_edi_codigo = new JTextField(10);
		lblbib_edi_codigo = new JLabel(" Codigo ");
		
		txtbib_edi_nombre = new JTextField(10);
		lblbib_edi_nombre = new JLabel(" Nombre ");
		
		txtbib_edi_direccion = new JTextField(10);
		lblbib_edi_direccion= new JLabel(" Direccion ");
				
		txtbib_edi_telf = new JTextField(10);
		lblbib_edi_telf= new JLabel(" Telefono ");
		
		txtbib_edi_ciudad = new JTextField(10);
		lblbib_edi_ciudad= new JLabel(" Ciudad ");
		
		insertarEditorial = new JButton(" Insertar ");
		
		JPanel pan = new JPanel();
		
		Container cp3 = getContentPane();
		
		pan.setLayout(new GridBagLayout());
		GridBagConstraints cp4 = new GridBagConstraints();
		cp4.gridx = 0;
		cp4.gridy = 0;
		pan.add(lblbib_edi_codigo, cp4);
		cp4 = new GridBagConstraints();
		cp4.gridx = 1;
		cp4.gridy = 0;
		pan.add(txtbib_edi_codigo, cp4);
		cp4.gridx = 2;
		cp4.gridy = 0;
		pan.add(lblbib_edi_nombre, cp4);
		cp4 = new GridBagConstraints();
		cp4.gridx = 3;
		cp4.gridy = 0;
		pan.add(txtbib_edi_nombre, cp4);
		cp4.gridx = 4;
		cp4.gridy = 0;
		pan.add(lblbib_edi_direccion, cp4);
		cp4 = new GridBagConstraints();
		cp4.gridx = 5;
		cp4.gridy = 0;
		pan.add(txtbib_edi_direccion, cp4);
		cp4.gridx = 6;
		cp4.gridy = 0;
		pan.add(lblbib_edi_telf, cp4);
		cp4 = new GridBagConstraints();
		cp4.gridx = 7;
		cp4.gridy = 0;
		pan.add(txtbib_edi_telf, cp4);
		cp4.gridx = 8;
		cp4.gridy = 0;
		pan.add(lblbib_edi_ciudad, cp4);
		cp4 = new GridBagConstraints();
		cp4.gridx = 9;
		cp4.gridy = 0;
		pan.add(txtbib_edi_ciudad, cp4);
		cp4.gridx = 10;
		cp4.gridy = 0;
		
		pan.add(insertarEditorial, cp4);
		
		pan.setBorder(BorderFactory.createTitledBorder(" Insertar Libros "));
		cp3.add(pan, BorderLayout.NORTH);
				
		insertarEditorial.addActionListener(this);
		insertarEditorial.setActionCommand("editorial");
		
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String comando = evt.getActionCommand();
		
		switch (comando) {
		case "editorial":
			insertarEditorial();
			break;
			
		}
	}

	private void insertarEditorial() {
		
	
			// TODO Auto-generated method stub
				
		        ope.insertarEditorial
		        (
		        		cone, 
		        		txtbib_edi_codigo.getText(), 
		        		txtbib_edi_nombre.getText(), 
		        		txtbib_edi_direccion.getText(), 
		        		txtbib_edi_telf.getText(), 
		        		txtbib_edi_ciudad.getText());
				JOptionPane.showMessageDialog(this, " Guardado Corectamente ");
				txtbib_edi_codigo.setText("");
				txtbib_edi_nombre.setText("");
				txtbib_edi_direccion.setText("");
				txtbib_edi_telf.setText("");
				txtbib_edi_ciudad.setText("");
		
		// TODO Auto-generated method stub
		
	}

	

}
