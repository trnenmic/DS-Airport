package Service;

import Model.Airport;
import Model.Route;
import java.util.List;
import javax.persistence.criteria.Root;

/**
 *
 * @author Martin
 */
public class AirportService extends GenericManagerImpl<Airport> implements AirportManager {
    
    private final Root<Airport> from;
    
    public AirportService() {
        this.from = criteriaQuery.from(Airport.class);
        this.select = criteriaQuery.select(from);
    }

    public Airport find(int idAirport) {
        return em.find(Airport.class, idAirport);
    }
    
    @Override
    public List<Airport> findAll() {
        update();
        resultList = typedQuery.getResultList();
        return getCastedResult();
    }
    
    @Override
    public List<Airport> findAllOrderedById() {
        select.orderBy(criteriaBuilder.asc(from.get("idAirport")));
        update();
        resultList = typedQuery.getResultList();
        return getCastedResult();
    }

    @Override
    public boolean eraseAirportRouteBound(int airportId, int routeId) {
        // TO DO
        return false;
    }

    @Override
    public List<Route> findJoinedOriginRoutes(Airport airport) {
        // TO DO
        return null;
    }

    @Override
    public List<Route> findJoinedDestinationRoutes(Airport airport) {
        // TO DO
        return null;
    }
    
}
