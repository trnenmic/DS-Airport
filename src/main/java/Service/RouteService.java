package Service;

import Model.Airplane;
import Model.Airport;
import Model.Route;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Root;

/**
 *
 * @author Martin
 */
public class RouteService extends GenericManagerImpl<Route> implements RouteManager {
    
    private Root<Route> root;
    
    public RouteService() {
        this.root = criteriaQuery.from(Route.class);
        this.criteriaQuery = criteriaQuery.select(root);
    }

    @Override
    public Route find(int idRoute) {
        return em.find(Route.class, idRoute);
    }
    
    @Override
    public List<Route> findAll() {
        refresh();
        createResultList();
        return getCastedResult();
    }
    
    @Override
    public List<Route> findAllOrderedById() {
        refresh();
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("idRoute")));
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

    // REDUNDANT METHODS //
    
    /**
     * REDUNDANT --> you can get the origin from the route itself !!!
     * @param route
     * @return 
     */
    @Override
    public Airport findOrigin(Route route) {
        return route.getOrigin();
    }

    @Override
    public Airport findDestination(Route route) {
        return route.getDestination();
    }
    
    // END OF REDUNDANT METHODS //
    
    // Weird method - I have implemented it though...
    @Override
    public List<Route> findSpecified(String city1, String city2, String airportName1, String airportName2, String icao1, String icao2, String iata1, String iata2, String country1, String country2) {
        refresh();
        createResultList();
        
        List<Route> result = new ArrayList<>();
        
        for (Route r : getCastedResult()) {
            Airport origin = r.getOrigin();
            Airport destination = r.getDestination();
            
            if (origin.getAirportName().equals(airportName1) &&
                    origin.getCity().equals(city1) &&
                    origin.getIcao().equals(icao1) &&
                    origin.getIata().equals(iata1) &&
                    origin.getCountry().equals(country1) &&
                destination.getAirportName().equals(airportName2) &&
                    destination.getCity().equals(city2) &&
                    destination.getIcao().equals(icao2) &&
                    destination.getIata().equals(iata2) &&
                    destination.getCountry().equals(country2)) {
                result.add(r);
            }
        }
        return result;
    }
    
    @Override
    public void refresh() {
        criteriaQuery = criteriaBuilder.createQuery();
        root = criteriaQuery.from(Route.class);
    }
    
    
}
