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

import biblioteca.controlador.OperacionPrestamo;
import biblioteca.gestion.Conexion;
import biblioteca.modelo.Cliente;
import biblioteca.modelo.Libros;

public class VistaPrestamo extends JInternalFrame implements ActionListener {
	
	private JComboBox libBoxNombre;
	private JTextField txtCliId;
	private JLabel lblCliId, lblLibNombre;
	private JButton insertarPrestamo;
	
	private OperacionPrestamo op;
	private Conexion con;
	
	public void initComponents(){
		
		setTitle(" Prestamo ");
		setSize(1000,300);
		
	}


	public JComboBox getLibBoxNombre() {
		return libBoxNombre;
	}



	public void setLibBoxNombre(JComboBox libBoxNombre) {
		this.libBoxNombre = libBoxNombre;
	}



	public VistaPrestamo(OperacionPrestamo op, Conexion con) {
		
		this.con=con;
		this.op=op;
		initComponents();
		
		
		txtCliId = new JTextField(10);
		lblCliId = new JLabel(" ID Cliente ");
		
		libBoxNombre = new JComboBox(this.cargaComboNombre());
		lblLibNombre = new JLabel(" Libro ");
		
		insertarPrestamo = new JButton(" Realizar Prestamo ");
		
		JPanel pan = new JPanel();
		
		Container cp1 = getContentPane();
		
		pan.setLayout(new GridBagLayout());
		GridBagConstraints cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 0;
		
		pan.add(lblCliId, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 0;
		pan.add(txtCliId, cp2);
		cp2.gridx = 2;
		cp2.gridy = 0;
		
		pan.add(lblLibNombre, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 3;
		cp2.gridy = 0;
		pan.add(libBoxNombre, cp2);
		cp2.gridx = 4;
		cp2.gridy = 0;
		
		pan.add(insertarPrestamo, cp2);
		
		pan.setBorder(BorderFactory.createTitledBorder(" Insertar Prestamo "));
		cp1.add(pan, BorderLayout.NORTH);
				
		insertarPrestamo.addActionListener(this);
		insertarPrestamo.setActionCommand("prestamo");
		
		
	}


	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
		String comando = evt.getActionCommand();
		
		switch (comando) {
		case "prestamo":
			insertarPrestamo();
			break;
			
		}
		
	}
	
	private void insertarPrestamo() {
		
		// TODO Auto-generated method stub
		
		String nombre = (String) libBoxNombre.getSelectedItem();
		op.insertarPrestamo(con, Integer.parseInt(txtCliId.getText()), nombre);
		JOptionPane.showMessageDialog(this, " Guardado Corectamente ");
		txtCliId.setText("");
			
	}
	
	public String[] cargaComboNombre() {
		this.op.setLibros(this.op.cargarLibros(con));
        String[] retorno = new String[this.op.getLibros().size()];
        int i=0;
        for(Libros l: this.op.getLibros()) {
            retorno[i] = l.getBib_lib_nombre();
            i++;
        }
        return retorno;
    }

}
