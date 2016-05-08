package Data;

import javax.persistence.*;

/**
 *
 * @author Martin
 * @param <T>
 */
public class GenericDAOImpl<T> implements GenericDAO<T> {
    
    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    protected EntityManager em = emf.createEntityManager();
    protected EntityTransaction tx = em.getTransaction();

    @Override
    public T createTx(T t) {
        tx.begin();
        em.persist(t);
        tx.commit();
        return t;
    }

    @Override
    public T updateTx(T t) {
        tx.begin();
        t = em.merge(t);
        tx.commit();
        return t;
    }

    @Override
    public void deleteTx(T t) {
        tx.begin();
        em.remove(t);
        tx.commit();
    }

    @Override
    public void delete(T t) {
        em.remove(t);
    }

    @Override
    public T update(T t) {
        return em.merge(t);
    }

    @Override
    public T create(T t) {
        return t;
    }

}
