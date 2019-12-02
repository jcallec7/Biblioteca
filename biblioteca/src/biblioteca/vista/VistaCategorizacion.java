package biblioteca.vista;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import biblioteca.gestion.*;
import biblioteca.controlador.*;
import biblioteca.modelo.*;

public class VistaCategorizacion extends JInternalFrame implements ActionListener
{
	
	private JComboBox txtbib_cat_nombre;
	private JComboBox txtbib_lib_nombre;
	
	//private JTextField txtlib_cat_nombre, txtbib_libro_nombre;
	private JLabel lblbib_cat_nombre, lblbib_libro_nombre;
	
	private JButton categoriza;
	
	private OperacionCategoria con;
	private Conexion co;
	
	public void initComponents(){
			
			setTitle(" MODIFICAR ");
			setSize(1000,300);
			
	}
	
	

	//combo NOMBRE CATEGORIA
	public JComboBox getTxtbib_cat_nombre() {
		return txtbib_cat_nombre;
	}
	public void setTxtbib_lib_id(JComboBox txtbib_cat_nombre) {
		this.txtbib_cat_nombre = txtbib_cat_nombre;
	}
	
	//combo NOMBRE LIBRO
	public JComboBox getTxtbib_lib_nombre() {
		return txtbib_lib_nombre;
	}
	public void setTxtbib_lib_nombre(JComboBox txtbib_lib_nombre) {
		this.txtbib_lib_nombre = txtbib_lib_nombre;
	}
	
	public VistaCategorizacion(OperacionCategoria con, Conexion co)
	{
		this.co=co;
		this.con=con;
		initComponents();
		
		txtbib_cat_nombre = new JComboBox(this.cargaComboCategoria());
		lblbib_cat_nombre = new JLabel(" categoria ");
		
		txtbib_lib_nombre = new JComboBox(this.cargaComboLibro());
		lblbib_libro_nombre = new JLabel("libro");
		
		categoriza=new JButton("Categorizar");
		
JPanel pan = new JPanel();
		
		Container cp1 = getContentPane();
		
		pan.setLayout(new GridBagLayout());
		GridBagConstraints cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 0;
		pan.add(lblbib_cat_nombre, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 0;
		pan.add(txtbib_cat_nombre, cp2);
		cp2.gridx = 4;
		cp2.gridy = 0;
		pan.add(lblbib_libro_nombre, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 7;
		cp2.gridy = 0;
		pan.add(txtbib_lib_nombre, cp2);
		cp2.gridx = 10;
		cp2.gridy = 0;

		
		pan.add(categoriza, cp2);
		
		pan.setBorder(BorderFactory.createTitledBorder(" categorizar "));
		cp1.add(pan, BorderLayout.NORTH);
		
		categoriza.addActionListener(this);
		categoriza.setActionCommand("categoriza");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String comando = evt.getActionCommand();
		
		switch (comando) {
		case "categoriza":
			categorizando();
			break;
			
		}
	}

	private void categorizando() {
		// TODO Auto-generated method stub
		String nombreCat= (String) txtbib_cat_nombre.getSelectedItem();
		String nombreLib= (String) txtbib_lib_nombre.getSelectedItem();
		con.darCategoria(co,nombreLib,nombreCat);
		JOptionPane.showMessageDialog(this, " Guardado Corectamente ");
	}
	
	public String[] cargaComboCategoria() {
		con.setCategoria(con.cargarCategoria(co));
        String[] retorno = new String[this.con.getCategoria().size()];
        int i=0;
        for(Categoria l: this.con.getCategoria()) {
            retorno[i] = l.getCat_nombre();
            i++;
        }
        return retorno;
    }
	
	
	public String[] cargaComboLibro() {
		con.setLibros(con.cargarLibros(co));
        String[] retorno = new String[this.con.getLibros().size()];
        int i=0;
        for(Libros l: this.con.getLibros()) {
            retorno[i] = l.getBib_lib_nombre();
            i++;
        }
        return retorno;
    }
}
