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

public class VistaInsertar extends JInternalFrame implements ActionListener  {
	
	private JTextField txtbib_lib_id, txtlib_bib_nombre, txtbib_lib_autor, txtbib_lib_editorial, txtbib_lib_copias;
	private JLabel lblbib_lib_id, lblbib_lib_nombre, lblbib_lib_autor, lblbib_lib_editorial, lblbib_lib_copias;
	
	private JButton insertarLibros;

	private Operacion con;
	private Conexion co;
	
	public void initComponents(){
		
		setTitle(" INSERTAR ");
		setSize(1000,300);
		
	}
	
	public VistaInsertar(Operacion con, Conexion co) {
		this.co=co;
		this.con=con;
		initComponents();
		
		txtbib_lib_id = new JTextField(10);
		lblbib_lib_id = new JLabel(" Codigo ");
		
		txtlib_bib_nombre = new JTextField(10);
		lblbib_lib_nombre = new JLabel(" Nombre ");
		
		txtbib_lib_autor = new JTextField(10);
		lblbib_lib_autor= new JLabel(" Autor ");
				
		txtbib_lib_editorial = new JTextField(10);
		lblbib_lib_editorial= new JLabel(" Editorial ");
		
		txtbib_lib_copias = new JTextField(10);
		lblbib_lib_copias= new JLabel(" Copias ");
		
		insertarLibros = new JButton(" Insertar ");
		
		JPanel pan = new JPanel();
		
		Container cp1 = getContentPane();
		
		pan.setLayout(new GridBagLayout());
		GridBagConstraints cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 0;
		pan.add(lblbib_lib_id, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 0;
		pan.add(txtbib_lib_id, cp2);
		cp2.gridx = 2;
		cp2.gridy = 0;
		pan.add(lblbib_lib_nombre, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 3;
		cp2.gridy = 0;
		pan.add(txtlib_bib_nombre, cp2);
		cp2.gridx = 4;
		cp2.gridy = 0;
		pan.add(lblbib_lib_autor, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 5;
		cp2.gridy = 0;
		pan.add(txtbib_lib_autor, cp2);
		cp2.gridx = 6;
		cp2.gridy = 0;
		pan.add(lblbib_lib_editorial, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 7;
		cp2.gridy = 0;
		pan.add(txtbib_lib_editorial, cp2);
		cp2.gridx = 8;
		cp2.gridy = 0;
		pan.add(lblbib_lib_copias, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 9;
		cp2.gridy = 0;
		pan.add(txtbib_lib_copias, cp2);
		cp2.gridx = 10;
		cp2.gridy = 0;
		
		pan.add(insertarLibros, cp2);
		
		pan.setBorder(BorderFactory.createTitledBorder(" Insertar Libros "));
		cp1.add(pan, BorderLayout.NORTH);
				
		insertarLibros.addActionListener(this);
		insertarLibros.setActionCommand("libros");
			
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String comando = evt.getActionCommand();
		
		switch (comando) {
		case "libros":
			insertarLibros();
			break;
			
		}
	}

	private void insertarLibros() {
		// TODO Auto-generated method stub
				 
			con.insertarLibros(co, Integer.parseInt(txtbib_lib_id.getText()), txtlib_bib_nombre.getText(), txtbib_lib_autor.getText(), txtbib_lib_editorial.getText(), Integer.parseInt(txtbib_lib_copias.getText()));
			JOptionPane.showMessageDialog(this, " Guardado Corectamente ");
			txtbib_lib_id.setText("");
			txtlib_bib_nombre.setText("");
			txtbib_lib_autor.setText("");
			txtbib_lib_editorial.setText("");
			txtbib_lib_copias.setText("");
	}
	
}

