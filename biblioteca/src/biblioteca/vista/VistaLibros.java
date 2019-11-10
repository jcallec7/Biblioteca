package biblioteca.vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import biblioteca.gestion.Conexion;
import biblioteca.controlador.Operacion;
import biblioteca.vista.TablaLibros;

public class VistaLibros extends JFrame {

	private Operacion con;
	private Conexion co;
	private JTable tblLibros;
	
	public VistaLibros(Operacion con, Conexion co) {
		this.con=con;
		this.co=co;
		setSize(500,200); 
        getContentPane().setLayout(new BorderLayout());
        
        
        JPanel pnlTitulo = new JPanel(new FlowLayout());
        JLabel lblTitulo = new JLabel("CONSULTA");
        pnlTitulo.add(lblTitulo);
        tblLibros=new JTable();
        tblLibros.setModel(new TablaLibros());
        
        JScrollPane scrollPaneTabla = new JScrollPane(tblLibros);

        getContentPane().add(pnlTitulo, BorderLayout.NORTH);
        getContentPane().add(scrollPaneTabla, BorderLayout.CENTER);
    	
    		tblLibros.setModel(new TablaLibros(con.getLibros()));
    		
	}
	
}
