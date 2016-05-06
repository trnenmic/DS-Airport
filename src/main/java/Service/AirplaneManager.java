package Service;

import Model.Airplane;
import Model.Route;
import Validator.InvalidAttributeException;

import java.util.List;

/**
 * Created by M on 1. 5. 2016.
 */
public interface AirplaneManager {
    
    Airplane createAirplane(Airplane airplane) throws InvalidAttributeException;
    Airplane updateAirplane(Airplane airplane) throws InvalidAttributeException;
    void deleteAirplane(Airplane airplane) throws InvalidAttributeException;

    List<Route> findRoutes(Airplane airplane);
    
    Airplane find(int idAirplane);
    List<Airplane> findAll();
    List<Airplane> findAllOrderedById();

    boolean eraseAirplaneRouteBound(int airplaneId, int routeId);

    /*If some parameter is null, parameter wont be used in select*/
    
    List<Airplane> findSpecified(String filterCode, String filterAirline, 
            Integer filterMaxFuelCapacity, Integer filterMinFuelCapacity, 
            Integer filterMaxLoadingCapacity, Integer filterMinLoadingCapacity);

}
