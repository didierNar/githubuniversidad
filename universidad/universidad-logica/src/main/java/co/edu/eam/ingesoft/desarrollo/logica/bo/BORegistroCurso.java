package co.edu.eam.ingesoft.desarrollo.logica.bo;

import java.util.ArrayList;
import java.util.List;

import co.edu.eam.ingesoft.desarrollo.logica.excepcion.ExcepcionNegocio;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAONotas;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAORegistroCurso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jpa.DAONotasJPA;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jpa.DAORegistroCursoJPA;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Nota;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.RegistroCurso;

public class BORegistroCurso {

	private IDAORegistroCurso daoRegistroCurso;
	private IDAONotas daoNota;

	public BORegistroCurso() {
		daoRegistroCurso = new DAORegistroCursoJPA();
		daoNota = new DAONotasJPA();
	}

	public void crearRegistroCurso(RegistroCurso r) throws Exception {
		int creditos = daoRegistroCurso.sumatoriaCreditos(r.getEstudiante());
		int estudiantesCurso = daoRegistroCurso.estudiantesCurso(r.getCurso());
		boolean entro = false;
		List<RegistroCurso> cursosEstudiante = daoRegistroCurso.buscarCursoEstudiante(r.getEstudiante(), r.getCurso());
		if (r.getCurso().getAsignatura().getNumeroCreditos() + creditos > 12) {
			throw new ExcepcionNegocio("Solo puede registrar 12 creditos");
		} else {
			if (estudiantesCurso == 10) {
				throw new ExcepcionNegocio("El curso que seleccionó ya esta copado");
			} else {
				if (cursosEstudiante.size() != 0) {
					for (int i = 0; i < cursosEstudiante.size(); i++) {
						if (cursosEstudiante.get(i).getCurso().getAsignatura().getNombre()
								.equalsIgnoreCase(r.getCurso().getAsignatura().getNombre())) {
							entro = true;
						}
					}
					if (entro == true) {
						throw new ExcepcionNegocio("Ya tiene registrada esta misma materia");
					} else {
						daoRegistroCurso.crear(r);
					}
				} else {
					daoRegistroCurso.crear(r);
				}
			}
		}
	}

	public int creditosEstudiante(Estudiante e) throws Exception {
		return daoRegistroCurso.sumatoriaCreditos(e);
	}

	public void eliminarRegistroCurso(Estudiante e, String nomAsign) throws Exception {
		if (e == null) {
			throw new ExcepcionNegocio("Debe haber buscado un estudiante previamente");
		} else {
			List<Nota> notas = daoNota.notasEstudiante(e);
			if (notas.size() != 0) {
				throw new ExcepcionNegocio("No se puede eliminar este registro " + "\n"
						+ "El estudiante ya tiene notas registradas de este curso");
			} else {
				daoRegistroCurso.eliminarRegistro(e, nomAsign);
			}
		}
	}

	public List<RegistroCurso> registrosEstudiantes(Estudiante e) throws Exception {
		List<RegistroCurso> lista = daoRegistroCurso.registrosEstudiante(e);
		if (lista.size() == 0) {
			throw new ExcepcionNegocio("El estudiante no tiene cursos registrados");
		} else {
			return lista;
		}

	}

	/**
	 * Busca los estudiantes de un curso 
	 * @param c Curso en el que se buscarán los estudiantes	
	 * @return lista de estudiantes del curso
	 * @throws Exception Si falla la operación
	 */
	public List<Estudiante> buscarEstudiantesCurso (Curso c) throws Exception{
		return daoRegistroCurso.buscarEstudiantesCurso(c);
	}
	
	/**
	 * Obttiene el RegistroCurso de un estudiante
	 * @param e el estudiante
	 * @param c curso que registró
	 * @return el registro del estudiante
	 * @throws Exception si falla la operación
	 */
	public RegistroCurso registroEstudianteCurso (Estudiante e, Curso c) throws Exception{
		List<RegistroCurso> lista = daoRegistroCurso.buscarCursoEstudiante(e, c);
		return lista.get(0);
	}

}
