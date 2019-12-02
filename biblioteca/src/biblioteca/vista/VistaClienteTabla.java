package biblioteca.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import biblioteca.gestion.Conexion;
import biblioteca.controlador.OperacionCliente;
import biblioteca.vista.TablaLibros;

public class VistaClienteTabla extends JFrame {

	private OperacionCliente op;
	private Conexion con;
	private JTable tblCliente;
	
	public VistaClienteTabla(OperacionCliente op, Conexion con) {
		this.op=op;
		this.con=con;
		setSize(500,200); 
        getContentPane().setLayout(new BorderLayout());
        
        
        JPanel pnlTitulo = new JPanel(new FlowLayout());
        JLabel lblTitulo = new JLabel("CONSULTA");
        pnlTitulo.add(lblTitulo);
        tblCliente=new JTable();
        tblCliente.setModel(new TablaLibros());
        
        JScrollPane scrollPaneTabla = new JScrollPane(tblCliente);

        getContentPane().add(pnlTitulo, BorderLayout.NORTH);
        getContentPane().add(scrollPaneTabla, BorderLayout.CENTER);
    	
    		tblCliente.setModel(new TablaCliente(op.getCliente()));
    		
	}
	
}
