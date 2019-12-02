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
import biblioteca.controlador.OperacionEditorial;
import biblioteca.modelo.Editorial;
import biblioteca.modelo.Libros;

public class VistaModificarEditorial extends JInternalFrame implements ActionListener{
	
	
	private JComboBox txtbib_edi_codigo;
	private JTextField txtbib_edi_nombre,txtbib_edi_direccion,txtbib_edi_telf,txtbib_edi_ciudad;//id
	private JLabel lblbib_edi_codigo,lblbib_edi_nombre,lblbib_edi_direccion,lblbib_edi_telf,lblbib_edi_ciudad;//id
	

	private JButton modificarEditorial;
	
	private OperacionEditorial ope;
	private Conexion cone;
	private Operacion co;

	
	
public void initComponents(){
		
		setTitle(" MODIFICAR ");
		setSize(1000,300);
		
	}

public JComboBox getTxtbib_edi_codigo() {
	return txtbib_edi_codigo;
}


public void setTxtbib_edi_codigo(JComboBox txtbib_edi_codigo) {
	this.txtbib_edi_codigo = txtbib_edi_codigo;
}





	/*
	public JComboBox getTxtbib_edi_codigo() {
		return txtbib_edi_codigo;
	}



	public void settxtbib_edi_codigo(JComboBox txtbib_edi_codigo) {
		this.txtbib_edi_codigo = txtbib_edi_codigo;
	}
	
	*/
	public VistaModificarEditorial(OperacionEditorial ope, Conexion cone){
		this.ope=ope;
		this.cone=cone;
		initComponents();
		
		txtbib_edi_codigo = new JComboBox(this.cargaComboId());
		lblbib_edi_codigo = new JLabel(" Codigo ");
		
		txtbib_edi_nombre = new JTextField(10);
		lblbib_edi_nombre = new JLabel(" Nombre ");
		
		txtbib_edi_direccion = new JTextField(10);
		lblbib_edi_direccion= new JLabel(" Direccion ");
				
		txtbib_edi_telf = new JTextField(10);
		lblbib_edi_telf= new JLabel(" Telefono ");
		
		txtbib_edi_ciudad = new JTextField(10);
		lblbib_edi_ciudad= new JLabel(" Ciudad ");
		
		modificarEditorial = new JButton(" Modificar ");
		
		JPanel pan = new JPanel();
		
		Container cp1 = getContentPane();
		
		pan.setLayout(new GridBagLayout());
		GridBagConstraints cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 0;
		pan.add(lblbib_edi_codigo, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 0;
		pan.add(txtbib_edi_codigo, cp2);
		cp2.gridx = 2;
		cp2.gridy = 0;
		pan.add(lblbib_edi_nombre, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 3;
		cp2.gridy = 0;
		pan.add(txtbib_edi_nombre, cp2);
		cp2.gridx = 4;
		cp2.gridy = 0;
		pan.add(lblbib_edi_direccion, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 5;
		cp2.gridy = 0;
		pan.add(txtbib_edi_direccion, cp2);
		cp2.gridx = 6;
		cp2.gridy = 0;
		pan.add(lblbib_edi_telf, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 7;
		cp2.gridy = 0;
		pan.add(txtbib_edi_telf, cp2);
		cp2.gridx = 8;
		cp2.gridy = 0;
		pan.add(lblbib_edi_ciudad, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 9;
		cp2.gridy = 0;
		pan.add(txtbib_edi_ciudad, cp2);
		cp2.gridx = 10;
		cp2.gridy = 0;
		
		pan.add(modificarEditorial, cp2);
		
		pan.setBorder(BorderFactory.createTitledBorder(" Modificar Libros "));
		cp1.add(pan, BorderLayout.NORTH);
		
		modificarEditorial.addActionListener(this);
		modificarEditorial.setActionCommand("meditorial");
			
	}
	

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String comando = evt.getActionCommand();
		
		switch (comando) {
		case "meditorial":
			modificarEditorial();
			break;
			
		}
	}

	private void modificarEditorial() {


		String codigo = (String) (txtbib_edi_codigo).getSelectedItem();
		
	
        ope.modificarEditorial
        (
        		cone,codigo, 
        		txtbib_edi_nombre.getText(), 
        		txtbib_edi_direccion.getText(), 
        		txtbib_edi_telf.getText(), 
        		txtbib_edi_ciudad.getText());
		JOptionPane.showMessageDialog(this, " Modificado Corectamente ");
		txtbib_edi_nombre.setText("");
		txtbib_edi_direccion.setText("");
		txtbib_edi_telf.setText("");
		txtbib_edi_ciudad.setText("");
		
	}

	public String[] cargaComboId() {
		this.ope.setEditorial(this.ope.cargarEditorial(cone));
		String[] retorno = new String[this.ope.getEditorial().size()];
        int i=0;
        for(Editorial ed: this.ope.getEditorial()) {
            retorno[i] = ed.getBib_edi_codigo();
            i++;
        }
        return retorno;
    }
}
