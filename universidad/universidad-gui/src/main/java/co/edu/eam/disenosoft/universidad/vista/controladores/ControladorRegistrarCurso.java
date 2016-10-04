package co.edu.eam.disenosoft.universidad.vista.controladores;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.bo.BOAsignatura;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOCurso;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOEstudiante;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BORegistroCurso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.RegistroCurso;

public class ControladorRegistrarCurso {
	
	private BOAsignatura boAsigantura;
	private BOCurso boCurso;
	private BOEstudiante boEstudiante;
	private BORegistroCurso boRegistroCurso;
	
	public ControladorRegistrarCurso() {
		// TODO Auto-generated constructor stub
		boAsigantura = new BOAsignatura();
		boCurso = new BOCurso();
		boEstudiante = new BOEstudiante();
		boRegistroCurso = new BORegistroCurso();
	}

	/**
	 * permite buscar un estudiante
	 * @param ced cédula del estudiante que se desea buscar
	 * @return el estudiante o null
	 * @throws Exception 
	 */
	public Estudiante buscarEstudiante (String ced) throws Exception{
		return boEstudiante.buscarEstudiante(ced);
	}
	
	/**
	 * Permite crear un registro de un curso
	 * @param c RegsitroCurso que se desea crear
	 * @throws Exception si falla la operación
	 */
	public void crearRegistroCurso (RegistroCurso c) throws Exception{
		boRegistroCurso.crearRegistroCurso(c);
	}
	
	/**
	 * permite buscar una asignatura
	 * @param cod código de la asignatura que se desea buscar
	 * @return la asignatura o null
	 * @throws Exception si falla la operación
	 */
	public Asignatura buscarAsignatura (String cod) throws Exception{
		return boAsigantura.buscarAsignatura(cod);
	}
	
	/**
	 * Permite obtener la lista de cursos de una asignatura
	 * @param as asignatura a la cual se desea obtener los cursos
	 * @return la lista de cursos para esa asignatura
	 * @throws Exception si falla la operación
	 */
	public List<Curso> cursosAsignatura (Asignatura as) throws Exception{
		return boCurso.listarCursoAsignatura(as);
	}
	
	public int creditosRegistradosEstudiante (Estudiante e) throws Exception{
		return boRegistroCurso.creditosEstudiante(e);
	}
	
}
