package co.edu.eam.ingesoft.desarrollo.logica.bo;

import java.util.Date;

import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAOEstudiante;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jpa.DAOEstudianteJPA;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Estudiante;

public class BOEstudiante {

	private IDAOEstudiante daoEstudiante;

	public BOEstudiante() {
		// TODO Auto-generated constructor stub
		daoEstudiante = new DAOEstudianteJPA();
	}

	/**
	 * Permite buscar un estudiante
	 * 
	 * @param ced
	 *            cedula de estudiante que se desea buscar
	 * @return el estudiante si lo encuentra, de lo contrario null
	 * @throws Exception
	 *             en caso de que falle la operación
	 */
	public Estudiante buscarEstudiante(String ced) throws Exception {
		Estudiante est = daoEstudiante.buscar(ced);
		if (est != null) {
			return est;
		} else {
			throw new ExcepcionNegocio("Este estudiante no se encuentra registrado");
		}
	}

	/**
	 * Permite registrar un nuevo estudiante
	 * 
	 * @param e
	 *            estudiante que se desea registrar
	 * @throws Exception
	 *             En caso de que falle la operación
	 */
	public void crearEstudiante(Estudiante e) throws Exception {
		daoEstudiante.crear(e);
	}

	/**
	 * Permite editar un estudiante registrado
	 * 
	 * @param e
	 *            Estudiante que se desea editar
	 * @throws Exception
	 *             en caso de que falle la operación
	 */
	public void editarEstudiante(Estudiante e) throws Exception {
		daoEstudiante.editar(e);
	}

	/**
	 * Permite eliminar un estudiante
	 * 
	 * @param ced
	 *            cedula del estudiante que se desea eliminar
	 * @throws Exception
	 *             en caso de que falle la operación
	 */
	public void eliminarEstudiante(String ced) throws Exception {
		daoEstudiante.eliminar(ced);
	}
	
	/**
	 * Calcula la edad de un estudiante
	 * @param e el estudiante
	 * @return la edad del estudiante
	 */
	public int calcularEdadEstudiante (Estudiante e){
		Date fecha = new Date();
		int anio = fecha.getYear();
		int mes = fecha.getMonth();
		int dia = fecha.getDay();
		int edad = anio -e.getFechaNacimiento().getYear();
		if (mes < e.getFechaNacimiento().getMonth()){
			edad = edad-1;
		} else {
			if (mes == e.getFechaNacimiento().getMonth() && dia >= e.getFechaNacimiento().getDay()){
				return edad;
			} else {
				edad = edad - 1;
			}
		}
		return edad;
	}

}
