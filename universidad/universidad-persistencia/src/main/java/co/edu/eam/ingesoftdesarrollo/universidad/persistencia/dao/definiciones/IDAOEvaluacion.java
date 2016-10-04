package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Evaluacion;

/**
 * Clase responsable de definir los métodos de la entidad evaluación
 * @author Didier_Narváez
 *
 */
public interface IDAOEvaluacion {

	/**
	 * Permite agregar una evaluación
	 * @param e Evaluación que se desea agregar
	 * @throws Exception En caso de que falle la operación
	 */
	public void agregarEvaluacion (Evaluacion e) throws Exception;
	
	/**
	 * Permite eliminar un evaluación
	 * @param e Evaluación que se desea eliminar
	 * @throws Exception En caso de que falle la operación
	 */
	public void eliminarEvaluacion (Evaluacion e) throws Exception;
	
	/**
	 * Obtiene la sumatoria del porcentaje de las evaluaciones de una asignatura en un curso
	 * @param c Curso en el que se encuentra la asignatura
	 * @param a la asignatura
	 * @return la sumatoria del porcentaje
	 * @throws Exception En caso de que falle la operación
	 */
	public double sumatoriaProcentaje (Curso c, Asignatura a) throws Exception;
	
	/**
	 * Obtiene la lista de evaluaciones realizadas en una asignatura de un determinado curso
	 * @param c Curso en el cual esta la asignatura
	 * @param a la asignatura
	 * @return la lista de evaluaciones
	 * @throws Exception Si falla la operación
	 */
	public List<Evaluacion> evaluacionesCurso (Curso c, Asignatura a) throws Exception;
	
}
