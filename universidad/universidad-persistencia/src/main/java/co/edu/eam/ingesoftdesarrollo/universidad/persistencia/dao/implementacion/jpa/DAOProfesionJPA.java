package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAOProfesion;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesion;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.utilidades.AdministradorEntityManager;

public class DAOProfesionJPA implements IDAOProfesion {

	public List<Profesion> listaProfesiones() throws Exception {
		EntityManager en = AdministradorEntityManager.getEntityManager();
		Query q = en.createNamedQuery(Profesion.LISTAR_PROFESIONES);
		List<Profesion> prof = q.getResultList();
		return prof;
	}

	public Profesion buscarProfesion(String cod) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		return em.find(Profesion.class, cod);
	}

	public Profesion buscarProfesionNom(String nom) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		return em.find(Profesion.class, nom);
	}

	
	
}
