package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jpa;

import javax.persistence.EntityManager;

import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAOEstudiante;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesor;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.utilidades.AdministradorEntityManager;

/**
 * 
 * @author LuchoBolivar
 *
 */
public class DAOEstudianteJPA implements IDAOEstudiante {

	public void crear(Estudiante p) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();

	}

	public void editar(Estudiante p) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.merge(p);
		em.getTransaction().commit();

	}

	public Estudiante buscar(String ced) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		return em.find(Estudiante.class, ced);
	}

	public void eliminar(Estudiante p) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();

		em.getTransaction().begin();
		Estudiante c = em.find(Estudiante.class, p);
		if (c != null) {
			em.remove(c);
		}
		em.getTransaction().commit();

	}

	public void eliminar(String ced) throws Exception {
		// TODO Auto-generated method stub

		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		Estudiante e = em.find(Estudiante.class, ced);
		if (e != null){
		em.remove(e);
		}
		em.getTransaction().commit();
		
	}
}
