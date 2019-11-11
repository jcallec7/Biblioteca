package biblioteca.vista;

import biblioteca.gestion.Conexion;
//import biblioteca.controlador.Operacion;
import biblioteca.vista.VentanaPrincipal;
import biblioteca.controlador.*;

public class Main {

	public static void main(String[] args) {

		Operacion con = new Operacion();

		/*
		 * Conexion co = new Conexion();
		 * co.setUrl("jdbc:oracle:thin:@localhost:1521:XE"); co.setUsername("hr");
		 * co.setPassword("hr");
		 * 
		 * co.Conectar();
		 * 
		 * if (co.getConexion() != null) {
		 * 
		 * System.out.println("La base se ha conectado exitosamente"); VentanaPrincipal
		 * vp = new VentanaPrincipal(con, co); vp.setVisible(true);
		 * 
		 * }
		 */

		Conexion co = new Conexion();

		co.conectar();
		System.out.println("La base se ha conectado exitosamente"); VentanaPrincipal
		vp = new VentanaPrincipal(con, co); vp.setVisible(true);
		//System.out.println("La base se ha conectado exitosamente"); VentanaPrincipal
		//vp = new VentanaPrincipal(con, co); vp.setVisible(true);
		
	}

}
