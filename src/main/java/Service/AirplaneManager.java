package Service;

import Model.Airplane;
import Model.Route;

import java.util.List;

/**
 * Created by M on 1. 5. 2016.
 */
public interface AirplaneManager extends GenericManager {

    List<Route> findJoinedRoutes(Airplane airplane);

    List<Airplane> findAllAirplanes();

    boolean eraseAirplaneRouteBound(int airplaneId, int routeId);

    /*If some parameter is null, parameter wont be used in select*/

    List<Airplane> findAirplanesSpecified(Integer capacity, Integer fuelTankCapacity, String airline,
                              Integer payload, Integer loadingCapacity, String airplaneCode);

}
