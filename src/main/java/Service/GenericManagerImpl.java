package Service;

import Model.Airport;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Martin
 * @param <T>
 */
public class GenericManagerImpl<T> implements GenericManager<T> {
    
    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    protected EntityManager em = emf.createEntityManager();
    protected EntityTransaction tx = em.getTransaction();
    protected CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    protected CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
    protected CriteriaQuery<Object> select;
    protected TypedQuery<Object> typedQuery;
    protected List<Object> resultList;

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
    
    protected void update() {
        typedQuery = em.createQuery(select);
    }
    
    protected void cast(List<T> result) {
        for (Object o : resultList) {
            result.add((T)o);
        }
    }

}
