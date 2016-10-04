package co.edu.eam.ingesoft.desarrollo.logica.bo;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAOAsignatura;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAOCurso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jpa.DAOAsignaturaJPA;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jpa.DAOCursoJPA;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Estudiante;

public class BOAsignatura {

	private IDAOAsignatura daoAsignatura;
	private IDAOCurso daoCurso;

	public BOAsignatura() {
		// TODO Auto-generated constructor stub
		daoAsignatura = new DAOAsignaturaJPA();
		daoCurso = new DAOCursoJPA();
	}

	/**
	 * Permite buscar una asignatura
	 * 
	 * @param cod
	 *            Código de la asignatura que se desea buscar
	 * @return La asignatura si la encuentra, de lo contrario null
	 * @throws Exception
	 *             Si falla la operación
	 */
	public Asignatura buscarAsignatura(String cod) throws Exception {
		Asignatura asign = daoAsignatura.buscar(cod);
		if (asign != null) {
			return daoAsignatura.buscar(cod);
		} else {
			throw new ExcepcionNegocio("La asignatura buscada no existe");
		}
	}

	/**
	 * Permite eliminar una asignatura
	 * 
	 * @param cod
	 *            Código de la asignatura que se desea eliminar
	 * @throws Exception
	 *             Si falla la conexión
	 */
	public void eliminar(String cod) throws Exception {
		Asignatura a = daoAsignatura.buscar(cod);
		List<Curso> cursos = daoCurso.cursosAsignatura(a);
		if (!cursos.isEmpty()) {
			throw new ExcepcionNegocio("No se puede eliminar esta asignatura, porque ya esta asignada a un curso");
		} else {
			daoAsignatura.eliminar(cod);
		}
	}

	/**
	 * Permite editar una asignatura
	 * 
	 * @param as
	 *            Asignatura que se desea editar
	 * @throws Exception
	 *             En caso de que falle la operación
	 */
	public void editar(Asignatura as) throws Exception {
		daoAsignatura.editar(as);
	}

	/**
	 * Permite crear una asignatura
	 * 
	 * @param a
	 *            Asignatura que se desea crear
	 * @throws Exception
	 *             En caso de que falle la operación
	 */
	public void crear(Asignatura a) throws Exception {
		daoAsignatura.crear(a);
	}

}
