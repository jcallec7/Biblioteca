
package biblioteca.controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import biblioteca.gestion.Conexion;
import biblioteca.modelo.Cliente;
import biblioteca.modelo.Libros;

public class OperacionCliente {
	
	private List<Cliente> cliente;


	private PreparedStatement sentencia = null;
	private ResultSet resultado = null;
	
	public OperacionCliente() {
		cliente = new ArrayList<Cliente>();
	}
	
	
    
   
    public void insertarCliente(Conexion con, int id, String nombre, String apellido, String genero, String fechaNac, String correo, String direccion) {
    	
    	try {
    		sentencia = con.conectar().prepareStatement("INSERT INTO bib_cliente(bib_cli_id, bib_cli_nombre, bib_cli_apellido, bib_cli_genero, bib_cli_fechaNac, bib_cli_correo, bib_cli_direccion) VALUES(?,?,?,?,?,?,?)");
    		sentencia.setInt(1, id);
    		sentencia.setString(2, nombre);
    		sentencia.setString(3, apellido);
    		sentencia.setString(4, genero);
    		sentencia.setString(5, fechaNac);
    		sentencia.setString(6, correo);
    		sentencia.setString(7, direccion);
    		sentencia.executeUpdate();
    		
    		System.out.println("insertado");
    		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    }
    
    public void consultarCliente(Conexion con, int id) {
    	  
    	Cliente cli =  new Cliente(0, "", "", "", "");
    	try {
			sentencia = con.conectar().prepareStatement("SELECT * FROM biblioteca.bib_cliente WHERE bib_cli_id = ? ");
			sentencia.setInt(1, id);
			resultado = sentencia.executeQuery();
			while(resultado.next()) {
				
				cli.setBib_per_id(resultado.getInt("bib_cli_id"));
				cli.setBib_per_nombre(resultado.getString("bib_cli_nombre"));
				cli.setBib_per_apellido(resultado.getString("bib_cli_apellido"));
				cli.setBib_per_genero(resultado.getString("bib_cli_genero"));
				cli.setBib_per_fechaNac(resultado.getString("bib_cli_fechaNac"));
				cli.setBib_cli_correo(resultado.getString("bib_cli_correo"));
				cli.setBib_cli_direccion(resultado.getString("bib_cli_direccion"));
				
				cliente.add(cli);
			}
			} catch (SQLException e) {
			// TODO: handle exception
				e.printStackTrace();
		}
    }
    
    public void borrarCliente(Conexion con, int id) {
    	try {
    		sentencia = con.conectar().prepareStatement("DELETE FROM bib_cliente WHERE bib_cli_id = ? ");
    		
    		sentencia.setInt(1, id);
    		sentencia.executeUpdate();
    		System.out.println("borrado");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    }
    
public void modificarCliente(Conexion con, int id, String nombre, String apellido, String genero, String fechaNac, String correo, String direccion) {
    	
    	try {
    		sentencia = con.conectar().prepareStatement("UPDATE bib_cliente SET bib_cli_nombre =?, bib_cli_apellido=?, bib_cli_genero=?, bib_cli_fechaNac=?, bib_cli_correo=?, bib_cli_direccion=?" + " WHERE bib_cli_id =?");
    		
    		sentencia.setString(1, nombre);
    		sentencia.setString(2, apellido);
    		sentencia.setString(3, genero);
    		sentencia.setString(4, fechaNac);
    		sentencia.setString(5, correo);
    		sentencia.setString(6, direccion);
    		sentencia.setInt(7, id);
    		sentencia.executeUpdate();
    		
    		System.out.println("Modificado");
    		//System.out.println(nombre + apellido + genero + fechaNac + correo + direccion + id);
    		
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
    	
    }

public List<Cliente> cargarCliente(Conexion con) {
	

	try {
		sentencia = con.conectar().prepareStatement("SELECT * FROM bib_cliente");
	
		resultado = sentencia.executeQuery();
	
		while(resultado.next()){
			Cliente cli =  new Cliente(0, "", "", "", "");
			
			cli.setBib_per_id(resultado.getInt("bib_cli_id"));
			cli.setBib_per_nombre(resultado.getString("bib_cli_nombre"));
			cli.setBib_per_apellido(resultado.getString("bib_cli_apellido"));
			cli.setBib_per_genero(resultado.getString("bib_cli_genero"));
			cli.setBib_per_fechaNac(resultado.getString("bib_cli_fechaNac"));
			cli.setBib_cli_correo(resultado.getString("bib_cli_correo"));
			cli.setBib_cli_direccion(resultado.getString("bib_cli_direccion"));
	
			
			cliente.add(cli);
		   
		}
		
		} catch (SQLException e) {
		// TODO: handle exception
			e.printStackTrace();
	}
		
	return this.cliente;
	
}
    
	public List<Cliente> getCliente() {
		return cliente;
	}

	
	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}
	
	
	

}

