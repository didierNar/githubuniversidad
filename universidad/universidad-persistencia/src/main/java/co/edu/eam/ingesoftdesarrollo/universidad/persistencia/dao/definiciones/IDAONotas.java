package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones;

import java.util.List;


import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Evaluacion;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Nota;

public interface IDAONotas {
	
	public List<Nota> notasEstudiante (Estudiante e) throws Exception;
	
	public void editarNota(Nota n) throws Exception;
	
	public Nota buscar(Nota n) throws Exception;
	
	/**
	 * Obtiene las notas de una evaluación
	 * @param nombreEval Nombre de la evalucación
	 * @return las notas
	 * @throws Exception si falla la operación
	 */
	public List<Nota> notasEvaluacion(String nombreEval) throws Exception;
	
	/**
	 * Agrega una nota
	 * @param n nota que se desea agregar
	 * @throws Exception si falla la operación
	 */
	public void agregarCalificacion (Nota n) throws Exception;
	
	/**
	 * Obtiene la nota de una evaluación de un estudiante
	 * @param e El estudiante
	 * @param a La Evaluación
	 * @return La calificacion
	 * @throws Exception si falla la operación
	 */
	public List<Nota> notasEstudianteEvaluacion (Estudiante e, Evaluacion eval) throws Exception;

}
