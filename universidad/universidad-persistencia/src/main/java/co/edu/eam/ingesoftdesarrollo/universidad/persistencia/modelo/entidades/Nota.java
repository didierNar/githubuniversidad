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
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Clase que representa una calificacion de una evaluacion de un curso.
 * 
 * @author Camilo Andres Ferrer Bustos.
 * 
 */
@Entity
@Table(name = "tb_nota")
@NamedQueries({
		@NamedQuery(name = Nota.NOTAS_ESTUDIANTE, query = "SELECT n FROM Nota n JOIN n.cedulaEstudiante r WHERE r.estudiante = ?1"),
		@NamedQuery(name = Nota.CALIFICACION_ESTUDIANTE, query = "SELECT n FROM Nota n JOIN n.cedulaEstudiante r WHERE r.estudiante=?1 AND n.evaluacion=?2"),
		@NamedQuery(name = Nota.NOTAS_EVALUACION, query = "SELECT n FROM Nota n JOIN n.evaluacion e WHERE e.nombre = ?1")
		})
public class Nota implements Serializable {

	/**
	 * Obtiene las notas de un estudiante ?1: el estudiante
	 */
	public static final String NOTAS_ESTUDIANTE = "Nota.notasEstudiante";

	/**
	 * Obtiene la nota de un estudiante de una evaluacion
	 * ?1: El estudiante
	 * ?2: La evaluación
	 */
	public static final String CALIFICACION_ESTUDIANTE = "Nota.calificacionEstudiante";
	
	/**
	 * Obtiene las notas que hay en una evaluación
	 * ?1: el nombre de la Evaluación
	 */
	public static final String NOTAS_EVALUACION = "Nota.notasEvaluacion";

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigoNota;

	@JoinColumns({ @JoinColumn(name = "cedula_est", referencedColumnName = "cedula_est", nullable = false),
			@JoinColumn(name = "codigo_cur", referencedColumnName = "codigo_cur", nullable = false) })
	@ManyToOne
	private RegistroCurso cedulaEstudiante;

	/**
	 * Evaluacion a la que pertenece esta nota.
	 */
	@JoinColumn(name = "id_evaluacion")
	@ManyToOne
	private Evaluacion evaluacion;

	/**
	 * Nota que puso el profesor.
	 */
	@Column(name = "valor_nota", nullable = false)
	private double valor;

	/**
	 * bandera que indica si la nota ya fue modificada para no dejar que lo sea
	 * una vez mas.
	 */
	@Column(name = "editada_nota", nullable = false)
	private boolean editada;

	/**
	 * Constructor
	 */
	public Nota() {
		super();
	}

	/**
	 * @param codigoNota
	 * @param cedulaEstudiante
	 * @param evaluacion
	 * @param valor
	 * @param editada
	 */
	public Nota(RegistroCurso cedulaEstudiante, Evaluacion evaluacion, double valor, boolean editada) {
		super();
		this.cedulaEstudiante = cedulaEstudiante;
		this.evaluacion = evaluacion;
		this.valor = valor;
		this.editada = editada;
	}

	/**
	 * @return the codigoNota
	 */
	public int getCodigoNota() {
		return codigoNota;
	}

	/**
	 * @param codigoNota
	 *            the codigoNota to set
	 */
	public void setCodigoNota(int codigoNota) {
		this.codigoNota = codigoNota;
	}

	/**
	 * @return the cedulaEstudiante
	 */
	public RegistroCurso getCedulaEstudiante() {
		return cedulaEstudiante;
	}

	/**
	 * @param cedulaEstudiante
	 *            the cedulaEstudiante to set
	 */
	public void setCedulaEstudiante(RegistroCurso cedulaEstudiante) {
		this.cedulaEstudiante = cedulaEstudiante;
	}

	/**
	 * @return the evaluacion
	 */
	public Evaluacion getEvaluacion() {
		return evaluacion;
	}

	/**
	 * @param evaluacion
	 *            the evaluacion to set
	 */
	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}

	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * @return the editada
	 */
	public boolean isEditada() {
		return editada;
	}

	/**
	 * @param editada
	 *            the editada to set
	 */
	public void setEditada(boolean editada) {
		this.editada = editada;
	}

}
