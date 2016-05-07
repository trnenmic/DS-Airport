package Service;

import Model.Airport;
import Model.Route;
import Validator.InvalidAttributeException;

import java.util.List;

/**
 * Created by M on 1. 5. 2016.
 */
public interface AirportManager {
    
    Airport createAirport(Airport airport) throws InvalidAttributeException;
    Airport updateAirport(Airport airport) throws InvalidAttributeException;
    void deleteAirport(Airport airport) throws InvalidAttributeException;

    Airport find(int idAirport);
    
    List<Airport> findAllOrdered();
    
    List<Airport> findAll();
    List<Airport> findAllOrderedById();

    boolean eraseAirportRouteBound(int airportId, int routeId);

    List<Route> findJoinedOriginRoutes(Airport airport);
    List<Route> findJoinedDestinationRoutes(Airport airport);
    
    List<Airport> findSpecified(String name, String city, String country, String icao, String iata);
    List<Airport> findSpecifiedAlternate(String name, String city, String country, String icao, String iata);
}
