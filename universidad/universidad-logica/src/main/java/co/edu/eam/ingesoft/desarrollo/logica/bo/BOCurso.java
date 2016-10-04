package co.edu.eam.ingesoft.desarrollo.logica.bo;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAOCurso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAOSesionCurso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jpa.DAOCursoJPA;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jpa.DAOSesionCursoJPA;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesor;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.SesionCurso;

public class BOCurso {

	private IDAOCurso daoCurso;
	private IDAOSesionCurso daoSesion;

	public BOCurso() {
		// TODO Auto-generated constructor stub
		daoCurso = new DAOCursoJPA();
		daoSesion = new DAOSesionCursoJPA();
	}

	/**
	 * Crea un curso
	 * 
	 * @param c
	 *            curso que se desea crear
	 * @throws Exception
	 *             Si falla la operación
	 */
	public void crearCurso(Curso c) throws Exception {
		daoCurso.crear(c);
	}

	/**
	 * Busca un curso
	 * 
	 * @param cod
	 *            codigo del curso que se desea buscar
	 * @return el curso
	 * @throws Exception
	 *             en caso de que falle la operción
	 */
	public Curso buscarCurso(String cod) throws Exception {
		return daoCurso.buscar(cod);
	}

	public void editarCurso(Curso c) throws Exception {
		List<SesionCurso> sesiones = daoSesion.listarSesionesDocente(c.getProfesor());
		List<SesionCurso> sesionesCursoActual = c.getSesiones();
		boolean entro = false;
		for (int i = 0; i < sesiones.size(); i++) {
			for (int j = 0; j < sesionesCursoActual.size(); j++) {
				if (sesiones.get(i).getDia().equals(sesionesCursoActual.get(j).getDia())
						&& sesiones.get(i).getHoraInicio() <= sesionesCursoActual.get(j).getHoraInicio()
						&& sesionesCursoActual.get(j).getHoraInicio() < sesiones.get(i).getHoraFinal()) {
					entro = true;
				}
			}			
		}
		if (entro == true){
			throw new ExcepcionNegocio("No se puede editar el curso porque se cruzan los horarios del docente");
		} else {
			daoCurso.editar(c);
		}
	}

	public List<Curso> listarCursoAsignatura(Asignatura as) throws Exception {
		return daoCurso.cursosAsignatura(as);
	}

	public List<Curso> cursosDocente(Profesor p) throws Exception {
		return daoCurso.cursosDocente(p);
	}

}
