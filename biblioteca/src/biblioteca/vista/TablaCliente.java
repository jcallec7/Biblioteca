package biblioteca.vista;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import biblioteca.modelo.Cliente;

public class TablaCliente extends AbstractTableModel {
	

	public String[] columnas={"id", "Nombre","Apellido","Genero","Fecha de Nacimiento","Correo","Direccion"};
	public Class[] columnasTipos={ String.class, String.class, String.class, String.class, String.class, String.class, String.class };
	private List<Cliente> datos;
	
	public TablaCliente() {
		super();
		datos= new ArrayList<Cliente>();
	}
	public TablaCliente(List<Cliente> datos) {
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
		Cliente dato=(Cliente)(datos.get(row));
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
			dato.setBib_cli_correo((String) value);
			break;
		case 6:
			dato.setBib_cli_direccion((String) value);			
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
		
		Cliente dato=(Cliente)(datos.get(row));
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
			return dato.getBib_cli_correo();
		case 6:
			return dato.getBib_cli_direccion();
			default:
			break;
		}
		
		return new String();
	}
}

