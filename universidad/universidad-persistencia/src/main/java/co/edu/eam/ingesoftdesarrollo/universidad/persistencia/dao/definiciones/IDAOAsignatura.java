package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones;

import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Estudiante;

/**
 * 
 * @author Didier_Narváez
 * Encargada de definir las operaciones de asigantura
 */
public interface IDAOAsignatura {
	
	/**
	 * Permite crear una nueva asigantura
	 * @param a Asignatura que se desea crear
	 * @throws Exception en caso de que falle la conexión
	 */
	public void crear(Asignatura a) throws Exception;

	/**
	 * Permite editar una de las asignaturas creadas
	 * @param a Asignatura que se desea editar
	 * @throws Exception en caso de que falle la conexión
	 */
	public void editar(Asignatura a) throws Exception;

	/**
	 * Permite buscar una de las asignaturas registradas
	 * @param cod código de la asignatura que se desea buscar
	 * @return la asignatura si la encuentra, de lo contrario null
	 * @throws Exception en caso de que falle la conexión
	 */
	public Asignatura buscar(String cod) throws Exception;
	
	/**
	 * Permite eliminar una asignatura
	 * @param cod Código de la asignatura que se desea eliminar
	 * @throws Exception Si falla la operación
	 */
	public void eliminar (String cod) throws Exception;

}
