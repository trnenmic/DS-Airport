package Service;

import Model.Flight;
import java.util.List;
import javax.persistence.criteria.Root;

/**
 *
 * @author Martin
 */
public class FlightService extends GenericManagerImpl<Flight>{
    
    private final Root<Flight> from;

    public FlightService() {
        this.from = criteriaQuery.from(Flight.class);
        this.select = criteriaQuery.select(from);
    }
    
    public Flight find(int idFlight) {
        return em.find(Flight.class, idFlight);
    }
    
    public List<Flight> findAll() {
        update();
        resultList = typedQuery.getResultList();
        return getCastedResult();
    }
    
    public List<Flight> findAllOrderedByID() {
        select.orderBy(criteriaBuilder.asc(from.get("idFlight")));
        update();
        resultList = typedQuery.getResultList();
        return getCastedResult();
    }
    
}
