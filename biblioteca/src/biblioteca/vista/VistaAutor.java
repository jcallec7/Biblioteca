package biblioteca.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import biblioteca.controlador.Operacion;
import biblioteca.controlador.OperacionAutor;
import biblioteca.gestion.Conexion;
import biblioteca.modelo.Autor;
import biblioteca.modelo.Libros;

public class VistaAutor extends JInternalFrame  implements ActionListener {

	private JTextField txtAutor;
	//private JLabel codigoAutor;
	private final JButton insertarAutor;
	private final JButton consultarAutor;
	private final JButton modificarAutor;
	private final JButton eliminarAutor;
	private JButton insertarAutor2;
	private JButton consultarAutor2;
	private JButton modificarAutor2;
	private JButton eliminarAutor2;
	private OperacionAutor op;
	private Conexion co;
	private JScrollPane scrollPane;
	private JSplitPane splitPane;
	private JPanel pan = new JPanel();
	//private JPanel pan1 = new JPanel();
	private JPanel pan2 = new JPanel();
	private Container cp1 = getContentPane();
	private GridBagConstraints cp2 = new GridBagConstraints();
	private JLabel lb_aut_nombre, lb_aut_apellido, lb_aut_genero, lb_aut_fechNac, lb_aut_nacionalidad;
	private JTextField txt_aut_nombre, txt_aut_nombre2, txt_aut_apellido, txt_aut_genero, txt_aut_fechNac, txt_aut_nacionalidad;
	private JLabel lb_aut_id, lb_aut_nombre3, lb_aut_apellido3, lb_aut_genero3, lb_aut_fechNac3, lb_aut_nacionalidad3;
	private JTextField txt_aut_nombre3, txt_aut_apellido3, txt_aut_genero3, txt_aut_fechNac3, txt_aut_nacionalidad3;
	private JComboBox combo_aut_id;
	private int contadorCombo = 0;
	private List<Autor> autores;
	private JTable tblautores;
	//private JFormattedTextField dateField = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
	
	
	
	public void initComponents() {
		
		setTitle(" Autor ");
		setSize(600,500);
		
	}
	
	public JComboBox getCombo_aut_id() {
		return combo_aut_id;
	}

	public void setCombo_aut_id(JComboBox combo_aut_id) {
		this.combo_aut_id = combo_aut_id;
	}

	public VistaAutor(OperacionAutor op, Conexion co) {
		this.co=co;
		this.op=op;
		initComponents();
		
		insertarAutor = new JButton(" Insertar Autor ");
		consultarAutor = new JButton(" Consultar Autor ");
		modificarAutor = new JButton(" Modificar Autor ");
		eliminarAutor = new JButton(" Eliminar Autor ");
		
		splitPane = new JSplitPane();
		//cp1.setLayout(new GridLayout());
		cp1.add(splitPane);
		
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);  
        splitPane.setDividerLocation(200);                    
        splitPane.setTopComponent(pan);
        splitPane.setBottomComponent(pan2); 
		
		pan.setLayout(new GridBagLayout());
		
		cp2.gridx = 0;
		cp2.gridy = 0;
		
		pan.add(insertarAutor, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 1;
		cp2.gridy = 0;
		
		pan.add(consultarAutor, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 2;
		cp2.gridy = 0;
		
		pan.add(modificarAutor, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 3;
		cp2.gridy = 0;
		
		pan.add(eliminarAutor, cp2);
		cp2 = new GridBagConstraints();
		cp2.gridx = 4;
		cp2.gridy = 0;
		
		pan.setBorder(BorderFactory.createTitledBorder(" Autor "));
		cp1.add(pan, BorderLayout.NORTH);
		
		insertarAutor.addActionListener(this);
		insertarAutor.setActionCommand("Insertar Autor");
		
		consultarAutor.addActionListener(this);
		consultarAutor.setActionCommand("Consultar Autor");
		
		modificarAutor.addActionListener(this);
		modificarAutor.setActionCommand("Modificar Autor");
		
		eliminarAutor.addActionListener(this);
		eliminarAutor.setActionCommand("Eliminar Autor");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String comando = e.getActionCommand();
		switch (comando) {
		case "Insertar Autor":
			insertar();
			break;
		case "Consultar Autor":
			consultar();
			break;
		case "Modificar Autor":
			modificar();
			break;
		case "Eliminar Autor":
			eliminar();
			break;
		case "Insertar Autor 2":
			insertar2();
			break;
		case "Consultar Autor 2":
			consultar2();
			break;
		case "Modificar Autor 2":
			modificar2();
			break;
		case "Eliminar Autor 2":
			eliminar2();
			break;
		default :
			break;
		}
		
	}
	
	private void insertar() {
		
		lb_aut_nombre = new JLabel(" Nombre ");
		txt_aut_nombre = new JTextField(20);
		lb_aut_apellido = new JLabel(" Apellido ");
		txt_aut_apellido = new JTextField(20);
		lb_aut_genero = new JLabel(" Genero ");
		txt_aut_genero = new JTextField(20);
		lb_aut_fechNac = new JLabel(" Fecha Nacimiento ");
		txt_aut_fechNac = new JTextField(20);
		lb_aut_nacionalidad = new JLabel(" Nacionalidad ");
		txt_aut_nacionalidad = new JTextField(20);
		
		insertarAutor2 = new JButton(" Insertar Autor ");
		
		pan2.removeAll();
		//pan2.setLayout(new BoxLayout(pan2, BoxLayout.Y_AXIS));
		pan2.setLayout(new GridBagLayout());
		
		//pan2.add(scrollPane);               
        //pan.add(pan2);
		
		GridBagConstraints cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 2;
		pan2.add(lb_aut_nombre, cp3);	
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 2;
		pan2.add(txt_aut_nombre, cp3);
		
		cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 3;
		pan2.add(lb_aut_apellido, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 3;
		pan2.add(txt_aut_apellido, cp3);
		
		cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 4;
		pan2.add(lb_aut_genero, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 4;
		pan2.add(txt_aut_genero, cp3);
		
		cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 5;
		pan2.add(lb_aut_fechNac, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 5;
		pan2.add(txt_aut_fechNac, cp3);
		
		cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 6;
		pan2.add(lb_aut_nacionalidad, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 6;
		pan2.add(txt_aut_nacionalidad, cp3);
		
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 7;
		pan2.add(insertarAutor2, cp3);
		
		//pan.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));     // we set the max height to 75 and the max width to (almost) unlimited
        //pan.setLayout(new BoxLayout(pan, BoxLayout.X_AXIS));   // X_Axis will arrange the content horizontally

		//cp1.add(pan2, BorderLayout.NORTH);
		
		insertarAutor2.addActionListener(this);
		insertarAutor2.setActionCommand("Insertar Autor 2");
		
        pack(); 
		
	}
	
	private void consultar() {
		
		//combo_aut_id = new JComboBox();
		//combo_aut_id.removeAll();
		
		txt_aut_nombre2 = new JTextField(20);
		
		
		consultarAutor2 = new JButton(" Consultar Autor ");
		
		pan2.removeAll();
		//pan2.setLayout(new BoxLayout(pan2, BoxLayout.Y_AXIS));
		pan2.setLayout(new GridBagLayout());
		
		//pan2.add(scrollPane);               
        //pan.add(pan2);
		
		GridBagConstraints cp3 = new GridBagConstraints();
		
		cp3.gridx = 0;
		cp3.gridy = 2;
		pan2.add(txt_aut_nombre2, cp3);
		
		cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 3;
		pan2.add(consultarAutor2, cp3);
		
		//pan.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));     // we set the max height to 75 and the max width to (almost) unlimited
        //pan.setLayout(new BoxLayout(pan, BoxLayout.X_AXIS));   // X_Axis will arrange the content horizontally

		//cp1.add(pan2, BorderLayout.NORTH);
		
		consultarAutor2.addActionListener(this);
		consultarAutor2.setActionCommand("Consultar Autor 2");
		
        pack();
		
	}
	
	private void modificar() {
		
		lb_aut_id = new JLabel(" ID ");
		
		if(contadorCombo < 1) {
			combo_aut_id = new JComboBox();
			combo_aut_id.removeAll();
			combo_aut_id = new JComboBox(this.cargaComboId());
			contadorCombo++;
		}
		
		lb_aut_nombre3 = new JLabel(" Nombre ");
		txt_aut_nombre3 = new JTextField(20);
		lb_aut_apellido3 = new JLabel(" Apellido ");
		txt_aut_apellido3 = new JTextField(20);
		lb_aut_genero3 = new JLabel(" Genero ");
		txt_aut_genero3 = new JTextField(20);
		lb_aut_fechNac3 = new JLabel(" Fecha Nacimiento ");
		txt_aut_fechNac3 = new JTextField(20);
		lb_aut_nacionalidad3 = new JLabel(" Nacionalidad ");
		txt_aut_nacionalidad3 = new JTextField(20);
		
		modificarAutor2 = new JButton(" Modificar Autor ");
		
		pan2.removeAll();
		//pan2.setLayout(new BoxLayout(pan2, BoxLayout.Y_AXIS));
		pan2.setLayout(new GridBagLayout());
		
		//pan2.add(scrollPane);               
        //pan.add(pan2);
		
		GridBagConstraints cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 1;
		pan2.add(lb_aut_id, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 1;
		pan2.add(combo_aut_id, cp3);
		
		cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 2;
		pan2.add(lb_aut_nombre3, cp3);	
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 2;
		pan2.add(txt_aut_nombre3, cp3);
		
		cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 3;
		pan2.add(lb_aut_apellido3, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 3;
		pan2.add(txt_aut_apellido3, cp3);
		
		cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 4;
		pan2.add(lb_aut_genero3, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 4;
		pan2.add(txt_aut_genero3, cp3);
		
		cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 5;
		pan2.add(lb_aut_fechNac3, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 5;
		pan2.add(txt_aut_fechNac3, cp3);
		
		cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 6;
		pan2.add(lb_aut_nacionalidad3, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 6;
		pan2.add(txt_aut_nacionalidad3, cp3);
		
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 7;
		pan2.add(modificarAutor2, cp3);
		
		//pan.setMaximumSize(new Dimension(Integer.MAX_VALUE, 75));     // we set the max height to 75 and the max width to (almost) unlimited
        //pan.setLayout(new BoxLayout(pan, BoxLayout.X_AXIS));   // X_Axis will arrange the content horizontally

		//cp1.add(pan2, BorderLayout.NORTH);
		
		
		modificarAutor2.addActionListener(this);
		modificarAutor2.setActionCommand("Modificar Autor 2");
		
        pack();
		
	}
	
	private void eliminar() {
		
		lb_aut_id = new JLabel(" ID ");
		
		if(contadorCombo < 1) {
			combo_aut_id = new JComboBox();
			combo_aut_id.removeAll();
			combo_aut_id = new JComboBox(this.cargaComboId());
			contadorCombo++;
		}
		
		eliminarAutor2 = new JButton(" Eliminar Autor ");
		
		pan2.removeAll();
		//pan2.setLayout(new BoxLayout(pan2, BoxLayout.Y_AXIS));
		pan2.setLayout(new GridBagLayout());
		
		GridBagConstraints cp3 = new GridBagConstraints();
		cp3.gridx = 0;
		cp3.gridy = 1;
		pan2.add(lb_aut_id, cp3);
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 1;
		pan2.add(combo_aut_id, cp3);
		
		cp3 = new GridBagConstraints();
		cp3.gridx = 1;
		cp3.gridy = 3;
		pan2.add(eliminarAutor2, cp3);
		
		eliminarAutor2.addActionListener(this);
		eliminarAutor2.setActionCommand("Eliminar Autor 2");
		
		pack();
		
	}
	
	private void insertar2() {
		// TODO Auto-generated method stub
		op.insertarAutor(co, txt_aut_nombre.getText(), txt_aut_apellido.getText(), txt_aut_genero.getText(), Integer.parseInt(txt_aut_fechNac.getText()), txt_aut_nacionalidad.getText() );
		JOptionPane.showMessageDialog(this, " Guardado Corectamente ");
		txt_aut_nombre.setText("");
		txt_aut_apellido.setText("");
		txt_aut_genero.setText("");
		txt_aut_fechNac.setText("");
		txt_aut_nacionalidad.setText("");
		contadorCombo--;
	}
	
	private void consultar2() {
		// TODO Auto-generated method stub
		autores = op.ConsultarAutor(co, txt_aut_nombre2.getText());
		//txt_aut_nombre2.setText("");
		pan2.removeAll();
		//pan2.setLayout(new BoxLayout(pan2, BoxLayout.Y_AXIS));
		pan2.setLayout( new BorderLayout());
		
		//pan2.setSize(200, 100);
		
		tblautores = new JTable();
        tblautores.setModel(new TablaLibros());
        
        JScrollPane scrollPaneTabla = new JScrollPane(tblautores);
        
        pan2.add(scrollPaneTabla, BorderLayout.CENTER);
        
        tblautores.setModel(new TablaAutores(autores));
        
        pack();
		
	}
	
	private void modificar2() {
		
		int codigo = Integer.parseInt((String) this.getCombo_aut_id().getSelectedItem());
		op.modificarAutor(co, codigo, txt_aut_nombre3.getText(), txt_aut_apellido3.getText(), txt_aut_genero3.getText(), Integer.parseInt(txt_aut_fechNac3.getText()), txt_aut_nacionalidad3.getText());
		JOptionPane.showMessageDialog(this, " Modificado Corectamente ");
		//txtbib_lib_id.setText("");
		txt_aut_nombre3.setText("");
		txt_aut_apellido3.setText("");
		txt_aut_genero3.setText("");
		txt_aut_fechNac3.setText("");
		txt_aut_nacionalidad3.setText("");		
	}
	
	private void eliminar2() {
		
		int codigo = Integer.parseInt((String) this.getCombo_aut_id().getSelectedItem());
		op.eliminarAutor(co, codigo);
		JOptionPane.showMessageDialog(this, " Eliminado Corectamente ");
		//txtbib_lib_id.setText("");	
	}
	
	public String[] cargaComboId() {
		this.op.setAutores(this.op.cargarAutores(co));
        String[] retorno = new String[this.op.getAutores().size()];
        int i = 0;
        for(Autor a: this.op.getAutores()) {
            retorno[i] = Integer.toString(a.getBib_per_id());
            i++;
        }
        return retorno;
    }
	
}
