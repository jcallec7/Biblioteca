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
import biblioteca.controlador.Operacion;

public class VistaBorrar extends JInternalFrame implements ActionListener {

	private JTextField txtLibro;
	private JLabel codigoLibro;
	private JButton borrarLibro;
	private Operacion con;
	private Conexion co;
	

	public void initComponents(){
		
		setTitle(" BORRAR");
		setSize(500,200);
		
		
	}
	public VistaBorrar(Operacion con, Conexion co) {
		
		 this.co=co;
			// TODO Auto-generated constructor stub
			this.con=con;
			initComponents();
			
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			txtLibro= new JTextField(10);
			codigoLibro = new JLabel(" Codigo Libro ");
			borrarLibro = new JButton(" Borrar"	);
			
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
				pan.add(borrarLibro, cp2);
				
				cp1.add(pan, BorderLayout.NORTH);
				
				borrarLibro.addActionListener(this);
				borrarLibro.setActionCommand("borrarLibro");
				
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String comando= evt.getActionCommand();
		switch(comando){
		case "borrarLibro":
			borrarJobs();
			break;
		}
		
	}
	private void borrarJobs() {
		// TODO Auto-generated method stub
		con.borrarLibros(co, txtLibro.getText());
		JOptionPane.showMessageDialog(this, " Borrado Corectamente ");
		txtLibro.setText("");
		
	}
}

