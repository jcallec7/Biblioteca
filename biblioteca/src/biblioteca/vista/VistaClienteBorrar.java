package biblioteca.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import biblioteca.gestion.Conexion;
import biblioteca.controlador.OperacionCliente;

public class VistaClienteBorrar extends JInternalFrame implements ActionListener {

	private JTextField txtidCliente;
	private JLabel lblidCliente;
	private JButton borrarCliente;
	private OperacionCliente op;
	private Conexion con;
	

	public void initComponents(){
		
		setTitle(" BORRAR");
		setSize(500,200);
		
		
	}
	public VistaClienteBorrar(OperacionCliente op, Conexion con) {
		
		 this.con=con;
			// TODO Auto-generated constructor stub
			this.op=op;
			initComponents();
			
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			txtidCliente= new JTextField(10);
			lblidCliente = new JLabel(" Id Cliente ");
			borrarCliente = new JButton(" Borrar"	);
			
			 JPanel pan = new JPanel();

				Container cp1 = getContentPane();
				

				pan.setLayout(new GridBagLayout());
				GridBagConstraints cp2 = new GridBagConstraints();
				cp2.gridx = 0;
				cp2.gridy = 0;
				pan.add(lblidCliente, cp2);
				cp2 = new GridBagConstraints();
				cp2.gridx = 2;
				cp2.gridy = 0;
				pan.add(txtidCliente, cp2);

				cp2 = new GridBagConstraints();
				cp2.gridx = 3;
				cp2.gridy = 0;
				pan.add(borrarCliente, cp2);
				
				cp1.add(pan, BorderLayout.NORTH);
				
				borrarCliente.addActionListener(this);
				borrarCliente.setActionCommand("borrarCliente");
				
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String comando= evt.getActionCommand();
		switch(comando){
		case "borrarCliente":
			borrarCliente();
			break;
		}
		
	}
	private void borrarCliente() {
		// TODO Auto-generated method stub
		op.borrarCliente(con, Integer.parseInt(txtidCliente.getText()));
		JOptionPane.showMessageDialog(this, " Borrado Corectamente ");
		txtidCliente.setText("");
		
	}
}

