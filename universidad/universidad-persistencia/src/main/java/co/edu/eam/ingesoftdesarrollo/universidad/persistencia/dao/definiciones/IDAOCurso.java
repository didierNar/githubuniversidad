package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesor;

public interface IDAOCurso {

	public void crear(Curso c) throws Exception;

	public Curso buscar(String cod) throws Exception;

	public void editar(Curso c) throws Exception;

	public List<Curso> cursosAsignatura(Asignatura as) throws Exception;
	
	public List<Curso> cursosDocente (Profesor d) throws Exception;

}
