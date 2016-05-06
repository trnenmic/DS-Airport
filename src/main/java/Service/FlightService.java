package Service;

import Model.Flight;
import java.util.List;
import javax.persistence.criteria.Root;

/**
 *
 * @author Martin
 */
public class FlightService extends GenericManagerImpl<Flight>{
    
    private Root<Flight> root;

    public FlightService() {
        this.root = criteriaQuery.from(Flight.class);
        this.criteriaQuery = criteriaQuery.select(root);
    }
    
    public Flight find(int idFlight) {
        return em.find(Flight.class, idFlight);
    }
    
    public List<Flight> findAll() {
        refresh();
        createResultList();
        return getCastedResult();
    }
    
    public List<Flight> findAllOrderedByID() {
        refresh();
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("idFlight")));
        createResultList();
        return getCastedResult();
    }
    
    public void refresh() {
        criteriaQuery = criteriaBuilder.createQuery();
        root = criteriaQuery.from(Flight.class);
    }
    
    
}
