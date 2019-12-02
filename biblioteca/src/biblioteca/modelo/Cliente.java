package biblioteca.modelo;

import biblioteca.modelo.Persona;

public class Cliente extends Persona {
	
	private String bib_cli_correo;
	private String bib_cli_direccion;
	
	public Cliente(int id, String nombre, String apellido, String genero, String fechaNac) {
		
		super(id, nombre, apellido, genero, fechaNac);
		
	}

	public String getBib_cli_correo() {
		return bib_cli_correo;
	}

	public void setBib_cli_correo(String bib_cli_correo) {
		this.bib_cli_correo = bib_cli_correo;
	}

	public String getBib_cli_direccion() {
		return bib_cli_direccion;
	}

	public void setBib_cli_direccion(String bib_cli_direccion) {
		this.bib_cli_direccion = bib_cli_direccion;
	}

}
