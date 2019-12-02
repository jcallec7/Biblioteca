
package biblioteca.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biblioteca.gestion.Conexion;
import biblioteca.modelo.*;

public class OperacionAutor {
	
	private List<Autor> autoresConsulta;
	private List<Autor> autores;
	private Autor au;

	
	
	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}


	private PreparedStatement sentencia = null;
	private ResultSet resultado = null;
	
	public OperacionAutor() {
		autores = new ArrayList<Autor>();
	}
	
	public List<Autor> ConsultarAutor(Conexion con, String nombre) {
    	
		autoresConsulta = new ArrayList<Autor>();
		
    	try {
			sentencia = con.conectar().prepareStatement("SELECT bib_aut_id, bib_aut_nombre, bib_aut_apellido, bib_aut_genero, bib_aut_fech_nac, bib_aut_nacionalidad FROM biblioteca.bib_autor WHERE bib_aut_nombre LIKE '%"+nombre+"%' ");
			//sentencia.setString(1, nombre);
			resultado = sentencia.executeQuery();
			while(resultado.next()) {
				
				int id = Integer.parseInt(resultado.getString("bib_aut_id"));
				String nom = resultado.getString("bib_aut_nombre");
				String ape = resultado.getString("bib_aut_apellido");
				String gen = resultado.getString("bib_aut_genero");
				String an = resultado.getString("bib_aut_fech_nac");
				String nacionalidad = resultado.getString("bib_aut_nacionalidad");
				
				au = new Autor(id, nom, ape, gen, an);
				au.setNacionalidad(nacionalidad);
				
				autoresConsulta.add(au);
			}
		} catch (SQLException e) {
			// TODO: handle exception
				e.printStackTrace();
		}
    	return autoresConsulta;
    }
    
   
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
    
    public void eliminarAutor(Conexion con, int codigo) {
    	try {
    		sentencia = con.conectar().prepareStatement("DELETE FROM bib_autor WHERE bib_aut_id = ? ");
    		
    		sentencia.setInt(1, codigo);
    		sentencia.executeUpdate();
    		//System.out.println("borrado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    }
    
    public void modificarAutor(Conexion con, int codigo, String nombre, String apellido, String genero, int anio, String nacionalidad) {
    	try {	
    		sentencia = con.conectar().prepareStatement("UPDATE bib_autor SET bib_aut_nombre =?, bib_aut_apellido=?, bib_aut_genero=?, bib_aut_fech_nac=?, bib_aut_nacionalidad=?" + " WHERE bib_aut_id =?");
    		sentencia.setString(1, nombre);
    		sentencia.setString(2, apellido);
    		sentencia.setString(3, genero);
    		sentencia.setInt(4, anio);
    		sentencia.setString(5, nacionalidad);
    		sentencia.setInt(6, codigo);
    		sentencia.executeUpdate();
    		System.out.println("modificado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    }
    
    public List<Autor> cargarAutores(Conexion con) {
    		
		//sentencia = con.conectar().prepareStatement("Select * From bib_libro");
		
		//Libros lb =  new Libros();
    	try {
			sentencia = con.conectar().prepareStatement("SELECT * FROM biblioteca.bib_autor");
			//sentencia.setString(1, nombre);
			resultado = sentencia.executeQuery();
			while(resultado.next()) {
				
				int id = Integer.parseInt(resultado.getString("bib_aut_id"));
				String nom = resultado.getString("bib_aut_nombre");
				String ape = resultado.getString("bib_aut_apellido");
				String gen = resultado.getString("bib_aut_genero");
				String an = resultado.getString("bib_aut_fech_nac");
				String nacionalidad = resultado.getString("bib_aut_nacionalidad");
				
				au = new Autor(id, nom, ape, gen, an);
				au.setNacionalidad(nacionalidad);
				
				autores.add(au);
			}
		} catch (SQLException e) {
			// TODO: handle exception
				e.printStackTrace();
		}
    		
    	return this.autores;
    	
    }
    
	
	

}

