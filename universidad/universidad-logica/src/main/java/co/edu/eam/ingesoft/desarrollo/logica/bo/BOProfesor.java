package co.edu.eam.ingesoft.desarrollo.logica.bo;

import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAOProfesor;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jpa.DAOProfesorJPA;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesor;

public class BOProfesor {

	private IDAOProfesor daoProfesor;

	public BOProfesor() {
		daoProfesor = new DAOProfesorJPA();
	}

	/**
	 * Permite buscar un profesor
	 * 
	 * @param cedula
	 *            cédula del profesor que se desea buscar
	 * @return el profesor si lo encuentra, de lo contrario null
	 * @throws Exception
	 *             en caso de que falle la operación
	 */
	public Profesor buscarProfesor(String cedula) throws Exception {
		Profesor p = daoProfesor.buscar(cedula);
		if (p != null) {
			return p;
		} else {
			throw new ExcepcionNegocio("No se encuentra registrado");
		}
	}

	/**
	 * Permite regiatrar un profesor
	 * 
	 * @param p
	 *            Profesor que se desea regiatrar
	 * @throws Exception
	 *             En caso de que falle la operación
	 */
	public void registrarProfesor(Profesor p) throws Exception {
		daoProfesor.crear(p);
	}

	/**
	 * Permite editar un profesor ya registrado
	 * 
	 * @param p
	 *            Profesor que se desea editar
	 * @throws Exception
	 *             En caso de que falle la operación
	 */
	public void editarProfesor(Profesor p) throws Exception {
		daoProfesor.editar(p);
	}

	/**
	 * Permite eliminar un Profesor
	 * 
	 * @param ced
	 *            cédula del profesor que se desea eliminar
	 * @throws Exception
	 *             en caso de que falle la operación
	 */
	public void eliminarProfesor(String ced) throws Exception {
		daoProfesor.eliminar(ced);
	}

}
