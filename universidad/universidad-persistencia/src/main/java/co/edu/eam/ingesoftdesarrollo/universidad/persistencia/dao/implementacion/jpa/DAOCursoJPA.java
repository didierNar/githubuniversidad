package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAOCurso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Profesor;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.utilidades.AdministradorEntityManager;

/**
 * Clase encargada de implemetar los métodos de la interface Curso
 * @author Didier_Narváez
 *
 */
public class DAOCursoJPA implements IDAOCurso{

	/**
	 * crea un curso
	 * @param c Curso que se va a crear
	 */
	public void crear(Curso c) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}

	/**
	 * Busca un curso
	 * @param cod Codigo del curso que se desea bucar
	 */
	public Curso buscar(String cod) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		return em.find(Curso.class, cod);
	}

	/**
	 * Edita un curso
	 * @param c Curso que se desea editar
	 */
	public void editar(Curso c) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.merge(c);
		em.flush();
		em.getTransaction().commit();
	}

	public List<Curso> cursosAsignatura(Asignatura as) throws Exception {
		EntityManager en = AdministradorEntityManager.getEntityManager();
		Query q = en.createNamedQuery(Curso.LISTA_CURSOS_ASIGNATURA);
		q.setParameter(1, as);
		List<Curso> cursos = q.getResultList();
		return cursos;
	}

	public List<Curso> cursosDocente (Profesor d) throws Exception{
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query q = em.createNamedQuery(Curso.CURSOS_DOCENTE);
		q.setParameter(1, d);
		List<Curso> lista = q.getResultList();
		return lista;
	}
	
}
