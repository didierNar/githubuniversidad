package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jpa;

import javax.persistence.EntityManager;

import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAOProfesor;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesor;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.utilidades.AdministradorEntityManager;

public class DAOProfesorJPA implements IDAOProfesor {

	public void crear(Profesor p) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}

	public void editar(Profesor p) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();		
	}

	public Profesor buscar(String ced) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		return em.find(Profesor.class, ced);
	}

	public void eliminar(String ced) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		Profesor p = em.find(Profesor.class, ced);
		em.remove(em.merge(p));		
		em.getTransaction().commit();
	}

}
