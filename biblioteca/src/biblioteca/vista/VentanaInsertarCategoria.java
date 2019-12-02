package biblioteca.vista;

import biblioteca.gestion.*;
import biblioteca.controlador.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInsertarCategoria extends JInternalFrame implements ActionListener
{
	private JTextField txtbib_cat_codigo, txtlib_cat_nombre,
	txtbib_cat_descr;
	
	private JLabel lblbib_cat_codigo, lblbib_cat_nombre, lblbib_cat_descr;
	private JButton insertarCategoria;
	
	private OperacionCategoria con;
	private Conexion co;
	
	public void initComponents(){
		
		setTitle(" INSERTAR ");
		setSize(1000,300);
		
	}
	
	public VentanaInsertarCategoria(OperacionCategoria con, Conexion co) 
	{
		this.co=co;
		this.con=con;
		initComponents();
		
		txtbib_cat_codigo = new JTextField(10);
		lblbib_cat_codigo = new JLabel(" Codigo ");
		
		txtlib_cat_nombre = new JTextField(10);
		lblbib_cat_nombre = new JLabel(" Nombre ");
		
		txtbib_cat_descr = new JTextField(10);
		lblbib_cat_descr= new JLabel(" descripcion ");
		
		insertarCategoria= new JButton ("Insertar");
		
		JPanel pan = new JPanel();
		
		Container cp1= getContentPane();
		
		pan.setLayout(new GridBagLayout());
		
		GridBagConstraints cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 0;
		pan.add(lblbib_cat_codigo, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 0;
		pan.add(txtbib_cat_codigo, cp2);
		
		cp2.gridx = 2;
		cp2.gridy = 0;
		pan.add(lblbib_cat_nombre, cp2);	
		cp2 = new GridBagConstraints();
		cp2.gridx = 3;
		cp2.gridy = 0;
		pan.add(txtlib_cat_nombre, cp2);
		
		cp2.gridx = 4;
		cp2.gridy = 0;
		pan.add(lblbib_cat_descr, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 5;
		cp2.gridy = 0;
		pan.add(txtbib_cat_descr, cp2);
		cp2.gridx = 6;
		cp2.gridy = 0;
		
		pan.add(insertarCategoria,cp2);
		
		
		pan.setBorder(BorderFactory.createTitledBorder(" Insertar Categoria "));
		cp1.add(pan, BorderLayout.NORTH);
		
		insertarCategoria.addActionListener(this);
		insertarCategoria.setActionCommand("categoria");
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		 String comando =evt.getActionCommand();
		 
		 switch (comando) {
			case "categoria":
				insertarCategoria();
				break;
				
			}
		
	}
	private void insertarCategoria() {
		// TODO Auto-generated method stub
				 
			con.insertarCategoria(co, Integer.parseInt(txtbib_cat_codigo.getText()),
					txtlib_cat_nombre.getText(), 
					txtbib_cat_descr.getText());
			JOptionPane.showMessageDialog(this, " Guardado Corectamente ");
			txtbib_cat_codigo.setText("");
			txtlib_cat_nombre.setText("");
			txtbib_cat_descr.setText("");
			
	}
	
}
