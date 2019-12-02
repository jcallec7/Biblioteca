package biblioteca.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import biblioteca.gestion.Conexion;
import biblioteca.modelo.*;

public class OperacionEditorial {
	
	
	private static final String String = null;


	private List<Editorial> editorial;


	private PreparedStatement sentencia = null;
	private ResultSet resultado = null;
	
	public OperacionEditorial() {
		editorial = new ArrayList<Editorial>();
	}
	
    public void insertarEditorial(Conexion cone, String bib_edi_codigo, 
    		String bib_edi_nombre, String bib_edi_direccion, String bib_edi_telf, String bib_edi_ciudad ) {

    	try {
    		sentencia = cone.conectar().prepareStatement("INSERT INTO bib_editorial(bib_edi_codigo, "
    		+ "bib_edi_nombre, bib_edi_direccion, bib_edi_telf, bib_edi_ciudad) VALUES(?,?,?,?,?)");
    		sentencia.setString(1, bib_edi_codigo);
    		sentencia.setString(2, bib_edi_nombre);
    		sentencia.setString(3, bib_edi_direccion);
    		sentencia.setString(4, bib_edi_telf);
    		sentencia.setString(5, bib_edi_ciudad);
    		sentencia.executeUpdate();
    		System.out.println("insertado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    }
    
    
    public void borrarEditorial(Conexion cone, String codigo) {
    	try {
    		sentencia = cone.conectar().prepareStatement("DELETE FROM bib_editorial WHERE bib_edi_codigo = ? ");
    		sentencia.setString(1, codigo);
    		sentencia.executeUpdate();
    		System.out.println("borrado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    }
    
    
    public void modificarEditorial(Conexion cone,String codigo, String bib_edi_nombre, String bib_edi_direccion, String bib_edi_telf, String bib_edi_ciudad ) {
    	try {
    		
    		sentencia = cone.conectar().prepareStatement("UPDATE bib_editorial SET bib_edi_nombre =?, bib_edi_direccion=?, bib_edi_telf=?, bib_edi_ciudad=?" + " WHERE bib_edi_codigo =?");
    		sentencia.setString(1, bib_edi_nombre);
    		sentencia.setString(2, bib_edi_direccion);
    		sentencia.setString(3, bib_edi_telf);
    		sentencia.setString(4, bib_edi_ciudad);
    		sentencia.setString(5, codigo);
    		sentencia.executeUpdate();
    		System.out.println("modificado");
    		System.out.println( bib_edi_nombre + bib_edi_direccion + bib_edi_telf + bib_edi_ciudad);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    }
    

    public List<Editorial> cargarEditorial(Conexion cone) {
    		
		//sentencia = con.conectar().prepareStatement("Select * From bib_libro");
		
		//Libros lb =  new Libros();
    	try {
			sentencia = cone.conectar().prepareStatement("Select * From bib_editorial");
			//sentencia.setString(1, codigo);
			resultado = sentencia.executeQuery();
			//Libros lb =  new Libros();
			while(resultado.next()){
				Editorial ed =  new Editorial();
				ed.setBib_edi_codigo(resultado.getString("bib_edi_codigo"));
				ed.setBib_edi_nombre(resultado.getString("bib_edi_nombre"));
				ed.setBib_edi_direccion(resultado.getString("bib_edi_direccion"));
				ed.setBib_edi_telf(resultado.getString("bib_edi_telf"));
				ed.setBib_edi_ciudad(resultado.getString("bib_edi_ciudad"));
				
				editorial.add(ed);
			   
			}
			
			} catch (SQLException e) {
			// TODO: handle exception
				e.printStackTrace();
		}
    		
    	return this.editorial;
    	
    }
    

    public List<Editorial> getEditorial() {
		return editorial;
	}

	public void setEditorial(List<Editorial> editorial) {
		this.editorial = editorial;
	}
	
	public void insertarEditorial1(Conexion cone, String text1, String text,
			String text2, String text3, String text4) {
		// TODO Auto-generated method stub

	}
/*
	public void modificarEditorial(Conexion cone, JComboBox codigo,
			String text, String text2, String text3, String text4) {
		// TODO Auto-generated method stub
		
	}
	*/

	public void modificarEditorial(Conexion cone, JComboBox codigo,
			String text, String text2, String text3, String text4) {
		// TODO Auto-generated method stub
		
	}


	
}
