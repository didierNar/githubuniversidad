package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Permite administrar la conexi�n con la base de datos
 * @author Didier_Narv�ez
 *
 */
public class AdministradorConexionJDBC {
	
	/**
	 * M�todo encargado de crear la conexi�n con la base de datos
	 * @return la conexi�n a la base de datos
	 * @throws SQLException en caso de que no se pueda crear la conexi�n
	 */
	public static Connection getConexion() throws SQLException{
	
	String url = "jdbc:mysql://127.0.0.1:3306/universidad";
	String user = "root";
	String pass = "";

	Connection con = DriverManager.getConnection(url, user, pass);
	
	return con;
	
	}

}
