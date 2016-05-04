package Service;

import Model.Airport;
import Model.Route;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Martin
 */
public class AirportService extends GenericManagerImpl<Airport> implements AirportManager {
    
    private final Root<Airport> root;
    
    public AirportService() {
        this.root = criteriaQuery.from(Airport.class);
        this.criteriaQuery = criteriaQuery.select(root);
    }

    @Override
    public Airport find(int idAirport) {
        return em.find(Airport.class, idAirport);
    }
    
    @Override
    public List<Airport> findAll() {
        createResultList();
        return getCastedResult();
    }
    
    @Override
    public List<Airport> findAllOrderedById() {
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("idAirport")));
        createResultList();
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

    @Override
    public List<Airport> findSpecified(String name, String city, String country, String icao, String iata) {
        criteriaQuery = criteriaQuery.select(root);
        if (name != null) {
            criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("airportName"), name));
        }
        if (city != null) {
            criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("city"), city));
        }
        if (country != null) {
            criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("country"), country));
        }
        if (icao != null) {
            criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("icao"), icao));
        }
        if (iata != null) {
            criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("iata"), iata));
        }
        if (name == null && city == null && country == null && icao == null && iata == null) {
            return findAll();
        }
        createResultList();
        return getCastedResult();
    }
    
}
