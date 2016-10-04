package co.edu.eam.disenosoft.universidad.vista.controladores;

import co.edu.eam.ingesoft.desarrollo.logica.bo.BOAsignatura;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOCurso;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOProfesor;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOSesionCurso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesor;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.SesionCurso;

public class ControladorAdministrarCurso {

	private BOSesionCurso boSesionCurso;
	private BOProfesor boProfesor;
	private BOAsignatura boAsignatura;
	private BOCurso boCurso;
	
	public ControladorAdministrarCurso(){
		boSesionCurso = new BOSesionCurso();
		boProfesor = new BOProfesor();
		boAsignatura = new BOAsignatura();
		boCurso = new BOCurso();
	}
	
	/**
	 * Busca un docente 
	 * @param ced c�dula del docente que se desea buscar
	 * @return el docente si  lo encuentra, de lo contrario null
	 * @throws Exception si falla la operaci�n
	 */
	public Profesor buscarDocente(String ced) throws Exception{
		return boProfesor.buscarProfesor(ced);
	}
	
	/**
	 * Busca una asignatura
	 * @param cod C�digo de la asigantura que se desea buscar
	 * @return la asignatura si la encuentra, de lo contrario null
	 * @throws Exception Si no se pudo realizar la operaci�n
	 */
	public Asignatura buscarAsignatura(String cod) throws Exception{
		return boAsignatura.buscarAsignatura(cod);
	}
	
	/**
	 * Crea una sesi�n de un curso
	 * @param s Sesi�n que se desea crear
	 * @throws Exception en caso de que no se pueda crear la sesi�n del curso
	 */
	public void crearSesionCurso (SesionCurso s) throws Exception{
		boSesionCurso.crearSesionCurso(s);
	}
	
	/**
	 * Permite eliminar una sesi�n de un curso
	 * @param s Sesi�n del curso que se desea eliminar
	 * @throws Exception si falla la operaci�n
	 */
	public void eliminarSesionCurso (Curso s) throws Exception{
		//boSesionCurso.eliminarSesion(s);
		boCurso.editarCurso(s);
	}
	
	/**
	 * Permite editar un curso
	 * @param c Curso que se desea editar
	 * @throws Exception si falla la operaci�n
	 */
	public void editarCurso (Curso c) throws Exception{
		boCurso.editarCurso(c);
	}
	
	/**
	 * Crea un curso
	 * @param c Curso que se desea crear
	 * @throws Exception si falla la operaci�n
	 */
	public void crearCurso (Curso c) throws Exception{
		boCurso.crearCurso(c);
	}
	
	/**
	 * Busca un curso
	 * @param cod C�digo del curso que se desea buscar
	 * @return El curso si lo encuentra, de lo contrario null
	 * @throws Exception Si falla la operaci�n
	 */
	public Curso buscarCurso (String cod) throws Exception{
		return boCurso.buscarCurso(cod);
	}
	
}
