package biblioteca.modelo;

public class Categoria 
{
	 int cat_codigo;
	 String cat_nombre;
	 String cat_descr;
	 
	public Categoria(int cat_codigo, String cat_nombre, String cat_descr) 
	{
		this.cat_codigo = cat_codigo;
		this.cat_nombre = cat_nombre;
		this.cat_descr = cat_descr;
	}

	public int getCat_codigo() {
		return cat_codigo;
	}

	public void setCat_codigo(int cat_codigo) {
		this.cat_codigo = cat_codigo;
	}

	public String getCat_nombre() {
		return cat_nombre;
	}

	public void setCat_nombre(String cat_nombre) {
		this.cat_nombre = cat_nombre;
	}

	public String getCat_descr() {
		return cat_descr;
	}

	public void setCat_descr(String cat_descr) {
		this.cat_descr = cat_descr;
	}
	
	 
	 
}
