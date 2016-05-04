package Data;

import Model.Flight;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Martin
 */
public class FlightDAO extends GenericDAOImpl {
    /*
    private final Root<Flight> from = criteriaQuery.from(Flight.class);
    private final CriteriaQuery<Object> select = criteriaQuery.select(from);
    private TypedQuery<Object> typedQuery;
    private List<Object> resultList;

    public Flight find(int idFlight) {
        return em.find(Flight.class, idFlight);
    }
    
    public List<Flight> findAll() {
        update();
        resultList = typedQuery.getResultList();
        List<Flight> result = new ArrayList<>();
        cast(result);
        return result;
    }
    
    public List<Flight> findAllOrderedByID() {
        select.orderBy(criteriaBuilder.asc(from.get("idFlight")));
        update();
        resultList = typedQuery.getResultList();
        List<Flight> result = new ArrayList<>();
        cast(result);
        return result;
    }
    
    private void update() {
        typedQuery = em.createQuery(select);
    }
    
    private void cast(List<Flight> result) {
        for (Object o : resultList) {
            result.add((Flight)o);
        }
    }*/
}
