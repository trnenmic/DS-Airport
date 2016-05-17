package Service;

import Data.GenericDAOImpl;
import Model.Airport;
import Model.Route;
import Validator.InvalidAttributeException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
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
        checkConstraints(airport);
        return airportDAO.createTx(airport);
    }

    @Override
    public Airport updateAirport(Airport airport) throws InvalidAttributeException {
        // validation
        checkConstraints(airport);
        return airportDAO.updateTx(airport);
    }
    

    private void checkConstraints(Airport airport) throws InvalidAttributeException {
        // tmp values for optimisation
        String tmpIcao = airport.getIcao();
        String tmpIata = airport.getIata();
        // check correct_iata_length
        if (tmpIata.length() != 3) {
            throw new InvalidAttributeException("IATA code must be 3 characters long!");
        }
        // check correct_icao_length
        if (tmpIcao.length() != 4) {
            throw new InvalidAttributeException("ICAO code must be 4 characters long!");
        }
        // check UNIQUE constraints
        List<Airport> allAirports = findAll();
        int tmpIdAirport = airport.getIdAirport();
        for (Airport a : allAirports) {
            if (tmpIdAirport != a.getIdAirport()) {
                if (tmpIcao.equals(a.getIcao())) {
                    throw new InvalidAttributeException("ICAO code must be unique!");
                }
                if (tmpIata.equals(a.getIata())) {
                    throw new InvalidAttributeException("IATA code must be unique!");
                }
            }
        }
    }

    @Override
    public void deleteAirport(Airport airport) throws InvalidAttributeException {

        // validation
        //Airport a = em.getReference(Airport.class, airport.getIdAirport());
//        System.out.println("so????");
        //em.remove(airport);
        //airportDAO.delete(airport);
        
        Airport airportToRemove = em.find(Airport.class, airport.getIdAirport());
        tx.begin();
        em.remove(airportToRemove);
        tx.commit();
        /*
        Airport airportToRemove = em.find(Airport.class, airport.getIdAirport());
        Route tmp;
        RouteManager routeService = new RouteService();
        
        System.out.println("number of routes where the airport is the destination: " + airportToRemove.getDestinations().size());
        for (Route r : airportToRemove.getDestinations()) {
            tmp = em.find(Route.class, r.getIdRoute());
            System.out.println(tmp);
//            tmp.setDestination(null);
        }
        
        System.out.println("number of routes where the airport is the origin: " + airportToRemove.getOrigins().size());
        for (Route r : airportToRemove.getOrigins()) {
            tmp = em.find(Route.class, r.getIdRoute());
            System.out.println(tmp);
//            tmp.setDestination(null);
        }*/
        
        
        
//        tx.begin();
//        for (Route r : airportToRemove.getDestinations()) {
//            tmp = em.find(Route.class, r.getIdRoute());
//            tmp.setDestination(null);
//            routeService.updateRoute(tmp);
//        }
//        for (Route r : airportToRemove.getOrigins()) {
//            tmp = em.find(Route.class, r.getIdRoute());
//            tmp.setOrigin(null);
//            routeService.updateRoute(tmp);
//        }
//        em.remove(airportToRemove);
//        tx.commit();
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

    @Override
    public List<Airport> findSpecifiedAlternate(String name, String city, String country, String icao, String iata) {
        TypedQuery<Airport> query = em.createQuery("SELECT a FROM Airport a WHERE (:name IS NULL OR a.airportName = :name) "
                + "AND (:city IS NULL OR a.city = :city) AND (:country IS NULL OR a.country = :country) AND (:icao IS NULL OR a.icao = :icao) "
                + "AND (:iata IS NULL OR a.iata = :iata)", Airport.class);

        query.setParameter("name", name);
        query.setParameter("city", city);
        query.setParameter("country", country);
        query.setParameter("icao", icao);
        query.setParameter("iata", iata);
        
        return query.getResultList();
    }

    public void refresh() {
        em.clear();
        criteriaQuery = criteriaBuilder.createQuery();
        root = criteriaQuery.from(Airport.class);
    }

    @Override
    public Airport createAirport(Airport airport, String name, String city, String country, String iata, String icao) throws InvalidAttributeException {
        setAttributes(airport, name, city, country, iata, icao);
        return createAirport(airport);
    }

    @Override
    public Airport updateAirport(Airport airport, String name, String city, String country, String iata, String icao) throws InvalidAttributeException {
        setAttributes(airport, name, city, country, iata, icao);
        return updateAirport(airport);
    }

    private void setAttributes(Airport airport, String name, String city, String country, String iata, String icao) {
        airport.setAirportName(name);
        airport.setCity(city);
        airport.setCountry(country);
        airport.setIata(iata);
        airport.setIcao(icao);
    }

    @Override
    public void updateAirports(List<Airport> airports) {
        for (Airport a : airports) {
            airportDAO.update(a);
        }
    }

}
