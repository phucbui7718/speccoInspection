
package database;

import java.util.List;

import javax.persistence.EntityManager;

import model.Inspector;

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
}
