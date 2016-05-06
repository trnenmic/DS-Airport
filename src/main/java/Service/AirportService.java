package Service;

import Data.GenericDAOImpl;
import Model.Airport;
import Model.Route;
import Validator.InvalidAttributeException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Martin Cap
 */
public class AirportService extends GenericServiceImpl<Airport> implements AirportManager {

    private Root<Airport> root;

    private final GenericDAOImpl<Airport> airportDAO = new GenericDAOImpl<>();

    public AirportService() {
        this.root = criteriaQuery.from(Airport.class);
        this.criteriaQuery = criteriaQuery.select(root);
    }

    @Override
    public Airport createAirport(Airport airport) throws InvalidAttributeException {

        // validation
        return airportDAO.create(airport);
    }

    @Override
    public Airport updateAirport(Airport airport) throws InvalidAttributeException {

        // validation
        return airportDAO.update(airport);
    }

    @Override
    public void deleteAirport(Airport airport) throws InvalidAttributeException {

        // validation
        airportDAO.delete(airport);
    }

    @Override
    public Airport find(int idAirport) {
        return em.find(Airport.class, idAirport);
    }

    @Override
    public List<Airport> findAll() {
        refresh();
        createResultList();
        return getCastedResult();
    }
    
    @Override
    public List<Airport> findAllOrdered() {
        refresh();
        List<Order> orders = new ArrayList<>(3);
        
        orders.add(criteriaBuilder.asc(root.get("airportName")));
        orders.add(criteriaBuilder.asc(root.get("city")));
        orders.add(criteriaBuilder.asc(root.get("country")));
        criteriaQuery.orderBy(orders.toArray(new Order[orders.size()]));

        createResultList();
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
        refresh();
        List<Predicate> predicates = new ArrayList<>(5);
        List<Order> orders = new ArrayList<>(3);
        orders.add(criteriaBuilder.asc(root.get("airportName")));
        orders.add(criteriaBuilder.asc(root.get("city")));
        orders.add(criteriaBuilder.asc(root.get("country")));
        
        if (name != null) {
            predicates.add(criteriaBuilder.equal(root.get("airportName"), name));
        }
        if (city != null) {
            predicates.add(criteriaBuilder.equal(root.get("city"), city));
        }
        if (country != null) {
            predicates.add(criteriaBuilder.equal(root.get("country"), country));
        }
        if (icao != null) {
            predicates.add(criteriaBuilder.equal(root.get("icao"), icao));
        }
        if (iata != null) {
            predicates.add(criteriaBuilder.equal(root.get("iata"), iata));
        }
        if (!predicates.isEmpty()) {
            criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        }
        criteriaQuery.orderBy(orders.toArray(new Order[orders.size()]));
        createResultList();
        return getCastedResult();
    }

//    Tohle je sileny, ani to nefiltruje spravne (pokud zadas napr. Heathrow a Prague, tak najde obe letiste)
//    @Override
//    public List<Airport> findSpecified(String name, String city, String country, String icao, String iata) {
//        refresh();
//        if (name == null && city == null && country == null && icao == null && iata == null) {
//            createResultList();
//            return getCastedResult();
//        }
//        Set<Object> resultSet = new HashSet<>();
//        
//        if (name != null) {
//            //tady to rovna se nedela zadny rozdil, radsi jsem ho tu nechal 
//            criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("airportName"), name));
//            createResultList();
//            if (resultList.isEmpty()) {
//                return getCastedResult();
//            }
//            resultSet.addAll(resultList);
//        }
//        if (city != null) {
//            criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("city"), city));
//            createResultList();
//            if (resultList.isEmpty()) {
//                return getCastedResult();
//            }
//            resultSet.addAll(resultList);
//        }
//        if (country != null) {
//            criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("country"), country));
//            createResultList();
//            if (resultList.isEmpty()) {
//                return getCastedResult();
//            }
//            resultSet.addAll(resultList);
//        }
//        if (icao != null) {
//            criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("icao"), icao));
//            createResultList();
//            if (resultList.isEmpty()) {
//                return getCastedResult();
//            }
//            resultSet.addAll(resultList);
//        }
//        if (iata != null) {
//            criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("iata"), iata));
//            createResultList();
//            if (resultList.isEmpty()) {
//                return getCastedResult();
//            }
//            resultSet.addAll(resultList);
//        }
//        refreshResultList();
//        for (Object o : resultSet) {
//            resultList.add((Airport)o);
//        }
//        return getCastedResult();
//    }
    public void refresh() {
        criteriaQuery = criteriaBuilder.createQuery();
        root = criteriaQuery.from(Airport.class);
    }
}
