/**
 * 
 */
package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Clase que representa la evaluacion de un curso.
 * 
 * @author Camilo Andres Ferrer Bustos.
 * 
 */
@Entity
@Table(name = "tb_evaluacion")
@NamedQueries({
		@NamedQuery(name = Evaluacion.SUMATORIA_PORCENTAJE, query = "SELECT SUM(e.porcentaje) FROM Evaluacion e JOIN e.curso c JOIN c.asignatura a WHERE c = ?1 AND a = ?2"),
	    @NamedQuery(name = Evaluacion.EVALUACIONES_CURSO, query = "SELECT e FROM Evaluacion e JOIN e.curso c JOIN c.asignatura a WHERE c = ?1 AND a = ?2")	
})
public class Evaluacion implements Serializable {

	/**
	 * Obtiene la sumatoria del porcentaje de evaluaciones de una asignatura en un determinado curso
	 * ?1: curso donde está la asignatura
	 * ?2: la asignatura
	 */
	public static final String SUMATORIA_PORCENTAJE = "Evaluacion.sumatoriaPorcentaje";
	
	/**
	 * Obtiene la lista de evaluaciones realizadas en una asignatura de un curso
	 * ?1: El curso
	 * ?2: La asignatura
	 */
	public static final String EVALUACIONES_CURSO = "Evaluacion.evaluacionesCurso";

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;

	/**
	 * Curso al que pertenece esta evaluacion.
	 */
	@JoinColumn(name = "codigo_cur", nullable = false)
	@ManyToOne
	private Curso curso;

	/**
	 * Nombre de la evaluacion;
	 */
	@Column(name = "nombre_eval", nullable = false)
	private String nombre;

	/**
	 * Porcentaje que vale esta evaluacion dentro del curso.
	 */
	@Column(name = "porcentaje_eval", nullable = false)
	private double porcentaje;

	/**
	 * Constructor.
	 */
	public Evaluacion() {
		super();
	}

	/**
	 * @param codigo
	 * @param curso
	 * @param nombre
	 * @param porcentaje
	 */
	public Evaluacion(Curso curso, String nombre, double porcentaje) {
		super();
		this.curso = curso;
		this.nombre = nombre;
		this.porcentaje = porcentaje;
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the porcentaje
	 */
	public double getPorcentaje() {
		return porcentaje;
	}

	/**
	 * @param porcentaje
	 *            the porcentaje to set
	 */
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	

	@Override
	public String toString() {
		return nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evaluacion other = (Evaluacion) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	

}
