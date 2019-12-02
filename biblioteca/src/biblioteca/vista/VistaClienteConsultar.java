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
import javax.swing.JPanel;
import javax.swing.JTextField;

import biblioteca.gestion.Conexion;
import biblioteca.controlador.OperacionCliente;
import biblioteca.vista.VistaLibros;

public class VistaClienteConsultar  extends JInternalFrame  implements ActionListener{

	private JTextField txtidCliente;
	private JLabel lblidCliente;
	private JButton consultarCliente;
	private OperacionCliente op;
	private Conexion con;
	
	public void initComponents(){
		
		setTitle("CONSULTAR");
		setSize(500,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public  VistaClienteConsultar(OperacionCliente op, Conexion con) {
		 this.con=con;
		// TODO Auto-generated constructor stub
		this.op=op;
		initComponents();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		txtidCliente= new JTextField(10);
		lblidCliente = new JLabel(" Codigo Libro ");
		consultarCliente = new JButton(" Consultar"	);
		
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
			pan.add(consultarCliente, cp2);
			
			cp1.add(pan, BorderLayout.NORTH);
			
			consultarCliente.addActionListener(this);
			consultarCliente.setActionCommand("consulta");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		
		String comando= evt.getActionCommand();
		switch(comando){
		case "consulta":
			consultar();
			break;
		}
	}
	
	public void consultar() {
		op.consultarCliente(con, Integer.parseInt(txtidCliente.getText()));
		VistaClienteTabla tr= new VistaClienteTabla(op, con);
		tr.setVisible(true);
	}

}