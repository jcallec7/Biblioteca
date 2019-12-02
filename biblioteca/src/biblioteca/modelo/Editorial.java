package biblioteca.modelo;

public class Editorial {

		
		private String bib_edi_codigo;//id
		private String bib_edi_nombre;//title
		private String bib_edi_direccion;//min_salary
		private String bib_edi_telf	;//max_salary
		private String bib_edi_ciudad;
		

		

		public Editorial(String bib_edi_codigo, String bib_edi_nombre,
				String bib_edi_direccion, String bib_edi_telf,
				String bib_edi_ciudad) {
			super();
			this.bib_edi_codigo = bib_edi_codigo;
			this.bib_edi_nombre = bib_edi_nombre;
			this.bib_edi_direccion = bib_edi_direccion;
			this.bib_edi_telf = bib_edi_telf;
			this.bib_edi_ciudad = bib_edi_ciudad;
		}

		public Editorial() {
			// TODO Auto-generated constructor stub
		}

		public String getBib_edi_codigo() {
			return bib_edi_codigo;
		}

		public void setBib_edi_codigo(String bib_edi_codigo) {
			this.bib_edi_codigo = bib_edi_codigo;
		}

		public String getBib_edi_nombre() {
			return bib_edi_nombre;
		}

		public void setBib_edi_nombre(String bib_edi_nombre) {
			this.bib_edi_nombre = bib_edi_nombre;
		}

		public String getBib_edi_direccion() {
			return bib_edi_direccion;
		}

		public void setBib_edi_direccion(String bib_edi_direccion) {
			this.bib_edi_direccion = bib_edi_direccion;
		}

		public String getBib_edi_telf() {
			return bib_edi_telf;
		}

		public void setBib_edi_telf(String bib_edi_telf) {
			this.bib_edi_telf = bib_edi_telf;
		}

		public String getBib_edi_ciudad() {
			return bib_edi_ciudad;
		}

		public void setBib_edi_ciudad(String bib_edi_ciudad) {
			this.bib_edi_ciudad = bib_edi_ciudad;
		}
		
		
			
	}



