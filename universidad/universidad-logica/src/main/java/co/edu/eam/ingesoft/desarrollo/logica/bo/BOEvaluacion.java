package co.edu.eam.ingesoft.desarrollo.logica.bo;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAOEvaluacion;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAONotas;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jpa.DAOEvaluacionJPA;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jpa.DAONotasJPA;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Evaluacion;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Nota;

public class BOEvaluacion {

	private IDAOEvaluacion daoEvaluacion;
	private IDAONotas daoNota;

	public BOEvaluacion() {
		// TODO Auto-generated constructor stub
		daoEvaluacion = new DAOEvaluacionJPA();
		daoNota = new DAONotasJPA();
	}

	/**
	 * Permite agregar una evaluación
	 * 
	 * @param e
	 *            Evaluación que se desea agregar
	 * @throws Exception
	 *             En caso de que falle la operación
	 */
	public void agregarEvaluacion(Evaluacion e, double sum, double por) throws Exception {
		if (e.getCurso() != null) {
			if (sum + por > 100) {
				throw new ExcepcionNegocio("No se puede superar el 100%");
			} else {
				daoEvaluacion.agregarEvaluacion(e);
			}
		} else {
			throw new ExcepcionNegocio("Debe haber buscado una asignatura");
		}
	}

	/**
	 * Permite eliminar una evaluación
	 * 
	 * @param e
	 *            Evaluación que se desea eliminar
	 * @throws Exception
	 *             En caso de que falle la operación
	 */
	public void eliminarEvaluacion(Evaluacion e) throws Exception {
		List<Nota> notas = daoNota.notasEvaluacion(e.getNombre());
		if (notas.isEmpty()) {
			daoEvaluacion.eliminarEvaluacion(e);
		} else {
			throw new ExcepcionNegocio("No se puede eliminar esta evaluación, porque ya existen notas");
		}
	}

	/**
	 * Obtiene la sumatoria del porcentaje de las evaluaciones de una asignatura
	 * en un curso
	 * 
	 * @param c
	 *            Curso en el que se encuentra la asignatura
	 * @param a
	 *            la asignatura
	 * @return la sumatoria del porcentaje
	 * @throws Exception
	 *             En caso de que falle la operación
	 */
	public double sumatoriaPorcentaje(Curso c, Asignatura a) throws Exception {
		return daoEvaluacion.sumatoriaProcentaje(c, a);
	}

	/**
	 * Obtiene la lista de evaluaciones realizadas en una asignatura de un
	 * determinado curso
	 * 
	 * @param c
	 *            Curso en el cual esta la asignatura
	 * @param a
	 *            la asignatura
	 * @return la lista de evaluaciones
	 * @throws Exception
	 *             Si falla la operación
	 */
	public List<Evaluacion> listaEvaluaciones(Curso c, Asignatura a) throws Exception {
		return daoEvaluacion.evaluacionesCurso(c, a);
	}

}
