package biblioteca.modelo;
import java.sql.Date;

import biblioteca.modelo.Persona;

public class Cliente extends Persona {
	
	public Cliente(int id, String nombre, String apellido, String genero, String fechaNac) {
		super(id, nombre, apellido, genero, fechaNac);
		// TODO Auto-generated constructor stub
	}

	private String bib_cli_correo;
	
	
	

}
