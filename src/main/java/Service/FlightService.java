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
        this.criteriaQuery = criteriaQuery.select(from);
    }
    
    public Flight find(int idFlight) {
        return em.find(Flight.class, idFlight);
    }
    
    public List<Flight> findAll() {
        createResultList();
        return getCastedResult();
    }
    
    public List<Flight> findAllOrderedByID() {
        criteriaQuery.orderBy(criteriaBuilder.asc(from.get("idFlight")));
        createResultList();
        return getCastedResult();
    }
    
}
