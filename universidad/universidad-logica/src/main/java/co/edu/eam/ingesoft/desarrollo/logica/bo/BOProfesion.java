package co.edu.eam.ingesoft.desarrollo.logica.bo;

import java.util.List;

import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAOProfesion;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jpa.DAOProfesionJPA;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesion;

public class BOProfesion {

	private IDAOProfesion daoProfesion;
	
	public BOProfesion() {
		// TODO Auto-generated constructor stub
		daoProfesion = new DAOProfesionJPA();
	}
	/**
	 * Permite listar las profesiones registradas
	 * @return las profesiones regstradas en la base de datos
	 * @throws Exception si falla la operaci�n
	 */
	public List<Profesion> listar () throws Exception{
		return daoProfesion.listaProfesiones();
	}
	/**
	 * Permite buscar una profesi�n pr su c�digo
	 * @param cod codigo de la profesi�n que se desea buscar
	 * @return la profesi�n si la encuentra, de lo contrario null
	 * @throws Exception en caso de que falle la operaci�n
	 */
	public Profesion buscarCodigo (String cod) throws Exception{
		return daoProfesion.buscarProfesion(cod);
	}
	
	/**
	 * Busca una profesi�n por su nombre
	 * @param nom nombre de la profesi�n que se desea buscar
	 * @return la profesi�n si la encuantra, de lo contrario null
	 * @throws Exception en caso de que falle la operaci�n
	 */
	public Profesion buscarNombre (String nom) throws Exception{
		return daoProfesion.buscarProfesionNom(nom);
	}
	
}
