
package biblioteca.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biblioteca.gestion.Conexion;
import biblioteca.modelo.*;

public class OperacionAutor {
	
	private List<Autor> autores;


	private PreparedStatement sentencia = null;
	private ResultSet resultado = null;
	
	public OperacionAutor() {
		autores = new ArrayList<Autor>();
	}
	
	/*public void ConsultarLibros(Conexion con, String codigo) {
  
    	Libros lb =  new Libros();
    	try {
			sentencia = con.conectar().prepareStatement("SELECT bib_lib_id, bib_lib_nombre, bib_lib_autor, bib_lib_editorial, bib_lib_copias FROM biblioteca.bib_libro WHERE bib_lib_id = ? ");
			sentencia.setString(1, codigo);
			resultado = sentencia.executeQuery();
			while(resultado.next()) {
				
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
    }*/
    
   
    public void insertarAutor(Conexion con, String nombre, String apellido, String genero, int anio, String nacionalidad) {
    	try {
    		sentencia = con.conectar().prepareStatement("INSERT INTO bib_autor(bib_aut_nombre, bib_aut_apellido, bib_aut_genero, bib_aut_fech_nac, bib_aut_nacionalidad) VALUES(?,?,?,?,?)");
    		//sentencia.setInt(1, codigo);
    		sentencia.setString(1, nombre);
    		sentencia.setString(2, apellido);
    		sentencia.setString(3, genero);
    		sentencia.setInt(4, anio);
    		sentencia.setString(5, nacionalidad);
    		sentencia.executeUpdate();
    		System.out.println("insertado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    }
    
    /*public void borrarLibros(Conexion con, String codigo) {
    	try {
    		sentencia = con.conectar().prepareStatement("DELETE FROM bib_libro WHERE bib_lib_id = ? ");
    		
    		sentencia.setString(1, codigo);
    		sentencia.executeUpdate();
    		System.out.println("borrado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    }*/
    
    /*public void modificarLibros(Conexion con, int codigo, String nombre, String autor, String editorial, int copias) {
    	try {
    		
    		sentencia = con.conectar().prepareStatement("UPDATE bib_libro SET bib_lib_nombre =?, bib_lib_autor=?, bib_lib_editorial=?, bib_lib_copias=?" + " WHERE bib_lib_id =?");
    		sentencia.setString(1, nombre);
    		sentencia.setString(2, autor);
    		sentencia.setString(3, editorial);
    		sentencia.setInt(4, copias);
    		sentencia.setInt(5, codigo);
    		sentencia.executeUpdate();
    		System.out.println("modificado");
    		System.out.println(nombre + autor + editorial + copias + codigo);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    }*/
    
    /*public List<Libros> cargarLibros(Conexion con) {
    		
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
    	
    }*/
    
	
	

}

