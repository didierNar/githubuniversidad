package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa a un curso.
 * 
 * @author Camilo Andres Ferrer Bustos.
 * 
 */

@Entity
@Table(name="tb_curso")
@NamedQueries({
	@NamedQuery(name=Curso.LISTA_CURSOS_ASIGNATURA, query = "SELECT c FROM Curso c WHERE c.asignatura=?1"),
	@NamedQuery(name = Curso.CURSOS_DOCENTE, query = "SELECT c FROM Curso c WHERE c.profesor = ?1")
	})
public class Curso implements Serializable {

	/**
	 * Lista los cursos de una asignatura
	 * ?1: la Asignatura
	 */
	public static final String LISTA_CURSOS_ASIGNATURA = "Curso.listarCursosAsiganatura";
	
	/**
	 * Lista los cursos de un docente
	 * ?1: El docente
	 */
	public static final String CURSOS_DOCENTE = "Curso.cursosDocente";	
	
	/**
	 * Codigo del curso. el codigo se forma con el codigo de la
	 * asignatura semestre del año (I o II)
	 */
	@Id
	@Column(name="codigo_curso")
	private String codigo;

	/**
	 * Docente que imparte la asignatura.
	 */
	
	@JoinColumn(name="cedula_docente", nullable=false)
	@ManyToOne
	private Profesor profesor;

	/**
	 * Asignatura de este curso.
	 */
	@JoinColumn(name="codigo_asignatura", nullable=false)
	@ManyToOne
	private Asignatura asignatura;

	/**
	 * Sesiones del curso. las sesiones son los dias en que los estudiantes y el
	 * profesor se encuentran para la clase.
	 */
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="curso", orphanRemoval=true)
	private List<SesionCurso> sesiones;
	
	/**
	 * Estudiantes registrados en este curso.
	 */
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="curso", orphanRemoval=true)
	private List<RegistroCurso> registros;
	
	/**
	 * Evaluaciones del curso.
	 */
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="curso", orphanRemoval=true)
	private List<Evaluacion> evaluaciones;
	
	/**
	 * Constructor.
	 */
	public Curso() {
		super();
	}
	

	public Curso(String codigo, Profesor cedulaDocente, Asignatura asignatura) {
		super();
		this.codigo = codigo;
		this.profesor = cedulaDocente;
		this.asignatura = asignatura;
		sesiones = new ArrayList<SesionCurso>();
	}


	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	/**
	 * @return the cedulaDocente
	 */
	public Profesor getProfesor() {
		return profesor;
	}

	/**
	 * @param cedulaDocente the cedulaDocente to set
	 */
	public void setProfesor(Profesor cedulaDocente) {
		this.profesor = cedulaDocente;
	}

	/**
	 * @return the asignatura
	 */
	public Asignatura getAsignatura() {
		return asignatura;
	}

	/**
	 * @param asignatura
	 *            the asignatura to set
	 */
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	/**
	 * @return the sesiones
	 */
	public List<SesionCurso> getSesiones() {
		return sesiones;
	}

	/**
	 * @param sesiones the sesiones to set
	 */
	public void setSesiones(List<SesionCurso> sesiones) {
		this.sesiones = sesiones;
	}

	/**
	 * @return the estudiantes
	 */
	public List<RegistroCurso> getRegistros() {
		return registros;
	}

	/**
	 * @param estudiantes the estudiantes to set
	 */
	public void setRegistros(List<RegistroCurso> estudiantes) {
		this.registros = estudiantes;
	}

	/**
	 * @return the evaluaciones
	 */
	public List<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}

	/**
	 * @param evaluaciones the evaluaciones to set
	 */
	public void setEvaluaciones(List<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}
	

	@Override
	public String toString() {
		return codigo;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((profesor == null) ? 0 : profesor.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (profesor == null) {
			if (other.profesor != null)
				return false;
		} else if (!profesor.equals(other.profesor))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
