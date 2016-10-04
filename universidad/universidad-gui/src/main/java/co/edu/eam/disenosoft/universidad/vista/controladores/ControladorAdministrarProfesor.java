package co.edu.eam.disenosoft.universidad.vista.controladores;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.bo.BOProfesion;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOProfesor;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesion;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesor;

public class ControladorAdministrarProfesor {

	private BOProfesor boProfesor;
	private BOProfesion boProfesion;
	
	public ControladorAdministrarProfesor() {
		// TODO Auto-generated constructor stub
		boProfesor = new BOProfesor();
		boProfesion = new BOProfesion();
	}
	/**
	 * Permite regiatrar un profesor
	 * @param p Profesor que se desea regiatrar
	 * @throws Exception En caso de que falle la operaci�n
	 */
	public void crear (Profesor p) throws Exception{
		boProfesor.registrarProfesor(p);
	}
	/**
	 * Permite editar un profesor ya registrado
	 * @param p Profesor que se desea editar
	 * @throws Exception En caso de que falle la operaci�n
	 */
	public void editar (Profesor p) throws Exception{
		boProfesor.editarProfesor(p);
	}
	/**
	 * Permite buscar un profesor
	 * @param cedula c�dula del profesor que se desea buscar
	 * @return el profesor si lo encuentra, de lo contrario null
	 * @throws Exception en caso de que falle la operaci�n
	 */
	public Profesor buscar (String ced) throws Exception{
		return boProfesor.buscarProfesor(ced);
	}

	/**
	 * Permite eliminar un Profesor
	 * @param ced c�dula del profesor que se desea eliminar
	 * @throws Exception en caso de que falle la operaci�n
	 */
	public void eliminar (String ced) throws Exception{
		boProfesor.eliminarProfesor(ced);
	}
	/**
	 * Lista las profesiones registradas
	 * @return ls profesiones registradas
	 * @throws Exception en caso de que falle la operaci�n
	 */
	public List<Profesion> listar () throws Exception{
		return boProfesion.listar();
	}
	
	/**
	 * Busca un profesi�n por su c�digo
	 * @param cod c�digo de la profesi�n que se desea buscar
	 * @return la profesi�n si la encuenta, de lo contrario null
	 * @throws Exception si falla la operaci�n
	 */
	public Profesion buscarCodigo (String cod) throws Exception{
		return boProfesion.buscarCodigo(cod);
	}
	/**
	 * Busca una profesion por su nombre
	 * @param nom nombre de la profesion que se desea buscar
	 * @return la profesion si la encuentra, de lo contrario null
	 * @throws Exception si falla la operacion
	 */
	public Profesion buscarNombre (String nom) throws Exception{
		return boProfesion.buscarNombre(nom);
	}
	
}
