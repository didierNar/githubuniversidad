package co.edu.eam.ingesoft.desarrollo.logica.bo;

import java.util.List;

import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAOSesionCurso;
import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAOProfesor;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jpa.DAOSesionCursoJPA;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jpa.DAOProfesorJPA;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesor;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.SesionCurso;

public class BOSesionCurso {

	private IDAOSesionCurso daoSesionCurso;
	private IDAOProfesor daoProfesor;

	public BOSesionCurso() {
		daoSesionCurso = new DAOSesionCursoJPA();
		daoProfesor = new DAOProfesorJPA();
	}

	/**
	 * Permite crear las sesiones para un curso
	 * 
	 * @param s
	 *            Sesión de curso que se desea crear
	 * @throws Exception
	 *             si no se puede crar la sesión
	 */
	public void crearSesionCurso(SesionCurso s) throws Exception {

		if (s.getHoraInicio() >= s.getHoraFinal()) {
			throw new ExcepcionNegocio("La hora de inicio no puede ser mayor o igual a la hora final");
		} else {
			Profesor p = daoProfesor.buscar(s.getCurso().getProfesor().getCedula());

			if (p == null) {
				throw new ExcepcionNegocio("El docente no esta registrado");
			} else {

				List<SesionCurso> sesiones = daoSesionCurso.listarSesionesDocente(s.getCurso().getProfesor());

				boolean entro = false;
				if (sesiones.size() == 0) {
					daoSesionCurso.crear(s);
				} else {
					for (int i = 0; i < sesiones.size(); i++) {
						if (sesiones.get(i).getDia().equals(s.getDia())
								&& sesiones.get(i).getHoraInicio() <= s.getHoraInicio()
								&& s.getHoraInicio() < sesiones.get(i).getHoraFinal()) {
							entro = true;
						}
					}
					if (entro == true) {
						throw new ExcepcionNegocio(
								"El docente ya tiene una sesión en este mismo día y la misma hora");
					} else {
						daoSesionCurso.crear(s);
					}
				}
			}
		}

	}

	/**
	 * Permite eliminar una sesión de un curso
	 * @param s Sesion del curso que se desea eliminar
	 * @throws Exception En caso de que falle la operación
	 */
	public void eliminarSesion(SesionCurso s) throws Exception {
		daoSesionCurso.eliminarSesion(s);
	}

}
