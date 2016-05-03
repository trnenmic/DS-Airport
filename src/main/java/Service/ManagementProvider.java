/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

/**
 *
 * @author M
 */
public class ManagementProvider {
    
    private AirplaneManager airplaneManager;
    private AirportManager airportManager;
    private RouteManager routeManager;

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
