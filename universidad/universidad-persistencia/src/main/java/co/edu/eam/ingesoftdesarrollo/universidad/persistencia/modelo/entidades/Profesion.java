package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Clase que representa una profesion docente.
 * @author Camilo Andres Ferrer Butsos.
 *
 */
@Entity
@Table(name="tb_profesion")
@NamedQueries({
@NamedQuery(name=Profesion.LISTAR_PROFESIONES, query = "SELECT p FROM Profesion p")
})
public class Profesion implements Serializable{
	
	/**
	 * Lista las profesiones
	 */
	public static final String LISTAR_PROFESIONES = "Profesion.listarProfesiones";
	
	/**
	 * codigo de la profesion.
	 */
	@Id
	@Column(name="codigo_prof")
	private String codigo;
	/**
	 * Nombre de la profesion.
	 */
	@Column(name="nombre_prof", nullable=false)
	private String nombre;
	
	/**
	 * COnstructor.
	 */
	public Profesion() {
		super();
	}

	/**
	 * @param codigo
	 * @param nombre
	 */
	public Profesion(String codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
	
	
	
}
