package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAOSesionCurso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesor;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.SesionCurso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.utilidades.AdministradorEntityManager;

public class DAOSesionCursoJPA implements IDAOSesionCurso {

	public List<SesionCurso> listarSesionesDocente(Profesor p) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query q = em.createNamedQuery(SesionCurso.CONSULTA_LISTAR_HORARIOS_DOCENTE);
		q.setParameter(1, p);
		return q.getResultList();
	}

	public void crear(SesionCurso s) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(s);
		em.getTransaction().commit();
	}

	public void eliminarSesion(SesionCurso s) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		 SesionCurso ses = em.find(SesionCurso.class, s.getCodigo());
		// if (s != null) {
		System.out.println(s.getCodigo());
		System.out.println("Entró");

		Curso c=em.find(Curso.class, s.getCurso().getCodigo());
		c.getSesiones().remove(ses);
		em.merge(c);
		
		em.remove(ses);
		em.flush();	
		// }
		em.getTransaction().commit();
	
	}

}
