package co.edu.eam.disenosoft.universidad.vista.controladores;

import co.edu.eam.ingesoft.desarrollo.logica.bo.BOAsignatura;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Asignatura;

public class ControladorVentanaAsignatura {

	private BOAsignatura boAsignatura;
	
	public ControladorVentanaAsignatura() {
		// TODO Auto-generated constructor stub
		boAsignatura = new BOAsignatura();
	}
	
	/**
	 * Permite eliminar una asignatura
	 * @param cod Código de la asignatura que se desea eliminar
	 * @throws Exception En caso de que falle la operación
	 */
	public void eliminar (String cod) throws Exception{
		boAsignatura.eliminar(cod);
	}
	
	/**
	 * Permite buscar una asignatura
	 * @param cod Código de la asignatura que se desea buscar
	 * @return La asignatura si la encuentra, de lo contrario null
	 * @throws Exception si falla la operación
	 */
	public Asignatura buscar (String cod) throws Exception{
		return boAsignatura.buscarAsignatura(cod);
	}
	
	/**
	 * Permite editar una asignatura
	 * @param as Asignatura que se desea editar
	 * @throws Exception En caso de que falle la operación
	 */
	public void editar (Asignatura as) throws Exception{
		boAsignatura.editar(as);
	}
	
	/**
	 * Permite crear una asignatura
	 * @param a Asignatura que se desea crear
	 * @throws Exception En caso de que falle la operación
	 */
	public void crear (Asignatura a) throws Exception{
		boAsignatura.crear(a);
	}
	
}
