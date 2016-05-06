package Service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Martin Cap
 * @param <T>
 */
public class GenericServiceImpl<T> {
    
    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    protected EntityManager em = emf.createEntityManager();
    protected EntityTransaction tx = em.getTransaction();
    protected CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    protected CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
    protected TypedQuery<Object> typedQuery;
    protected List<Object> resultList;
        
    protected void createResultList() {
        typedQuery = em.createQuery(criteriaQuery);
        resultList = typedQuery.getResultList();
    }
    
    protected void refreshResultList() {
        resultList = new ArrayList<>();
    }
    
    protected List<T> getCastedResult() {
        List<T> result = new ArrayList<>();
        for (Object o : resultList) {
            result.add((T)o);
        }
        return result;
    }

}
