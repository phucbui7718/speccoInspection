package testingpackage;

import javax.persistence.EntityManager;

import database.PersistenceUtil;
import model.Inspector;
import model.Report;

public class testingApp {

	public static void main(String[] args) {
	Inspector inspector = new Inspector();
	
        inspector.setInspFirstname("Adaa");
        inspector.setInspLastname("Johnson");
        inspector.setInspUsername("justinoferrer");
        inspector.setInspPassword("specco");
// Adding a new report or an inspector
		EntityManager em = PersistenceUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(inspector);
		em.getTransaction().commit();	
	}
}
