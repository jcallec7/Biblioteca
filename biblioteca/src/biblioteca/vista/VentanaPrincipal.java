package biblioteca.vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import biblioteca.gestion.Conexion;
import biblioteca.controlador.*;
import biblioteca.modelo.*;
import biblioteca.vista.*;
import biblioteca.controlador.Operacion;
import biblioteca.vista.VistaBorrar;
import biblioteca.vista.VistaConsultar;
import biblioteca.vista.VistaInsertar;

public class VentanaPrincipal extends JFrame implements ActionListener  {
	
	private JDesktopPane escritorio;
	private Operacion op;
	private OperacionCliente opCli;
	private OperacionPrestamo opPres;
	private OperacionAutor opAu;
	private OperacionCategoria opCat;
	private OperacionEditorial opEdit;
	private JMenu archivo,cliente,prestamo,categoria,editorial;
	private JMenuItem consultas,insertar,borrar,modificar,insertarCliente,consultarCliente,borrarCliente,modificarCliente;
	private JMenuItem insertarPrestamo, devolucionPrestamo, autor, insertarCategoria, categorizar, insertarEd,borrarEditorial,modificarEd;
	private Conexion con;
	
	public  VentanaPrincipal(Operacion op, OperacionCliente opCli, OperacionPrestamo opPres, OperacionAutor opAu, OperacionCategoria opCat, OperacionEditorial opEdit, Conexion con) {
		this.op=op;
		this.con=con;
		this.opCli = opCli;
		this.opPres = opPres;
		this.opAu = opAu;
		this.opCat = opCat;
		this.opEdit = opEdit;
		initComponents();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	

	
	private void initComponents() {
		// TODO Auto-generated method stub
		setSize(1500,700);
		setTitle("Gestion Base Datos");
		getContentPane().setLayout(new BorderLayout());
		escritorio = new JDesktopPane();		
		getContentPane().add(escritorio, BorderLayout.CENTER);
		
		JMenuBar barra = new JMenuBar();
		
		
		archivo = new JMenu("Libro");
		
		consultas = new JMenuItem("Consultar");
		consultas.addActionListener(this);
		consultas.setActionCommand("consultar");
		archivo.add(consultas);
		
		insertar = new JMenuItem(" Insertar ");
		insertar.addActionListener(this);
		insertar.setActionCommand("insertar");
		archivo.add(insertar);
		
		borrar = new JMenuItem(" Borrar ");
		borrar.addActionListener(this);
		borrar.setActionCommand("borrar");
		archivo.add(borrar);
		
		modificar = new JMenuItem(" Modificar ");
		modificar.addActionListener(this);
		modificar.setActionCommand("modificar");
		archivo.add(modificar);
		
		
		cliente = new JMenu("Cliente");
		
		insertarCliente = new JMenuItem(" Insertar ");
		insertarCliente.addActionListener(this);
		insertarCliente.setActionCommand("insertarCliente");
		
		consultarCliente = new JMenuItem(" Consultar ");
		consultarCliente.addActionListener(this);
		consultarCliente.setActionCommand("consultarCliente");
		
		borrarCliente = new JMenuItem(" Borrar ");
		borrarCliente.addActionListener(this);
		borrarCliente.setActionCommand("borrarCliente");
		
		modificarCliente = new JMenuItem(" Modificar ");
		modificarCliente.addActionListener(this);
		modificarCliente.setActionCommand("modificarCliente");
		
		cliente.add(insertarCliente);
		cliente.add(consultarCliente);
		cliente.add(borrarCliente);
		cliente.add(modificarCliente);
		
		
		
		
		prestamo = new JMenu("Prestamo");
		
		insertarPrestamo = new JMenuItem("Realizar Prestamo");
		insertarPrestamo.addActionListener(this);
		insertarPrestamo.setActionCommand("insertarPrestamo");
		
		devolucionPrestamo = new JMenuItem("Devolución Prestamo");
		devolucionPrestamo.addActionListener(this);
		devolucionPrestamo.setActionCommand("devolucionPrestamo");
		
		prestamo.add(insertarPrestamo);
		prestamo.add(devolucionPrestamo);
		
		
		
		autor = new JMenuItem(" Autor ");
		autor.addActionListener(this);
		autor.setActionCommand("autor");
		
		
		categoria = new JMenu("Categoria");
		
		insertarCategoria = new JMenuItem(" Insertar Categoria ");
		insertarCategoria.addActionListener(this);
		insertarCategoria.setActionCommand("categoria");
		
		categorizar = new JMenuItem("Categorizar");
		categorizar.addActionListener(this);
		categorizar.setActionCommand("categoriza");
		
		categoria.add(insertarCategoria);
		categoria.add(categorizar);
		
		
		editorial = new JMenu("Editorial");
		
		insertarEd = new JMenuItem("Insertar Editorial");
		insertarEd.addActionListener(this);
		insertarEd.setActionCommand("editorial");
		editorial.add(insertarEd);
		
		
		borrarEditorial = new JMenuItem("Borrar Editorial");
		borrarEditorial.addActionListener(this);
		borrarEditorial.setActionCommand("beditorial");
		editorial.add(borrarEditorial);
		
	
		modificarEd = new JMenuItem("Modificar Editorial ");
		modificarEd.addActionListener(this);
		modificarEd.setActionCommand("meditorial");
		editorial.add(modificarEd);
		
		barra.add(archivo);
		barra.add(categoria);
		barra.add(cliente);
		barra.add(editorial);
		barra.add(prestamo);
		barra.add(autor);
		
		setJMenuBar(barra);
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String comando = e.getActionCommand();
		switch (comando) {
		case "consultar":
			consultar();
			break;
		case "insertar":
			insertar();
			break;
		case "borrar":
			borrar();
			break;
		case "modificar":
			modificar();
			break;
		case "insertarCliente":
			insertarCliente();
			break;
		case "consultarCliente":
			consultarCliente();
			break;
		case "modificarCliente":
			modificarCliente();
			break;
		case "borrarCliente":
			borrarCliente();
			break;
		case "insertarPrestamo":
			insertarPrestamo();
			break;
		case "autor":
			autor();
			break;
		case "categoria":
			insertCategoria();
			break;
		case "categoriza":
			insertCategoriza();
			break;
		case "editorial":
			insertarEd();
			break;
		case "beditorial":
			borrarEditorial();
			break;
		case "meditorial":
			modificarEditorial();
			break;
			default :
			break;
		}
		
		
	}



	private void borrar() {
		// TODO Auto-generated method stub
		VistaBorrar br = new VistaBorrar(op, con);
		br.setVisible(true);
		escritorio.add(br);
		try {
			br.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}



	private void insertar() {
		// TODO Auto-generated method stub
		VistaInsertar in = new VistaInsertar(op, con);
		in.setVisible(true);
		escritorio.add(in);
		try {
			in.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}



	private void consultar() {
		// TODO Auto-generated method stub
		 VistaConsultar vc= new VistaConsultar(op,con);
 		vc.setVisible(true);
 		escritorio.add(vc);
 		try {
			vc.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	private void modificar() {
		// TODO Auto-generated method stub
		VistaModificar md = new VistaModificar(op, con);
		md.setVisible(true);
		escritorio.add(md);
		try {
			md.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	private void insertarCliente() {
		// TODO Auto-generated method stub
		VistaClienteInsertar crudCli = new VistaClienteInsertar(opCli, con);
		crudCli.setVisible(true);
		escritorio.add(crudCli);
		try {
			crudCli.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	private void consultarCliente() {
		// TODO Auto-generated method stub
		VistaClienteConsultar crudCli = new VistaClienteConsultar(opCli, con);
		crudCli.setVisible(true);
		escritorio.add(crudCli);
		try {
			crudCli.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	
	private void borrarCliente() {
		// TODO Auto-generated method stub
		VistaClienteBorrar crudCli = new VistaClienteBorrar(opCli, con);
		crudCli.setVisible(true);
		escritorio.add(crudCli);
		try {
			crudCli.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	private void modificarCliente() {
		// TODO Auto-generated method stub
		VistaClienteModificar crudCli = new VistaClienteModificar(opCli, con);
		crudCli.setVisible(true);
		escritorio.add(crudCli);
		try {
			crudCli.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	private void insertarPrestamo() {
		// TODO Auto-generated method stub
		VistaPrestamo in = new VistaPrestamo(opPres, con);
		in.setVisible(true);
		escritorio.add(in);
		try {
			in.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
	
	private void autor() {
		// TODO Auto-generated method stub
		VistaAutor in = new VistaAutor(opAu, con);
		in.setVisible(true);
		escritorio.add(in);
		try {
			in.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
	
	private void insertCategoria() {
		// TODO Auto-generated method stub
		VentanaInsertarCategoria in = new VentanaInsertarCategoria(opCat, con);
		in.setVisible(true);
		escritorio.add(in);
		try {
			in.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
	private void insertCategoriza() {
		// TODO Auto-generated method stub
		VistaCategorizacion in = new VistaCategorizacion (opCat, con);
		in.setVisible(true);
		escritorio.add(in);
		try {
			in.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}
	
	private void insertarEd() {
		// TODO Auto-generated method stub
		VistaInsertarEditorial ine = new VistaInsertarEditorial(opEdit, con);
		ine.setVisible(true);
		escritorio.add(ine);
		
				
		try {
			ine.setSelected(true);
		} catch (Exception e1) {			
			e1.printStackTrace();
		}
		
	}
	
	
	
	private void borrarEditorial() {
		// TODO Auto-generated method stub
		VistaBorrarEditorial bre = new VistaBorrarEditorial(opEdit,con);
		bre.setVisible(true);
		escritorio.add(bre);
		try {
			bre.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	private void modificarEditorial() {
		// TODO Auto-generated method stub
		VistaModificarEditorial md = new VistaModificarEditorial(opEdit, con);
		md.setVisible(true);
		escritorio.add(md);
		try {
			md.setSelected(true);
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
}

