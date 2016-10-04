package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.RegistroCurso;

public interface IDAORegistroCurso {

	public void crear (RegistroCurso r) throws Exception;
	
	public List<RegistroCurso> buscarCursoEstudiante (Estudiante es, Curso c) throws Exception;
	
	public int sumatoriaCreditos (Estudiante e) throws Exception;
	
	public int estudiantesCurso (Curso c) throws Exception;
		
	public void eliminarRegistro (Estudiante e, String nomAsign) throws Exception;
	
	public List<RegistroCurso> registrosEstudiante (Estudiante e) throws Exception;
	

	/**
	 * Busca los estudiantes de un curso 
	 * @param c Curso en el que se buscarán los estudiantes	
	 * @return lista de estudiantes del curso
	 * @throws Exception Si falla la operación
	 */
	public List<Estudiante> buscarEstudiantesCurso (Curso c) throws Exception;
	
}
