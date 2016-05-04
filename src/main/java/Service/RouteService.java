package Service;

import Model.Airplane;
import Model.Airport;
import Model.Route;
import java.util.List;
import javax.persistence.criteria.Root;

/**
 *
 * @author Martin
 */
public class RouteService extends GenericManagerImpl<Route> implements RouteManager {
    
    private final Root<Route> from;
    
    public RouteService() {
        this.from = criteriaQuery.from(Route.class);
        this.criteriaQuery = criteriaQuery.select(from);
    }

    @Override
    public Route find(int idRoute) {
        return em.find(Route.class, idRoute);
    }
    
    @Override
    public List<Route> findAll() {
        createResultList();
        return getCastedResult();
    }
    
    @Override
    public List<Route> findAllOrderedById() {
        criteriaQuery.orderBy(criteriaBuilder.asc(from.get("idRoute")));
        createResultList();
        return getCastedResult();
    }

    @Override
    public List<Airplane> findJoinedAirplanes(Route route) {
        // TO DO
        return null;
    }

    @Override
    public boolean eraseRouteAirplaneBound(int routeId, int airplaneId) {
        // TO DO
        return false;
    }

    @Override
    public boolean eraseRouteAirportBound(int routeId, int airportId) {
        // TO DO
        return false;
    }

    @Override
    public Airport findOrigin(Route route) {
        // TO DO
        return null;
    }

    @Override
    public Airport findDestination(Route route) {
        // TO DO
        return null;
    }

    @Override
    public List<Route> findSpecified(String city1, String city2, String airportName1, String airportName2, String icao1, String icao2, String iata1, String iata2, String country1, String country2) {
        // TO DO
        return findAll();
    }
    
    
}
