package Data;

import Model.Airport;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Martin
 */
public class AirportDAO extends GenericDAOImpl {
   /*
    private final Root<Airport> from = criteriaQuery.from(Airport.class);
    private final CriteriaQuery<Object> select = criteriaQuery.select(from);
    private TypedQuery<Object> typedQuery;
    private List<Object> resultList;

    public Airport find(int idAirport) {
        return em.find(Airport.class, idAirport);
    }
    
    public List<Airport> findAll() {
        update();
        resultList = typedQuery.getResultList();
        List<Airport> result = new ArrayList<>();
        cast(result);
        return result;
    }
    
    public List<Airport> findAllOrderedByID() {
        select.orderBy(criteriaBuilder.asc(from.get("idAirport")));
        update();
        resultList = typedQuery.getResultList();
        List<Airport> result = new ArrayList<>();
        cast(result);
        return result;
    }
    
    private void update() {
        typedQuery = em.createQuery(select);
    }
    
    private void cast(List<Airport> result) {
        for (Object o : resultList) {
            result.add((Airport)o);
        }
    }*/
}
