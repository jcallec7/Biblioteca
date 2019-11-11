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
import biblioteca.controlador.Operacion;
import biblioteca.vista.VistaLibros;

public class VistaConsultar  extends JInternalFrame  implements ActionListener{

	private JTextField txtLibro;
	private JLabel codigoLibro;
	private JButton consultarLibro;
	private Operacion con;
	private Conexion co;
	
	public void initComponents(){
		
		setTitle("CONSULTAR");
		setSize(500,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public  VistaConsultar(Operacion con, Conexion co) {
		 this.co=co;
		// TODO Auto-generated constructor stub
		this.con=con;
		initComponents();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		txtLibro= new JTextField(10);
		codigoLibro = new JLabel(" Codigo Libro ");
		consultarLibro = new JButton(" Consultar"	);
		
		 JPanel pan = new JPanel();

			Container cp1 = getContentPane();
			

			pan.setLayout(new GridBagLayout());
			GridBagConstraints cp2 = new GridBagConstraints();
			cp2.gridx = 0;
			cp2.gridy = 0;
			pan.add(codigoLibro, cp2);
			cp2 = new GridBagConstraints();
			cp2.gridx = 2;
			cp2.gridy = 0;
			pan.add(txtLibro, cp2);

			cp2 = new GridBagConstraints();
			cp2.gridx = 3;
			cp2.gridy = 0;
			pan.add(consultarLibro, cp2);
			
			cp1.add(pan, BorderLayout.NORTH);
			
			consultarLibro.addActionListener(this);
			consultarLibro.setActionCommand("consulta");
		
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
		con.ConsultarLibros(co, txtLibro.getText());
		VistaLibros tr= new VistaLibros(con, co);
		tr.setVisible(true);
	}

}