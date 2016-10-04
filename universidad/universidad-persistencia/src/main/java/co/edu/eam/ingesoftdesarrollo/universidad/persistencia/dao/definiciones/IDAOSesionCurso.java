package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesor;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.SesionCurso;

public interface IDAOSesionCurso {

	public List<SesionCurso> listarSesionesDocente(Profesor c) throws Exception;
	
	public void crear (SesionCurso s) throws Exception;
	
	public void eliminarSesion (SesionCurso s) throws Exception;
	
}
