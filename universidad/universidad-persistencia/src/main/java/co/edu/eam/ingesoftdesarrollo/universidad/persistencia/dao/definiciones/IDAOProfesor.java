/**
 * 
 */
package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesion;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesor;

/**
 * Interface responsable de definir las operaciones de Profesor
 * @author Didier_Narváez
 *
 */
public interface IDAOProfesor {
	/**
	 * Permite agregar un profesor a la dependecia profesores
	 * @param p Profesor que se desea agregar
	 * @throws Exception en caso de que falle la conexión
	 */
	public void crear (Profesor p) throws Exception;
	
	/**
	 * Permite editar los datos de un profesor
	 * @param p profesor que se desea editar
	 * @throws Exception en caso de que falle la conexión a la base de datos
	 */
	public void editar (Profesor p) throws Exception;
	
	/**
	 * Busca un profesor en la dependencia de profesores
	 * @param ced cédula del profesor que se desea buscar
	 * @return el profesor si lo encuentra, de lo contrario null
	 * @throws Exception Si falla la conexión a la base de datos
	 */
	public Profesor buscar (String ced) throws Exception;
	
	/**
	 * Elimina un profesor de la tabla de profesores
	 * @param ced cédula del profesor que se desea eliminar
	 * @throws Exception En caso de que falle la conexión a la base de datos
	 */
	public void eliminar (String ced) throws Exception;

}
