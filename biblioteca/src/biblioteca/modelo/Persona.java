package biblioteca.modelo;

import java.sql.Date;

public class Persona {
	
	private int bib_per_id;
	private String bib_per_nombre;
	private String bib_per_apellido;
	private String bib_per_genero;
	private String bib_per_fechaNac;
	//StringString
	public Persona (int id, String nombre, String apellido, String genero, String fechaNac) {
		
		this.bib_per_id = id;
		this.bib_per_nombre = nombre;
		this.bib_per_apellido = apellido;
		this.bib_per_genero = genero;
		this.bib_per_fechaNac = fechaNac;
		
	}
	
	
	public int getBib_per_id() {
		return bib_per_id;
	}
	public void setBib_per_id(int bib_per_id) {
		this.bib_per_id = bib_per_id;
	}
	
	public String getBib_per_nombre() {
		return bib_per_nombre;
	}
	public void setBib_per_nombre(String bib_per_nombre) {
		this.bib_per_nombre = bib_per_nombre;
	}
	public String getBib_per_apellido() {
		return bib_per_apellido;
	}
	public void setBib_per_apellido(String bib_per_apellido) {
		this.bib_per_apellido = bib_per_apellido;
	}
	public String getBib_per_genero() {
		return bib_per_genero;
	}
	public void setBib_per_genero(String bib_per_genero) {
		this.bib_per_genero = bib_per_genero;
	}
	public String getBib_per_fechaNac() {
		return bib_per_fechaNac;
	}
	public void setBib_per_fechaNac(String bib_per_fechaNac) {
		this.bib_per_fechaNac = bib_per_fechaNac;
	}

}
