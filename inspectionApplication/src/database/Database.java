
package database;

import java.util.List;

import javax.persistence.EntityManager;

import model.Inspector;
import model.Report;
import model.SwpppReport;

public class Database {
  public static Inspector getInspector(String username, String password){
	  EntityManager em = PersistenceUtil.getEntityManager();
	  List<Inspector> i = em.createQuery("Select i FROM Inspector i WHERE i.inspUsername=?1 AND i.inspPassword=?2", Inspector.class)
			  .setParameter(1, username.toUpperCase())
			  .setParameter(2, password).getResultList();
	  if (i.size() > 0){
		  
		  return i.get(0);
	  }
	  
	return null; 
  }
  
  public static void submitReport(Report report){
	  
	  EntityManager em = PersistenceUtil.getEntityManager();
	  em.getTransaction().begin();
	  em.persist(report);
	  em.getTransaction().commit();
  }
  
  public static void submitSwpppReport(SwpppReport swpppReport){
	  EntityManager em = PersistenceUtil.getEntityManager();
	  em.getTransaction().begin();
	  em.persist(swpppReport);
	  em.getTransaction().commit();
  }
  
}
