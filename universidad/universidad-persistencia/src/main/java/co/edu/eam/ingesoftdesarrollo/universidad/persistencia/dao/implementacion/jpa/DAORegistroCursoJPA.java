package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.dao.definiciones.IDAORegistroCurso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Asignatura;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Curso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.Estudiante;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.RegistroCurso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.modelo.entidades.SesionCurso;
import co.edu.eam.ingesoftdesarrollo.universidad.persistencia.utilidades.AdministradorEntityManager;

public class DAORegistroCursoJPA implements IDAORegistroCurso {

	public void crear(RegistroCurso r) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
	}

	public List<RegistroCurso> buscarCursoEstudiante(Estudiante es, Curso c) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query q = em.createNamedQuery(RegistroCurso.BUSCAR_REGISTROCURSO_ESTUDIANTE);
		q.setParameter(1, es);
		q.setParameter(2, c);
		List<RegistroCurso> lista = q.getResultList();
		return lista;
	}

	public int sumatoriaCreditos(Estudiante e) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query q = em.createNamedQuery(RegistroCurso.CREDITOS_REGISTRADOS_ESTUDIANTE);
		q.setParameter(1, e);
		List<Long> lista = q.getResultList();
		if (lista.get(0) == null) {
			return 0;
		} else {
			return lista.get(0).intValue();
		}
	}

	public int estudiantesCurso(Curso c) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query q = em.createNamedQuery(RegistroCurso.ESTUDIANTES_CURSO);
		q.setParameter(1, c);
		List<Integer> lista = q.getResultList();
		if (lista == null) {
			return 0;
		} else {
			return lista.size();
		}
	}

	public void eliminarRegistro(Estudiante e, String nomAsign) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		em.getTransaction().begin();
		Query q = em.createNamedQuery(RegistroCurso.BUSCAR_REGISTRO_ESTUDIANTE);
		q.setParameter(1, e);
		q.setParameter(2, nomAsign);
		List<RegistroCurso> lista = q.getResultList();
		RegistroCurso reg = lista.get(0);
		em.remove(reg);
		em.getTransaction().commit();
	}

	public List<RegistroCurso> registrosEstudiante(Estudiante e) throws Exception {
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query q = em.createNamedQuery(RegistroCurso.REGISTROS_ESTUDIANTE);
		q.setParameter(1, e);
		List<RegistroCurso> lista = q.getResultList();
		return lista;
	}
	
	/**
	 * Busca los estudiantes de un curso 
	 * @param c Curso en el que se buscarán los estudiantes	
	 * @return lista de estudiantes del curso
	 * @throws Exception Si falla la operación
	 */
	public List<Estudiante> buscarEstudiantesCurso (Curso c) throws Exception{
		EntityManager em = AdministradorEntityManager.getEntityManager();
		Query q = em.createNamedQuery(RegistroCurso.ESTUDIANTES_CURSO);
		q.setParameter(1, c);
		List<Estudiante> lista = q.getResultList();
		return lista;
	}

}
