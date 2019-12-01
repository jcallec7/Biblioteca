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

import biblioteca.gestion.Conexion;
import biblioteca.controlador.Operacion;
import biblioteca.modelo.Libros;

public class VistaModificar extends JInternalFrame implements ActionListener  {
	
	private JComboBox txtbib_lib_id;
	private JTextField txtlib_bib_nombre, txtbib_lib_autor, txtbib_lib_editorial, txtbib_lib_copias;
	private JLabel lblbib_lib_id, lblbib_lib_nombre, lblbib_lib_autor, lblbib_lib_editorial, lblbib_lib_copias;
	
	private JButton modificarLibros;

	private Operacion con;
	private Conexion co;
	
	public void initComponents(){
		
		setTitle(" MODIFICAR ");
		setSize(1000,300);
		
	}
	
	
	
	public JComboBox getTxtbib_lib_id() {
		return txtbib_lib_id;
	}



	public void setTxtbib_lib_id(JComboBox txtbib_lib_id) {
		this.txtbib_lib_id = txtbib_lib_id;
	}



	public VistaModificar(Operacion con, Conexion co) {
		this.co=co;
		this.con=con;
		initComponents();
		
		txtbib_lib_id = new JComboBox(this.cargaComboId());
		lblbib_lib_id = new JLabel(" Codigo ");
		
		txtlib_bib_nombre = new JTextField(10);
		lblbib_lib_nombre = new JLabel(" Nombre ");
		
		txtbib_lib_autor = new JTextField(10);
		lblbib_lib_autor= new JLabel(" Autor ");
				
		txtbib_lib_editorial = new JTextField(10);
		lblbib_lib_editorial= new JLabel(" Editorial ");
		
		txtbib_lib_copias = new JTextField(10);
		lblbib_lib_copias= new JLabel(" Copias ");
		
		modificarLibros = new JButton(" Modificar ");
		
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
		
		pan.add(modificarLibros, cp2);
		
		pan.setBorder(BorderFactory.createTitledBorder(" Modificar Libros "));
		cp1.add(pan, BorderLayout.NORTH);
		
		modificarLibros.addActionListener(this);
		modificarLibros.setActionCommand("libros");
			
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String comando = evt.getActionCommand();
		
		switch (comando) {
		case "libros":
			modificarLibros();
			break;
			
		}
	}

	private void modificarLibros() {
		// TODO Auto-generated method stub
				 
			int codigo = this.getTxtbib_lib_id().getSelectedIndex() + 1;
			con.modificarLibros(co, codigo, txtlib_bib_nombre.getText(), txtbib_lib_autor.getText(), txtbib_lib_editorial.getText(), Integer.parseInt(txtbib_lib_copias.getText()));
			JOptionPane.showMessageDialog(this, " Modificado Corectamente ");
			//txtbib_lib_id.setText("");
			txtlib_bib_nombre.setText("");
			txtbib_lib_autor.setText("");
			txtbib_lib_editorial.setText("");
			txtbib_lib_copias.setText("");
	}
	
	public String[] cargaComboId() {
		this.con.setLibros(this.con.cargarLibros(co));
        String[] retorno = new String[this.con.getLibros().size()];
        int i=0;
        for(Libros l: this.con.getLibros()) {
            retorno[i] = l.getBib_lib_id();
            i++;
        }
        return retorno;
    }
	
}

