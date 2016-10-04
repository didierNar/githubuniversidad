package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase responsable de modelar un profesor
 * 
 * @author Didier_Narv�ez
 *
 */

@Entity
@Table(name="tb_docente")
public class Profesor extends Persona implements Serializable{
    
	@Column(name="postgrado_doc")
	private boolean postgrado;
	
	@ManyToOne
	@JoinColumn(name="profesion_doc")
	private Profesion profesion;

    public Profesor(){

    }

	/**
	 * @param cedula
	 * @param apellido
	 * @param correo
	 * @param direccion
	 * @param nombre
	 * @param telefono
	 * @param postgrado
	 * @param profesion
	 */
	public Profesor(String cedula, String apellido, String correo, String direccion, String nombre, String telefono,
			boolean postgrado, Profesion profesion) {
		super(cedula, apellido, correo, direccion, nombre, telefono);
		this.postgrado = postgrado;
		this.profesion = profesion;
	}

	public boolean isPostgrado() {
		return postgrado;
	}

	public void setPostgrado(boolean postgrado) {
		this.postgrado = postgrado;
	}

	public Profesion getProfesion() {
		return profesion;
	}

	public void setProfesion(Profesion profesion) {
		this.profesion = profesion;
	}
    
    
    
    
    
    

}
