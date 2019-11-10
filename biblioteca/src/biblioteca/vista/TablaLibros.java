package biblioteca.vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import biblioteca.modelo.Libros;

public class TablaLibros extends AbstractTableModel {
	

	public String[] columnas={"Codigo", "Nombre","Autor","Editorial","Num. Copias"};
	public Class[] columnasTipos={ String.class, String.class, String.class, String.class, String.class };
	private List<Libros> datos;
	
	public TablaLibros() {
		super();
		datos= new ArrayList<Libros>();
	}
	public TablaLibros(List<Libros> datos) {
		super();
		this.datos=datos;
	}

	
	public int getColumnCount() {
		return columnas.length;
	}

	public int getRowCount() {
		return datos.size();
	}
	public void setValueAt(Object value, int row, int col){
		Libros dato=(Libros)(datos.get(row));
		switch(col){
		case 0:
			dato.setBib_lib_id((String)value);
			break;
		case 1:
			dato.setBib_lib_nombre((String) value);			
		
			break;
		case 2:
			dato.setBib_lib_autor((String) value);			
			break;
		case 3:
			dato.setBib_lib_editorial((String) value);			
			break;
		case 4:
			dato.setBib_lib_copias((String) value);			
			default:
			break;
		}
	}
	public String getColumnName(int col){
		return columnas[col];
	}
	public Class getColumnClass(int col){
		return columnasTipos[col];
	}
	

	@Override
	public Object getValueAt(int row, int col) {
		
		Libros dato=(Libros)(datos.get(row));
		switch(col){
		case 0:
			return dato.getBib_lib_id();
		case 1:
			return dato.getBib_lib_nombre();
		case 2:
			return dato.getBib_lib_autor();
		case 3:
			return dato.getBib_lib_editorial();
		case 4:
			return dato.getBib_lib_copias();
			default:
			break;
		}
		
		return new String();
	}
}

