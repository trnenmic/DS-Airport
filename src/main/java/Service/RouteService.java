package Service;

import Data.GenericDAOImpl;
import Model.Airplane;
import Model.Airport;
import Model.Route;
import Validator.InvalidAttributeException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Martin Cap
 */
public class RouteService extends GenericServiceImpl<Route> implements RouteManager {

    private Root<Route> root;

    private final GenericDAOImpl<Route> routeDAO = new GenericDAOImpl<>();
    
    private final AirportManager airportService = new AirportService();
    private final AirplaneManager airplaneService = new AirplaneService();

    public RouteService() {
        this.root = criteriaQuery.from(Route.class);
        this.criteriaQuery = criteriaQuery.select(root);
    }

    @Override
    public Route createRoute(Route route) throws InvalidAttributeException {
        // validation
        checkConstraints(route);
        return routeDAO.createTx(route);
    }
    
    @Override
    public Route updateRoute(Route route) throws InvalidAttributeException {
        // validation
        checkConstraints(route);
        return routeDAO.updateTx(route);

    }

    private void checkConstraints(Route route) throws InvalidAttributeException {
        if (route.getOrigin().getIdAirport() == route.getDestination().getIdAirport()) {
            throw new InvalidAttributeException("Route origin cannot be its destination and vice versa!");
        }
        
    }

    @Override
    public void deleteRoute(Route route) throws InvalidAttributeException {
        Route routeToRemove = em.find(Route.class, route.getIdRoute());
        tx.begin();
        em.remove(routeToRemove);
        tx.commit();
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
    public List<Route> findDestinations(Airport airport){
        refresh();
        List<Predicate> predicates = new ArrayList<>(1);
        predicates.add(criteriaBuilder.equal(root.get("destination"), airport));
        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("idRoute")));
        createResultList();
        return getCastedResult();
    }
    
        @Override
    public List<Route> findOrigins(Airport airport){
        refresh();
        List<Predicate> predicates = new ArrayList<>(1);
        predicates.add(criteriaBuilder.equal(root.get("origin"), airport));
        criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
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

    // END OF REDUNDANT METHODS //
    @Override
    public List<Route> findSpecified(String city1, String city2, String airportName1, String airportName2, String icao1, String icao2, String iata1, String iata2, String country1, String country2) {
        refresh();
        createResultList();

        List<Route> result = new ArrayList<>();

        boolean correct;

        for (Route r : getCastedResult()) {
            Airport origin = r.getOrigin();
            Airport destination = r.getDestination();

            correct = true;
            // origin
            if (correct && city1 != null) {
                if (!origin.getCity().equals(city1)) {
                    correct = false;
                }
            }
            if (correct && airportName1 != null) {
                if (!origin.getAirportName().equals(airportName1)) {
                    correct = false;
                }
            }
            if (correct && icao1 != null) {
                if (!origin.getIcao().equals(icao1)) {
                    correct = false;
                }
            }
            if (correct && iata1 != null) {
                if (!origin.getIata().equals(iata1)) {
                    correct = false;
                }
            }
            if (correct && country1 != null) {
                if (!origin.getCountry().equals(country1)) {
                    correct = false;
                }
            }

            // destination
            if (correct && city2 != null) {
                if (!destination.getCity().equals(city2)) {
                    correct = false;
                }
            }
            if (correct && airportName2 != null) {
                if (!destination.getAirportName().equals(airportName2)) {
                    correct = false;
                }
            }
            if (correct && icao2 != null) {
                if (!destination.getIcao().equals(icao2)) {
                    correct = false;
                }
            }
            if (correct && iata2 != null) {
                if (!destination.getIata().equals(iata2)) {
                    correct = false;
                }
            }
            if (correct && country2 != null) {
                if (!destination.getCountry().equals(country2)) {
                    correct = false;
                }
            }
            if (correct) {
                result.add(r);
            }
        }
        return result;
    }

    public void refresh() {
        em.clear();
        criteriaQuery = criteriaBuilder.createQuery();
        root = criteriaQuery.from(Route.class);
    }

    @Override
    public void updateRoutes(List<Route> routes) {
        System.out.println("start");
        for (Route r : routes) {
            System.out.println("update");
            routeDAO.update(r);
        }
        System.out.println("updated");
    }

}
