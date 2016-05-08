package Service;

import Model.Airplane;
import Model.Airport;
import Model.Route;
import Service.ManagementProvider;
import Validator.InvalidAttributeException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author M
 */
public class RelationService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    List<Airplane> airplanes = new ArrayList<>();
    List<Route> routes = new ArrayList<>();
    List<Airport> airports = new ArrayList<>();

    AirplaneManager airplaneManager;
    AirportManager airportManager;
    RouteManager routeManager;

    public RelationService(AirplaneManager airplaneManager, AirportManager airportManager, RouteManager routeManager) {
        this.airplaneManager = airplaneManager;
        this.airportManager = airportManager;
        this.routeManager = routeManager;
    }

    public void updateBoundingsTx() throws InvalidAttributeException {
        tx.begin();
        updateBoundings();
        tx.commit();
    }

    public void updateBoundings() throws InvalidAttributeException {
        airplaneManager.updateAirplanes(airplanes);
        airportManager.updateAirports(airports);
        routeManager.updateRoutes(routes);
        clean();
    }

    public void deleteAirplane(Airplane airplane) throws InvalidAttributeException {
        if (airplane != null) {
            List<Route> routesToUpdate = new ArrayList<>(airplane.getRoutes());
            for (Route r : routesToUpdate) {
                r.getAirplanes().remove(airplane);
                addRoute(r);
            }
            tx.begin();
            updateBoundings();
            airplaneManager.deleteAirplane(airplane); 
            //em.flush();
            tx.commit();
           
        }
    }

    public void deleteAirport(Airport airport) throws InvalidAttributeException {
        if (airport != null) {
            List<Route> destinationsToUpdate = new ArrayList<>(airport.getDestinations());
            for (Route r : destinationsToUpdate) {
                r.setDestination(null);
                addRoute(r);
            }
            List<Route> originsToUpdate = new ArrayList<>(airport.getOrigins());
            for (Route r : originsToUpdate) {
                r.setDestination(null);
                addRoute(r);
            }
            tx.begin();
            updateBoundings();
            airportManager.deleteAirport(airport);
            tx.commit();
        }
    }

    public void deleteRoute(Route route) throws InvalidAttributeException {
        if (route != null) {
            List<Airplane> airplanesToUpdate = new ArrayList<>(route.getAirplanes());
            for (Airplane a : airplanesToUpdate) {
                a.getRoutes().remove(route);
                addAirplane(a);
            }
            Airport destination = route.getDestination();
            Airport origin = route.getOrigin();
            destination.getDestinations().remove(route);
            origin.getOrigins().remove(route);
            addAirport(destination);
            addAirport(origin);
            tx.begin();
            routeManager.deleteRoute(route);
            updateBoundings();
            tx.commit();
        }
    }

    public void addAirplane(Airplane airplane) {
        if (!airplanes.contains(airplane)) {
            airplanes.add(airplane);
        }
    }

    public void addAirport(Airport airport) {
        if (!airports.contains(airport)) {
            airports.add(airport);
        }
    }

    public void addRoute(Route route) {
        if (!routes.contains(route)) {
            routes.add(route);
        }
    }

    public void clean() {
        airplanes = new ArrayList<>();
        routes = new ArrayList<>();
        airports = new ArrayList<>();
    }

}
