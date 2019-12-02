package biblioteca.vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import biblioteca.modelo.Autor;
import biblioteca.modelo.Libros;

public class TablaAutores extends AbstractTableModel {
	

	public String[] columnas={"Codigo", "Nombre","Apellido","Genero","Año Nacimiento", "Nacionalidad"};
	public Class[] columnasTipos={ String.class, String.class, String.class, String.class, String.class, String.class };
	private List<Autor> datos;
	
	public TablaAutores() {
		super();
		datos= new ArrayList<Autor>();
	}
	public TablaAutores(List<Autor> datos) {
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
		Autor dato=(Autor)(datos.get(row));
		switch(col){
		case 0:
			dato.setBib_per_id((int)value);
			break;
		case 1:
			dato.setBib_per_nombre((String) value);			
		
			break;
		case 2:
			dato.setBib_per_apellido((String) value);			
			break;
		case 3:
			dato.setBib_per_genero((String) value);			
			break;
		case 4:
			dato.setBib_per_fechaNac((String) value);			
			break;
		case 5:
			dato.setNacionalidad((String) value);			
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
		
		Autor dato=(Autor)(datos.get(row));
		switch(col){
		case 0:
			return dato.getBib_per_id();
		case 1:
			return dato.getBib_per_nombre();
		case 2:
			return dato.getBib_per_apellido();
		case 3:
			return dato.getBib_per_genero();
		case 4:
			return dato.getBib_per_fechaNac();
		case 5:
			return dato.getNacionalidad();
		default:
			break;
		}
		
		return new String();
	}
}

