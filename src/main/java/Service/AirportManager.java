package Service;

import Model.Airport;
import Model.Route;

import java.util.List;

/**
 * Created by M on 1. 5. 2016.
 */
public interface AirportManager {

    List<Airport> findAll();
    List<Airport> findAllOrderedById();

    boolean eraseAirportRouteBound(int airportId, int routeId);

    List<Route> findJoinedOriginRoutes(Airport airport);
    List<Route> findJoinedDestinationRoutes(Airport airport);
}
