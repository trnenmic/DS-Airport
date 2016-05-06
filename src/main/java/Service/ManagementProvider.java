package Service;

import Data.GenericDAOImpl;

/**
 *
 * @author M
 */
public class ManagementProvider {
    
    private AirplaneManager airplaneManager = new AirplaneService();
    private AirportManager airportManager = new AirportService();
    private RouteManager routeManager = new RouteService();
    
    private GenericDAOImpl genericManagerImpl = new GenericDAOImpl();

    public GenericDAOImpl getGenericManagerImpl() {
        return genericManagerImpl;
    }

    public void setGenericManagerImpl(GenericDAOImpl genericManagerImpl) {
        this.genericManagerImpl = genericManagerImpl;
    }

    public AirplaneManager getAirplaneManager() {
        return airplaneManager;
    }

    public void setAirplaneManager(AirplaneManager airplaneManager) {
        this.airplaneManager = airplaneManager;
    }

    public AirportManager getAirportManager() {
        return airportManager;
    }

    public void setAirportManager(AirportManager airportManager) {
        this.airportManager = airportManager;
    }

    public RouteManager getRouteManager() {
        return routeManager;
    }

    public void setRouteManager(RouteManager routeManager) {
        this.routeManager = routeManager;
    }
    
}
