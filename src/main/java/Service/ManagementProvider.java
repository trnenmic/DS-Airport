/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Data.GenericDAOImpl;
import Validator.InvalidAttributeException;

/**
 *
 * @author M
 */
public class ManagementProvider implements ValidatorInterface {
    
    private AirplaneManager airplaneManager;
    private AirportManager airportManager;
    private RouteManager routeManager;
    
    private GenericDAOImpl genericDAOImpl;    

    public GenericDAOImpl getGenericDAOImpl() {
        return genericDAOImpl;
    }

    public void setGenericDAOImpl(GenericDAOImpl genericDAOImpl) {
        this.genericDAOImpl = genericDAOImpl;
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
    
 

    @Override
    public void validateAirport() throws InvalidAttributeException {
        //TO DO
    }

    @Override
    public void validateRoute() throws InvalidAttributeException {
        //TO DO
    }

    @Override
    public void validateAirplane() throws InvalidAttributeException {
        //TO DO
    }
    
    
    
}
