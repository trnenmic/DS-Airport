package Data;

import Model.Airplane;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

/**
 *
 * @author Martin
 */
public class AirplaneDAO extends GenericDAOImpl {

    /*
    private final Root<Airplane> from = criteriaQuery.from(Airplane.class);
    private final CriteriaQuery<Object> select = criteriaQuery.select(from);
    private TypedQuery<Object> typedQuery;
    private List<Object> resultList;

    public Airplane find(int idAirplane) {
        return em.find(Airplane.class, idAirplane);
    }
    
    public List<Airplane> findAll() {
        update();
        resultList = typedQuery.getResultList();
        List<Airplane> result = new ArrayList<>();
        cast(result);
        return result;
    }
    
    public List<Airplane> findAllOrderedByID() {
        select.orderBy(criteriaBuilder.asc(from.get("idAirplane")));
        update();
        resultList = typedQuery.getResultList();
        List<Airplane> result = new ArrayList<>();
        cast(result);
        return result;
    }
    
    public List<Airplane> findAllOrderedByCapacity() {
        select.orderBy(criteriaBuilder.asc(from.get("capacity")));
        update();
        resultList = typedQuery.getResultList();
        List<Airplane> result = new ArrayList<>();
        cast(result);
        return result;
    }
    
    private void update() {
        typedQuery = em.createQuery(select);
    }
    
    private void cast(List<Airplane> result) {
        for (Object o : resultList) {
            result.add((Airplane)o);
        }
    }*/
    

}
