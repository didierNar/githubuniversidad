package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jpa;


import javax.persistence.EntityManager;

import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAOAsignatura;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.utilidades.AdministradorEntityManager;

public class DAOAsignaturaJPA implements IDAOAsignatura {

	public void crear(Asignatura a) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(a);
		em.getTransaction().commit();
	}

	public void editar(Asignatura a) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.merge(a);
		em.getTransaction().commit();

	}

	public Asignatura buscar(String cod) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		return em.find(Asignatura.class, cod);
	}

	/**
	 *  Elimina una asignatura de la base de datos
	 */
	public void eliminar(String cod) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		Asignatura a = em.find(Asignatura.class, cod);
		if (a != null) {
			em.remove(a);
		}
		em.getTransaction().commit();
	}

}
