package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones;

import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Estudiante;

/**
 * interface responsable de definir las operaciones del estudiante
 * 
 * @author LuchoBolivar
 *
 */
public interface IDAOEstudiante {

	public void crear(Estudiante p) throws Exception;

	public void editar(Estudiante p) throws Exception;

	public Estudiante buscar(String ced) throws Exception;

	public void eliminar(String p) throws Exception;

	

}
