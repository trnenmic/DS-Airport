package Data;

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
public class GenericDAOImpl<T> implements GenericDAO<T> {

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    protected EntityManager em = emf.createEntityManager();
    protected EntityTransaction tx = em.getTransaction();
    protected CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    protected CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();

    @Override
    public T create(T t) {
        tx.begin();
        em.persist(t);
        tx.commit();
        return t;
    }

    @Override
    public T update(T t) {
        tx.begin();
        em.merge(t);
        tx.commit();
        return t;
    }

    @Override
    public void delete(T t) {
        tx.begin();
        em.remove(t);
        tx.commit();
    }

}
