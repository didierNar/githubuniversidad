package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesion;

public interface IDAOProfesion {

	/**
	 * Lista todas las profesiones registradas en la base de datos
	 * @return la profesiones registradas
	 * @throws Exception en caso de que falle la conexi�n
	 */
	public List<Profesion> listaProfesiones() throws Exception;
	
	/**
	 * Busca una profesi�n por su c�digo
	 * @param cod C�digo de la profesi�n que se desea buscar
	 * @return la profesi�n si la encuentra, de lo contrario null
	 */
	public Profesion buscarProfesion(String cod) throws Exception;
	
	/**
	 * Busca una profesi�n por su nombre
	 * @param nom nombre de la profesi�n que se desea buscar
	 * @return la profesi�n si la encuentra, de lo contrario null
	 */
	public Profesion buscarProfesionNom (String nom) throws Exception;
	
}
