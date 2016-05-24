package ClientDemo;

import Model.Airport;
import Model.Route;
import Service.AirportManager;
import Service.AirportService;
import Service.RouteManager;
import Service.RouteService;
import Validator.InvalidAttributeException;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Martin Cap
 */
public class RouteAdder {

    Random random = new Random();
    AirportManager airportService = new AirportService();
    RouteManager routeService = new RouteService();

    public void addRoutes(int n) {

        List<Airport> allAirports = airportService.findAllOrdered();
        Airport origin;
        Airport destination;
        for (int i = 0; i < n; i++) {
            try {
                origin = allAirports.get(random.nextInt(allAirports.size()));
                destination = allAirports.get(random.nextInt(allAirports.size()));
                routeService.createRoute(Route.createRoute(origin, destination));
            } catch (InvalidAttributeException ex) {
                Logger.getLogger(RouteAdder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
