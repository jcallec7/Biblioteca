package biblioteca.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biblioteca.gestion.Conexion;
import biblioteca.modelo.Libros;

public class OperacionPrestamo {
	
	private List<Libros> libros;


	private PreparedStatement sentencia = null;
	private ResultSet resultado = null;
	
	public OperacionPrestamo() {
		libros = new ArrayList<Libros>();
	}
	
public void insertarPrestamo(Conexion con, int id, String nombre) {
    	
    	try {
    		sentencia = con.conectar().prepareStatement("INSERT INTO bib_prestamo(bib_prest_lib_nombre, bib_prest_cli_id) VALUES(?,?)");
    		
    		sentencia.setString(1, nombre);
    		sentencia.setInt(2, id);
    		
    	
    		sentencia.executeUpdate();
    		
    		System.out.println("insertado");
    		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    }





	public List<Libros> cargarLibros(Conexion con) {
		
		//sentencia = con.conectar().prepareStatement("Select * From bib_libro");
		
		//Libros lb =  new Libros();
		try {
			sentencia = con.conectar().prepareStatement("Select * From bib_libro");
			//sentencia.setString(1, codigo);
			resultado = sentencia.executeQuery();
			//Libros lb =  new Libros();
			while(resultado.next()){
				Libros lb =  new Libros();
				lb.setBib_lib_id(resultado.getString("bib_lib_id"));
				lb.setBib_lib_nombre(resultado.getString("bib_lib_nombre"));
				lb.setBib_lib_autor(resultado.getString("bib_lib_autor"));
				lb.setBib_lib_editorial(resultado.getString("bib_lib_editorial"));
				lb.setBib_lib_copias(resultado.getString("bib_lib_copias"));
				
				libros.add(lb);
			   
			}
			
			} catch (SQLException e) {
			// TODO: handle exception
				e.printStackTrace();
		}
			
		return this.libros;
		
	}
	
	public List<Libros> getLibros() {
		return libros;
	}

	
	public void setLibros(List<Libros> libros) {
		this.libros = libros;
	}

}