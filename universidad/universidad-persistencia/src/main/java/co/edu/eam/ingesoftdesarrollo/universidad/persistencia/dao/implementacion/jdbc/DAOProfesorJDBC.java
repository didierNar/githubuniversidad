package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAOProfesor;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesion;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesor;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.utilidades.AdministradorConexionJDBC;

public class DAOProfesorJDBC implements IDAOProfesor {

	public ArrayList<Profesion> profesiones = new ArrayList<Profesion>();

	/**
	 * Permite crear un objeto de tipo Profesor
	 * 
	 * @param p
	 *            Profesor que se desea crear
	 * @throws Exception
	 *             en caso de que falle la conexi�n
	 */
	public void crear(Profesor p) throws Exception {

		Connection con = AdministradorConexionJDBC.getConexion();

		String sqlPer = "INSERT INTO tb_persona (cedula_per,apellido_per,correo_per,direccion_per,nombre_per,telefono_per) "
				+ "VALUES (?,?,?,?,?,?)";

		String sql = "INSERT INTO tb_docente (cedula_per,postgrado_doc,profesion_doc) VALUES (?,?,?)";

		PreparedStatement pstmt2 = con.prepareStatement(sqlPer);
		PreparedStatement pstmt = con.prepareStatement(sql);

		// Enviar los datos a la tabla Persona

		pstmt2.setString(1, p.getCedula());
		pstmt2.setString(2, p.getApellido());
		pstmt2.setString(3, p.getCorreo());
		pstmt2.setString(4, p.getDireccion());
		pstmt2.setString(5, p.getNombre());
		pstmt2.setString(6, p.getTelefono());

		pstmt.setString(1, p.getCedula());
		pstmt.setBoolean(2, p.isPostgrado());
		pstmt.setString(3, p.getProfesion().getCodigo());

		pstmt2.executeUpdate();
		pstmt.executeUpdate();

		con.close();

	}

	/**
	 * Permite modificar los datos de un Profesor
	 * 
	 * @param p
	 *            Profesor, al cual se le modificar�n los datos
	 * @throws Exception si falla la conexi�n a la base de datos
	 */
	public void editar(Profesor p) throws Exception {
		// TODO Auto-generated method stub

		Connection con = AdministradorConexionJDBC.getConexion();

		String sql = "UPDATE tb_persona SET apellido_per=?,correo_per=?,direccion_per=?,nombre_per=?,telefono_per=? "
				+ "WHERE cedula_per =?";

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, p.getApellido());
		pstmt.setString(2, p.getCorreo());
		pstmt.setString(3, p.getDireccion());
		pstmt.setString(4, p.getNombre());
		pstmt.setString(5, p.getTelefono());
		pstmt.setString(6, p.getCedula());

		pstmt.executeUpdate();

		String sqlDoc = "UPDATE tb_docente SET postgrado_doc=?,profesion_doc=? WHERE cedula_per=?";

		PreparedStatement pstmt2 = con.prepareStatement(sqlDoc);

		pstmt2.setBoolean(1, p.isPostgrado());
		pstmt2.setString(2, p.getProfesion().getCodigo());
		pstmt2.setString(3, p.getCedula());

		pstmt2.executeUpdate();

		con.close();

	}

	/**
	 * Obtiene los datos un profesor
	 * 
	 * @param ced
	 *            n�mero de c�dula del profesor que se desea buscar
	 * @return El docente si lo encuentra, de lo contrario null
	 */
	public Profesor buscar(String ced) throws Exception {

		Connection con = AdministradorConexionJDBC.getConexion();

		String sql = "SELECT tp.apellido_per,tp.correo_per,tp.direccion_per,tp.nombre_per,tp.telefono_per,td.postgrado_doc,td.profesion_doc FROM tb_persona tp "
				+ " JOIN tb_docente td ON(tp.cedula_per=td.cedula_per) WHERE tp.cedula_per=?";

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, ced);

		ResultSet res = pstmt.executeQuery();

		Profesor prof = null;

		if (res.next()) {

			boolean post = res.getBoolean(6);
			String codProf = res.getString(7);

			String ape = res.getString(1);
			String email = res.getString(2);
			String dir = res.getString(3);
			String nom = res.getString(4);
			String tel = res.getString(5);

			Profesion profesion = buscarProfesion(codProf);

			//prof = new Profesor(ced, ape, email, dir, nom, tel, post, profesion);
			con.close();
			return prof;

		} else {
			con.close();
			return prof;
		}

	}

	/**
	 * Elimina un docente de la entidad Docente
	 * 
	 * @param p
	 *            Docente que se desea eliminar
	 */
	public void eliminar(Profesor p) throws Exception {
		// TODO Auto-generated method stub

		Connection con = AdministradorConexionJDBC.getConexion();

		String sql = "DELETE FROM tb_docente WHERE cedula_per=?";

		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, p.getCedula());

		pstmt.executeUpdate();

		String sql2 = "DELETE FROM tb_persona WHERE cedula_per=?";

		PreparedStatement pstmt2 = con.prepareStatement(sql2);

		pstmt2.setString(1, p.getCedula());

		pstmt2.executeUpdate();

		con.close();

	}

	/**
	 * Retorna una lista de los profesores registrados
	 */
	public List<Profesor> listarProfesores() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Obtine la lista de profesiones de la tabla profesi�n
	 * 
	 * @return la lista de las profesiones registradas
	 * @throws Exception
	 *             si no se puede conectar a la BD
	 */
	public ArrayList<Profesion> listaProfesiones() throws Exception {

		Connection con = AdministradorConexionJDBC.getConexion();

		String sql = "SELECT codigo_prof,nombre_prof FROM tb_profesion";

		PreparedStatement pstmt = con.prepareStatement(sql);

		ResultSet res = pstmt.executeQuery();

		while (res.next()) {

			Profesion prof = new Profesion(res.getString(1), res.getString(2));
			profesiones.add(prof);

		}
		
		con.close();

		return profesiones;

	}

	/**
	 * Busca una profesi�n por su c�digo
	 * 
	 * @param cod
	 *            c�digo de la profesi�n que se desea buscar
	 * @return la profesi�n si la encuentra, de lo contrario null
	 */
	public Profesion buscarProfesion(String cod) {

		for (int i = 0; i < profesiones.size(); i++) {

			if (profesiones.get(i).getCodigo().equalsIgnoreCase(cod)) {
				return profesiones.get(i);
			}

		}

		return null;

	}

	/**
	 * Busca una profesi�n por su nombre
	 * 
	 * @param nom
	 *            nombre de la profesi�n que se desea buscar
	 * @return la profesi�n si la encuentra, de lo contrario null
	 */
	public Profesion buscarProfesionNom(String nom) {

		for (int i = 0; i < profesiones.size(); i++) {

			if (profesiones.get(i).getNombre().equalsIgnoreCase(nom)) {
				return profesiones.get(i);
			}

		}

		return null;

	}

	public void eliminar(String ced) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
