package co.edu.eam.disenosoft.universidad.vista.controladores;

import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.bo.BOEstudiante;
import co.edu.eam.ingesoft.desarrollo.logica.bo.BORegistroCurso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.RegistroCurso;

public class ControladorVerRegistroEstudiante {

	private BOEstudiante boEstudiante;
	private BORegistroCurso boRegistroCurso;

	public ControladorVerRegistroEstudiante() {
		boEstudiante = new BOEstudiante();
		boRegistroCurso = new BORegistroCurso();
	}

	/**
	 * Busca un estudiante
	 * 
	 * @param ced
	 *            Cédula del estudiante que se desea buscar
	 * @return El estudinte si lo encuntra, de lo contrario null
	 * @throws Exception
	 *             En caso de que falle la operación
	 */
	public Estudiante buscarEstudiante(String ced) throws Exception {
		return boEstudiante.buscarEstudiante(ced);
	}

	public void eliminarRegistroCurso(Estudiante e, String nomAsign) throws Exception {
		boRegistroCurso.eliminarRegistroCurso(e, nomAsign);
	}

	public int creditosRegistrados(Estudiante e) throws Exception {
		return boRegistroCurso.creditosEstudiante(e);
	}
	
	public List<RegistroCurso> registrosEstudiante (Estudiante e) throws Exception{
		return boRegistroCurso.registrosEstudiantes(e);
	}
	
}
