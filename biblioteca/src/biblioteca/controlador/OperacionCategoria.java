package biblioteca.controlador;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import biblioteca.gestion.Conexion;
import biblioteca.modelo.*;

public class OperacionCategoria {
	
	private List<Categoria> categoria;
	private List<Libros> libros;

	private PreparedStatement sentencia = null;
	private ResultSet resultado = null;
	
	public OperacionCategoria() {
		categoria = new ArrayList<Categoria>();
		libros = new ArrayList<Libros>();
	}
	
	public void insertarCategoria(Conexion con, int codigo, String nombre, String descripcion ) {
    	try {
    		sentencia = con.conectar().prepareStatement("INSERT INTO bib_categoria(bib_catc_codigo, bib_cat_nombre, bib_cat_descr)"
    				+ " VALUES(?,?,?)");
    		sentencia.setInt(1, codigo);
    		sentencia.setString(2, nombre);
    		sentencia.setString(3, descripcion);
    		sentencia.executeUpdate();
    		System.out.println("insertado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    }

	public void darCategoria(Conexion con, String nombreLib, String nombreCat ) {
    	try {
    		sentencia = con.conectar().prepareStatement("INSERT INTO bib_categorizacion(bib_cat_libro, bib_cat_categoria)"
    				+ " VALUES(?,?)");
    		sentencia.setString(1, nombreLib);
    		sentencia.setString(2, nombreCat);
    		sentencia.executeUpdate();
    		System.out.println("insertado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    }
	
	//COMBO CATEGORIA
	public List<Categoria> cargarCategoria(Conexion con)
	{
		try {
			sentencia = con.conectar().prepareStatement("Select * From bib_categoria");
			resultado = sentencia.executeQuery();
			while(resultado.next()){
				
				Categoria lb =  new Categoria(0, "", "");
				
				lb.setCat_codigo(resultado.getInt("bib_catc_codigo"));
				lb.setCat_nombre(resultado.getString("bib_cat_nombre"));
				lb.setCat_descr(resultado.getString("bib_cat_descr"));
				categoria.add(lb);
			   
			}
			
			} catch (SQLException e) {
			// TODO: handle exception
				e.printStackTrace();
		}
		return categoria;
		
	}

	public List<Categoria> getCategoria() {
		return categoria;
	}

	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}
	

	public List<Libros> cargarLibros(Conexion con)
	{
		
		try {
			sentencia = con.conectar().prepareStatement("Select * From bib_libro");
			resultado = sentencia.executeQuery();
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
	

