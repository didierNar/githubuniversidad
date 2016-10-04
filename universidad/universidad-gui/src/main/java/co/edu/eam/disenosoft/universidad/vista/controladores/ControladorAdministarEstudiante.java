package co.edu.eam.disenosoft.universidad.vista.controladores;

import co.edu.eam.ingesoft.desarrollo.logica.bo.BOEstudiante;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Estudiante;

public class ControladorAdministarEstudiante {

	private BOEstudiante boEstudiante;
	
	public ControladorAdministarEstudiante() {
	
		boEstudiante = new BOEstudiante();
		
	}
	
	/**
	 * Permite registrar un nuevo estudiante
	 * @param e estudiante que se desea registrar
	 * @throws Exception En caso de que falle la operación
	 */
	public void crear (Estudiante e) throws Exception{
		boEstudiante.crearEstudiante(e);
	}
	
	/**
	 * Permite editar un estudiante registrado
	 * @param e Estudiante que se desea editar
	 * @throws Exception en caso de que falle la operación
	 */
	public void editar (Estudiante e) throws Exception{
		boEstudiante.editarEstudiante(e);
	}
	
	/**
	 * Permite buscar un estudiante
	 * @param ced cedula de estudiante que se desea buscar
	 * @return el estudiante si lo encuentra, de lo contrario null
	 * @throws Exception en caso de que falle la operación
	 */
	public Estudiante buscar (String ced) throws Exception{
		return boEstudiante.buscarEstudiante(ced);
	}
	
	/**
	 * Permite eliminar un estudiante
	 * @param ced cedula del estudiante que se desea eliminar
	 * @throws Exception en caso de que falle la operación
	 */
	public void eliminar (String ced) throws Exception{
		boEstudiante.eliminarEstudiante(ced);
	}
	
}
