package Service;

import Model.Airplane;
import Model.Airport;
import Model.Route;

import java.util.List;

/**
 * Created by M on 1. 5. 2016.
 */
public interface RouteManager {

    List<Airplane> findJoinedAirplanes(Route route);

    Route find(int idRoute);
    List<Route> findAll();
    List<Route> findAllOrderedById();

    boolean eraseRouteAirplaneBound(int routeId, int airplaneId);

    /* We have to solve case, when origin=destination, may cause troubles later */
    boolean eraseRouteAirportBound(int routeId, int airportId);

    Airport findOrigin(Route route);
    Airport findDestination(Route route);

    /*If some parameter is null, parameter wont be used in select*/

    List<Route> findSpecified(String city1, String city2, String airportName1, String airportName2, String icao1,
                              String icao2, String iata1, String iata2, String country1, String country2);
}
