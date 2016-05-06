package Service;

import Validator.*;

/**
 *
 * @author M
 */
public class ManagementProvider {
    
    private AirplaneManager airplaneManager;
    private AirportManager airportManager;
    private RouteManager routeManager;
    
    private AirplaneValidator airplaneValidator;
    private AirportValidator airportValidator;
    private RouteValidator routeValidator;
    
    private GenericManagerImpl genericManagerImpl;    

    public GenericManagerImpl getGenericManagerImpl() {
        return genericManagerImpl;
    }

    public void setGenericManagerImpl(GenericManagerImpl genericManagerImpl) {
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

    public AirplaneValidator getAirplaneValidator() {
        return airplaneValidator;
    }

    public void setAirplaneValidator(AirplaneValidator airplaneValidator) {
        this.airplaneValidator = airplaneValidator;
    }

    public AirportValidator getAirportValidator() {
        return airportValidator;
    }

    public void setAirportValidator(AirportValidator airportValidator) {
        this.airportValidator = airportValidator;
    }

    public RouteValidator getRouteValidator() {
        return routeValidator;
    }

    public void setRouteValidator(RouteValidator routeValidator) {
        this.routeValidator = routeValidator;
    }
    
    
}
