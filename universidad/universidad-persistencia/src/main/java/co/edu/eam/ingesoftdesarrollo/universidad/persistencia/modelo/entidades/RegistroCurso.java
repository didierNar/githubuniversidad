package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
 * Clase que reprenta un curso registrado por un estudiante.
 * 
 * @author Camilo Andres Ferrer Bustos.
 * 
 */
@Entity
@IdClass(RegistroCursoPK.class)
@NamedQueries({
		@NamedQuery(name = RegistroCurso.ESTUDIANTES_CURSO, query = "SELECT e FROM RegistroCurso r JOIN r.estudiante e JOIN r.curso c WHERE c=?1"),
		@NamedQuery(name = RegistroCurso.BUSCAR_REGISTROCURSO_ESTUDIANTE, query = "SELECT r FROM RegistroCurso r WHERE r.estudiante=?1 AND r.curso=?2"),
		@NamedQuery(name = RegistroCurso.CREDITOS_REGISTRADOS_ESTUDIANTE, query = "SELECT SUM(a.numeroCreditos) FROM RegistroCurso r JOIN r.curso c JOIN c.asignatura a WHERE r.estudiante=?1"),
		@NamedQuery(name = RegistroCurso.BUSCAR_REGISTRO_ESTUDIANTE, query = "SELECT r FROM RegistroCurso r JOIN r.curso c JOIN c.asignatura a WHERE r.estudiante = ?1 AND a.nombre = ?2"),
		@NamedQuery(name = RegistroCurso.REGISTROS_ESTUDIANTE, query = "SELECT r FROM RegistroCurso r WHERE r.estudiante = ?1")
})
@Table(name = "tb_registrocurso")

public class RegistroCurso implements Serializable {

	/**
	 * Obtiene una lista con los estudiantes registrados en curso ?1: El curso
	 */
	public static final String ESTUDIANTES_CURSO = "RegistroCurso.estudiantesCurso";

	/**
	 * Busca un curso registrado por un estudiante ?1: El estudiante ?2: El
	 * curso
	 */
	public static final String BUSCAR_REGISTROCURSO_ESTUDIANTE = "RegistroCurso.materiasEstudiante";

	/**
	 * Obtiene la sumatoria de creditos registrados por un estudiante ?1: el
	 * estudiante
	 */
	public static final String CREDITOS_REGISTRADOS_ESTUDIANTE = "RegistroCurso.creditosEstudiante";
	
	/**
	 * Busca un curos registrado por un estudiante
	 * ?1: el estudiante
	 * ?2: Asignatura del curso que se desea buscar
	 */
	public static final String BUSCAR_REGISTRO_ESTUDIANTE = "RegistroCurso.BuscarRegistroEstudiante";
	
	/**
	 * Obtiene la lista de registros de cursos de un estudiante
	 * ?1: El estudiante
	 */
	public static final String REGISTROS_ESTUDIANTE = "RegistroCurso.RegistrosEstudiante";

	/**
	 * Estudiante que registro el curso.
	 */
	@Id
	@JoinColumn(name = "cedula_est")
	@ManyToOne
	private Estudiante estudiante;

	/**
	 * Curso que registro el estudiante.
	 */
	@Id
	@JoinColumn(name = "codigo_cur")
	@ManyToOne(cascade = {})
	private Curso curso;

	/**
	 * Notas que el estudiante tiene registradas en este curso.
	 */
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cedulaEstudiante")
	private List<Nota> notas;

	public RegistroCurso() {
		super();
	}

	public RegistroCurso(Estudiante estudiante, Curso curso) {
		super();
		this.estudiante = estudiante;
		this.curso = curso;
	}

	/**
	 * @return the estudiante
	 */
	public Estudiante getEstudiante() {
		return estudiante;
	}

	/**
	 * @param estudiante
	 *            the estudiante to set
	 */
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	/**
	 * @return the curso
	 */
	public Curso getCurso() {
		return curso;
	}

	/**
	 * @param curso
	 *            the curso to set
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	/**
	 * @return the notas
	 */
	public List<Nota> getNotas() {
		return notas;
	}

	/**
	 * @param notas
	 *            the notas to set
	 */
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((estudiante == null) ? 0 : estudiante.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
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
		RegistroCurso other = (RegistroCurso) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (estudiante == null) {
			if (other.estudiante != null)
				return false;
		} else if (!estudiante.equals(other.estudiante))
			return false;
		return true;
	}

}
