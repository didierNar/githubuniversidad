package co.edu.eam.ingesoftdesarrollo.universidad.persistencia.utilidades;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AdministradorEntityManager {
	
	private static EntityManager em;
	
	public static EntityManager getEntityManager(){
		
		if(em==null){
		 em = Persistence.createEntityManagerFactory("jpa_pu").createEntityManager();
		}
		return em;
		
	}

}
