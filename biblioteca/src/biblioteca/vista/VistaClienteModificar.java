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

import biblioteca.controlador.OperacionCliente;
import biblioteca.gestion.Conexion;
import biblioteca.modelo.Cliente;

public class VistaClienteModificar extends JInternalFrame implements ActionListener {
	
	private JTextField txtid, txtnombre, txtapellido, txtgenero, txtfechaNac, txtcorreo, txtdireccion;
	private JLabel lblid, lblnombre, lblapellido, lblgenero, lblfechaNac, lblcorreo, lbldireccion;
	private JComboBox txtBoxId;
	private JButton insertarCliente;
	
	private OperacionCliente op;
	private Conexion con;
	
	public void initComponents(){
		
		setTitle(" Modificar ");
		setSize(1500,300);
		
	}
	
	
	


	public JComboBox getTxtBoxId() {
		return txtBoxId;
	}





	public void setTxtBoxId(JComboBox txtBoxId) {
		this.txtBoxId = txtBoxId;
	}





	public VistaClienteModificar(OperacionCliente op, Conexion con) {
		
		this.con=con;
		this.op=op;
		initComponents();
		
		txtBoxId = new JComboBox(this.cargaComboId());
		lblid = new JLabel(" Cédula ");
		
		txtnombre = new JTextField(10);
		lblnombre = new JLabel(" Nombre ");
		
		txtapellido = new JTextField(10);
		lblapellido = new JLabel(" Apellido ");
		
		txtgenero = new JTextField(10);
		lblgenero = new JLabel(" Género ");
		
		txtfechaNac = new JTextField(10);
		lblfechaNac = new JLabel(" Fecha de Nacimiento ");
		
		txtcorreo = new JTextField(10);
		lblcorreo = new JLabel(" Correo ");
		
		txtdireccion = new JTextField(10);
		lbldireccion = new JLabel(" Dirección ");
		
		insertarCliente = new JButton(" Insertar ");
		
		JPanel pan = new JPanel();
		
		Container cp1 = getContentPane();
		
		pan.setLayout(new GridBagLayout());
		GridBagConstraints cp2 = new GridBagConstraints();
		cp2.gridx = 0;
		cp2.gridy = 0;
		
		pan.add(lblid, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 0;
		pan.add(txtBoxId, cp2);
		cp2.gridx = 2;
		cp2.gridy = 0;
		
		pan.add(lblnombre, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 3;
		cp2.gridy = 0;
		pan.add(txtnombre, cp2);
		cp2.gridx = 4;
		cp2.gridy = 0;
		
		pan.add(lblapellido, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 5;
		cp2.gridy = 0;
		pan.add(txtapellido, cp2);
		cp2.gridx = 6;
		cp2.gridy = 0;
		
		pan.add(lblgenero, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 7;
		cp2.gridy = 0;
		pan.add(txtgenero, cp2);
		cp2.gridx = 8;
		cp2.gridy = 0;
		
		pan.add(lblfechaNac, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 9;
		cp2.gridy = 0;
		pan.add(txtfechaNac, cp2);
		cp2.gridx = 10;
		cp2.gridy = 0;
		
		pan.add(lblcorreo, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 11;
		cp2.gridy = 0;
		pan.add(txtcorreo, cp2);
		cp2.gridx = 12;
		cp2.gridy = 0;
		
		pan.add(lbldireccion, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 13;
		cp2.gridy = 0;
		pan.add(txtdireccion, cp2);
		cp2.gridx = 14;
		cp2.gridy = 0;
		
		pan.add(insertarCliente, cp2);
		
		pan.setBorder(BorderFactory.createTitledBorder(" Insertar Cliente "));
		cp1.add(pan, BorderLayout.NORTH);
				
		insertarCliente.addActionListener(this);
		insertarCliente.setActionCommand("cliente");
			
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String comando = evt.getActionCommand();
		
		switch (comando) {
		case "cliente":
			modificarCliente();
			break;
			
		}
	}

	private void modificarCliente() {
		
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt((String) txtBoxId.getSelectedItem());
		op.modificarCliente(con, id, txtnombre.getText(), txtapellido.getText(), txtgenero.getText(), txtfechaNac.getText(), txtcorreo.getText(), txtdireccion.getText());
		JOptionPane.showMessageDialog(this, " Guardado Corectamente ");
		txtnombre.setText("");
		txtapellido.setText("");
		txtgenero.setText("");
		txtfechaNac.setText("");
		txtcorreo.setText("");
		txtdireccion.setText("");
			
	}
	
	public String[] cargaComboId() {
		this.op.setCliente(this.op.cargarCliente(con));
        String[] retorno = new String[this.op.getCliente().size()];
        int i=0;
        for(Cliente cli: this.op.getCliente()) {
            retorno[i] = Integer.toString(cli.getBib_per_id());
            i++;
        }
        return retorno;
    }
	
}


