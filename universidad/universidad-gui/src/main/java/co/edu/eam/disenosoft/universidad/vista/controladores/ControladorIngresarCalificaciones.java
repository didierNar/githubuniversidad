package co.edu.eam.disenosoft.universidad.vista.controladores;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.bo.BOCurso;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BONota;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BOProfesor;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BORegistroCurso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Evaluacion;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Nota;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesor;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.RegistroCurso;

public class ControladorIngresarCalificaciones {
	
	private BOCurso boCurso;
	private BOProfesor boProfesor;
	private BONota boNota;
	private BORegistroCurso boRegistroCurso;
	
	public ControladorIngresarCalificaciones() {
		// TODO Auto-generated constructor stub
		boCurso = new BOCurso();
		boProfesor = new BOProfesor();
		boNota = new BONota();
		boRegistroCurso = new BORegistroCurso();
	}
	
	/**
	 * Permite buscar un docente
	 * @param ced Cédula del docente que se desea buscar
	 * @return El docente si lo encuentra, de lo contrario null
	 * @throws Exception Si falla la operación
	 */
	public Profesor buscarDocente (String ced) throws Exception{
		return boProfesor.buscarProfesor(ced);
	}
	
	public List<Curso> cursosDocente (Profesor p) throws Exception{
		return boCurso.cursosDocente(p);
	}
	
	/**
	 * Obtiene la calificación de una evaluación de un estudiante
	 * @param e El estudiante
	 * @param a La Evaluación
	 * @return La calificacion
	 * @throws Exception si falla la operación
	 */
	public String calificacionEstudiante (Estudiante e, Evaluacion a) throws Exception{
		return boNota.calificacionEstudianteEvaluacion(e, a);
	}
	
	/**
	 * Busca los estudiantes de un curso 
	 * @param c Curso en el que se buscarán los estudiantes	
	 * @return lista de estudiantes del curso
	 * @throws Exception Si falla la operación
	 */
	public List<Estudiante> estudiantes (Curso c) throws Exception{
		return boRegistroCurso.buscarEstudiantesCurso(c);
	}
	
	/**
	 * Obttiene el RegistroCurso de un estudiante
	 * @param e el estudiante
	 * @param c curso que registró
	 * @return el registro del estudiante
	 * @throws Exception si falla la operación
	 */
	public RegistroCurso registroEstudiante (Estudiante e, Curso c) throws Exception{
		return boRegistroCurso.registroEstudianteCurso(e, c);
	}
	
	/**
	 * Agrega una nota
	 * @param n nota que se desea agregar
	 * @throws Exception si falla la operación
	 */
	public void agregarNota (Nota n, String co) throws Exception{
		boNota.agregarNota(n, co);
	}

}
