package ClientDemo;

import Model.Airplane;
import Model.Airport;
import Model.Route;
import Service.AirplaneManager;
import Service.AirplaneService;
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
    AirplaneManager airplaneService = new AirplaneService();
    RouteManager routeService = new RouteService();

    public void addRoutes(int n) {

        List<Airport> allAirports = airportService.findAllOrderedById();
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
    
    public void addAirplanesToRoutes(List<Route> routes) {
        List<Airplane> allAirplanes = airplaneService.findAllOrderedById();
        for (Route r : routes) {
            r.addAirplane(allAirplanes.get(random.nextInt(allAirplanes.size())));
            try {
                routeService.updateRoute(r);
            } catch (InvalidAttributeException ex) {
                Logger.getLogger(RouteAdder.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }

}
