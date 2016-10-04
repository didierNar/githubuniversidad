package co.edu.eam.disenosoft.universidad.vista.controladores;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.bo.BOAsignatura;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOCurso;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BONota;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BORegistroCurso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Evaluacion;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Nota;

public class ControladorVentanaVerCalificaciones {
	
	private BOAsignatura boAsignatura;
	private BOCurso boCurso;
	private BORegistroCurso boRegistroCurso;
	private BONota boNota;
	
	public ControladorVentanaVerCalificaciones() {
		// TODO Auto-generated constructor stub
		boAsignatura = new BOAsignatura();
		boCurso = new BOCurso();
		boRegistroCurso = new BORegistroCurso();
		boNota = new BONota();
	}
	
	/**
	 * Permite buscar una asignatura
	 * @param cod Código de la asignatura que se desea buscar
	 * @return la asignatura si la encuentra, de lo contrario null
	 * @throws Exception Si falla la operación
	 */
	public Asignatura buscarAsignatura (String cod) throws Exception{
		return boAsignatura.buscarAsignatura(cod);
	}
	
	/**
	 * Obtiene la lista de cursos de una asignatura
	 * @param a Asignatura a la cual se le buscaran los cursos
	 * @return la lista de cursos
	 * @throws Exception en caso de que falle la operación
	 */
	public List<Curso> cursosAsignatura (Asignatura a) throws Exception{
		return boCurso.listarCursoAsignatura(a);
	}
	
	/**
	 * Obtiene la lista de estudiantes de un curso
	 * @param c Curso en el que se buscará
	 * @return la lista de estudiantes
	 * @throws Exception si falla la operación
	 */
	public List<Estudiante> estudiantesCurso (Curso c) throws Exception{
		return boRegistroCurso.buscarEstudiantesCurso(c);
	}
	
	/**
	 * Obtiene las notas de un estudiante
	 * @param e el estudiante
	 * @return las notas 
	 * @throws Exception si falla la operación
	 */
	public List<Nota> notasEstudiante (Estudiante e) throws Exception{
		return boNota.notasEstudiante(e);
	}
	
	/**
	 * Calcula la nota definitiva de un estudiante
	 * 
	 * @param notas
	 *            Notas del estudiante
	 * @return la calificación del estudiante
	 */
	public double calificacionEstudiante (List<Nota> notas){
		return boNota.calcularDefinitiva(notas);
		}

}
