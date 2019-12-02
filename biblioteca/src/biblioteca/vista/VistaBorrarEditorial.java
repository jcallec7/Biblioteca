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
import biblioteca.controlador.OperacionEditorial;

public class VistaBorrarEditorial extends JInternalFrame implements ActionListener{
	
	private JTextField txtEditorial;
	private JLabel txtbib_edi_codigo;
	private JButton borrarEditorial;
	
	
	private OperacionEditorial ope;
	private Conexion cone;
	private Operacion co;
	
	
	
	

	public void initComponents(){
		
		setTitle(" BORRAR");
		setSize(500,200);
		
	}
	
	
	public VistaBorrarEditorial(OperacionEditorial ope, Conexion cone) {
	
		 	this.ope=ope;
			this.cone=cone;
			initComponents();
			
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			txtEditorial= new JTextField(10);
			txtbib_edi_codigo = new JLabel(" Codigo Editorial ");
			borrarEditorial = new JButton(" Borrar"	);
			
			JPanel pan = new JPanel();

			Container cp1 = getContentPane();
			

			pan.setLayout(new GridBagLayout());
			GridBagConstraints cp2 = new GridBagConstraints();
			cp2.gridx = 0;
			cp2.gridy = 0;
			pan.add(txtbib_edi_codigo, cp2);
			cp2 = new GridBagConstraints();
			cp2.gridx = 2;
			cp2.gridy = 0;
			pan.add(txtEditorial, cp2);

			cp2 = new GridBagConstraints();
			cp2.gridx = 3;
			cp2.gridy = 0;
			pan.add(borrarEditorial, cp2);
			
			cp1.add(pan, BorderLayout.NORTH);
			
			borrarEditorial.addActionListener(this);
			borrarEditorial.setActionCommand("beditorial");

	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		// TODO Auto-generated method stub
		String comando= evt.getActionCommand();
		switch(comando){
		case "beditorial":
			borrarJobs();
			break;
		}

}
	private void borrarJobs() {
		// TODO Auto-generated method stub
		ope.borrarEditorial(cone, txtEditorial.getText());
		JOptionPane.showMessageDialog(this, " Borrado Corectamente ");
		txtEditorial.setText("");
		
	}
		
}
