package biblioteca.modelo;

import java.sql.Date;

public class Autor extends Persona {

	public Autor(int id, String nombre, String apellido, Boolean genero, Date fechaNac) {
		super(id, nombre, apellido, genero, fechaNac);
		// TODO Auto-generated constructor stub
	}
	
	private String nacionalidad;
	
	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

}
