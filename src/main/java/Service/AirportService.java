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
    
    private Root<Airport> root;
    
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
        refresh();
        createResultList();
//        System.out.println("findAll result list:");
//        for (Object o : resultList) {
//            System.out.println((Airport)o);
//        }
//        System.out.println();
        return getCastedResult();
    }
    
    @Override
    public List<Airport> findAllOrderedById() {
        refresh();
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
//        if (name == null && city == null && country == null && icao == null && iata == null) {
//            System.out.println("I AM HERE");
//            return findAll();
//        }
        // Podle me by to melo fungovat i bez te dlouhe if podminky, protoze se vytvori result list pro criteriaQuery.select(root) coz
        // je jako SELECT * FROM airport
        
        refresh();
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
        createResultList();
        System.out.println("findSpecified method result list:");
        for (Object a : resultList) {
            System.out.println((Airport)a);
        }
        System.out.println();


        return getCastedResult();
        
    }

    @Override
    public void refresh() {
        criteriaQuery = criteriaBuilder.createQuery();
        root = criteriaQuery.from(Airport.class);
    }
    
}
