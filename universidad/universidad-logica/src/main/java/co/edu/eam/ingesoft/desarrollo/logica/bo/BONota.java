package co.edu.eam.ingesoft.desarrollo.logica.bo;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAONotas;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jpa.DAONotasJPA;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Evaluacion;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Nota;

public class BONota {

	private IDAONotas daoNota;

	public BONota() {
		daoNota = new DAONotasJPA();
	}

	/**
	 * Obtiene la lista de notas de un estudiante
	 * 
	 * @param e
	 *            Estudiante del que se obtendrá las notas
	 * @return los notas del estudiante
	 * @throws Exception
	 *             si falla la operación
	 */
	public List<Nota> notasEstudiante(Estudiante e) throws Exception {
		return daoNota.notasEstudiante(e);
	}

	/**
	 * Obtiene la calificación de una evaluación de un estudiante
	 * 
	 * @param e
	 *            El estudiante
	 * @param a
	 *            La Evaluación
	 * @return La calificacion
	 * @throws Exception
	 *             si falla la operación
	 */
	public String calificacionEstudianteEvaluacion(Estudiante e, Evaluacion a) throws Exception {
		List<Nota> lista = daoNota.notasEstudianteEvaluacion(e, a);
		if (!lista.isEmpty()) {
			return lista.get(0).getValor() + "";
		} else {
			return "NC";
		}
	}

	/**
	 * Agrega una nota
	 * 
	 * @param n
	 *            nota que se desea agregar
	 * @throws Exception
	 *             si falla la operación
	 */
	public void agregarNota(Nota n, String c) throws Exception {
		List<Nota> notas = daoNota.notasEstudianteEvaluacion(n.getCedulaEstudiante().getEstudiante(), n.getEvaluacion());
		Nota not = null;
		if (!notas.isEmpty()) {
			not = notas.get(0);
		}
		if (not == null) {
			daoNota.agregarCalificacion(n);
		} else {
			if (!c.equals("NC") && not.isEditada() == true) {
				throw new ExcepcionNegocio("No se puede modificar dos veces la misma nota");
			} else {
				if (!c.equals("NC")) {
					if (not != null) {
						not.setValor(n.getValor());
						not.setEditada(true);
						daoNota.editarNota(not);
					}
				} else {
					daoNota.agregarCalificacion(n);
				}
			}
		}
	}

	/**
	 * Calcula la nota definitiva de un estudiante
	 * @param notas
	 *            Notas del estudiante
	 * @return la calificación del estudiante
	 */
	public double calcularDefinitiva(List<Nota> notas) {
		double definitiva = 0;
		for (int i = 0; i < notas.size(); i++) {
			double porcentajeNota = notas.get(i).getEvaluacion().getPorcentaje();
			double porcentaje = porcentajeNota / 100;
			double nota = notas.get(i).getValor();
			definitiva = (nota * porcentaje) + definitiva;
		}
		return definitiva;
	}

}
