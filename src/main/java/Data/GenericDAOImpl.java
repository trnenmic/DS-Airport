package Data;

import Model.Identifiable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.*;

/**
 *
 * @author Martin
 * @param <T>
 */
public class GenericDAOImpl implements GenericDAO {

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    protected EntityManager em = null;
    protected EntityTransaction tx = null;
    /*protected CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    protected CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
*/
    @Override
    public Identifiable create(Identifiable t) {
        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
        em.persist(t);
        tx.commit();
        return t;
    }

    @Override
    public Identifiable update(Identifiable t) {
        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
        em.merge(t);
        tx.commit();
        return t;
    }

    @Override
    public void delete(Identifiable t) {
        em = emf.createEntityManager();
        tx = em.getTransaction();
        tx.begin();
        t = em.getReference(t.getClass(), t.getId());
        em.remove(t);
        tx.commit();
    }

    @Override
    public Object refresh(Object t) {
        if (!em.contains(t)) {
            em.refresh(t);
        }
        return t;
    }

}
