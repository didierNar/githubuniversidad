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
	 * Obtiene las notas de una evaluaci�n
	 * @param nombreEval Nombre de la evalucaci�n
	 * @return las notas
	 * @throws Exception si falla la operaci�n
	 */
	public List<Nota> notasEvaluacion(String nombreEval) throws Exception;
	
	/**
	 * Agrega una nota
	 * @param n nota que se desea agregar
	 * @throws Exception si falla la operaci�n
	 */
	public void agregarCalificacion (Nota n) throws Exception;
	
	/**
	 * Obtiene la nota de una evaluaci�n de un estudiante
	 * @param e El estudiante
	 * @param a La Evaluaci�n
	 * @return La calificacion
	 * @throws Exception si falla la operaci�n
	 */
	public List<Nota> notasEstudianteEvaluacion (Estudiante e, Evaluacion eval) throws Exception;

}
