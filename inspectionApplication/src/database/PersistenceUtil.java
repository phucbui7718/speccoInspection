package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * This static utility class creates an returns the same EntityManager for
 * everyone. Allows code simplification; instead of doing the try/catch
 * everytime we need to access the database (wasting time and resources), we'll
 * do it once and return that same manager each time it's needed.
 *
 */
public class PersistenceUtil {

    private static final EntityManager entityManager = buildEntityManager();

    /**
     * Builds the EntityManager. Only needed to run once and set to private so
     * it can't be ran again.
     *
     * @return The built EntityManager
     * @throws ExceptionInInitializerError
     */


    private static EntityManager buildEntityManager() {
        try {
            EntityManagerFactory emf = Persistence
                    .createEntityManagerFactory("Software Project");
            return emf.createEntityManager();
        } catch (Throwable e) {
            System.err.println("Iniitial EntityManager Creation. " + e);
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * @return The already created EntityManager
     */
    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public static void shutdown() {
        getEntityManager().close();
    }

}