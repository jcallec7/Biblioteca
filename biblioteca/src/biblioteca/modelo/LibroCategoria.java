package biblioteca.modelo;
import biblioteca.modelo.*;
public class LibroCategoria
{
	int libcat_codigo;
	Libros libcat_libro;
	Categoria libcat_categ;
	
	public LibroCategoria(int libcat_codigo, Libros libcat_libro, Categoria libcat_categ) {
		super();
		this.libcat_codigo = libcat_codigo;
		this.libcat_libro = libcat_libro;
		this.libcat_categ = libcat_categ;
	}
	
	public int getLibcat_codigo() {
		return libcat_codigo;
	}
	public void setLibcat_codigo(int libcat_codigo) {
		this.libcat_codigo = libcat_codigo;
	}
	public Libros getLibcat_libro() {
		return libcat_libro;
	}
	public void setLibcat_libro(Libros libcat_libro) {
		this.libcat_libro = libcat_libro;
	}
	public Categoria getLibcat_categ() {
		return libcat_categ;
	}
	public void setLibcat_categ(Categoria libcat_categ) {
		this.libcat_categ = libcat_categ;
	}
	
	
	
}
