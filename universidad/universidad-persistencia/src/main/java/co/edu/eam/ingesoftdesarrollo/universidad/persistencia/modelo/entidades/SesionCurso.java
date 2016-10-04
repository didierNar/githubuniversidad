package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import co.edu.eam.disenosoft.universidad.modelo.enumeraciones.DiaEnum;

/**
 * Clase que representa una sesion de un curso.
 * @author Camilo Andres Ferrer Bustos.
 *
 */
@Entity
@Table(name="tb_sesioncurso")
@NamedQueries({
	@NamedQuery(name=SesionCurso.CONSULTA_LISTAR_HORARIOS_DOCENTE, 
			query = "SELECT s FROM SesionCurso s JOIN s.curso c WHERE c.profesor=?1")
})
public class SesionCurso implements Serializable{

	/**
	 * Consulta para listar los horarios de clases que tiene un profesor
	 * ?1: profesor
	 */
	public static final String CONSULTA_LISTAR_HORARIOS_DOCENTE = "SesionCurso.listarHorariosProfesor";
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	
	/**
	 * Curso de la sesion.
	 */
	@JoinColumn(name="codigo_curso", nullable=false)
	@ManyToOne
	private Curso curso;

	/**
	 * Dia de la sesion.
	 */
	@Column(name="dia_sesion", nullable=false)
	@Enumerated(EnumType.STRING)
	private DiaEnum dia;

	/**
	 * Hora en que empieza una sesion.
	 */
	@Column(name="horainicio_sesion", nullable=false)
	private int horaInicio;

	/**
	 * Hora en que termina la sesion.
	 */
	@Column(name="horafinal_sesion", nullable=false)
	private int horaFinal;

	/**
	 * Cosntructor.
	 */
	public SesionCurso() {
		super();
	}


	/**
	 * @param curso
	 * @param dia
	 * @param horaInicio
	 * @param horaFinal
	 */
	public SesionCurso(Curso curso, DiaEnum dia, int horaInicio, int horaFinal) {
		super();
		this.curso = curso;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
	}




	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}


	/**
	 * @param codigo the codigo to set
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
	 * @param curso the curso to set
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	/**
	 * @return the dia
	 */
	public DiaEnum getDia() {
		return dia;
	}

	/**
	 * @param dia the dia to set
	 */
	public void setDia(DiaEnum dia) {
		this.dia = dia;
	}

	/**
	 * @return the horaInicio
	 */
	public int getHoraInicio() {
		return horaInicio;
	}

	/**
	 * @param horaInicio the horaInicio to set
	 */
	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	/**
	 * @return the horaFinal
	 */
	public int getHoraFinal() {
		return horaFinal;
	}

	/**
	 * @param horaFinal the horaFinal to set
	 */
	public void setHoraFinal(int horaFinal) {
		this.horaFinal = horaFinal;
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
		SesionCurso other = (SesionCurso) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	

}
