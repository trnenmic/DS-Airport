package Service;

import Model.Airplane;
import Model.Route;
import Validator.InvalidAttributeException;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by M on 1. 5. 2016.
 */
public interface AirplaneManager {

    Airplane createAirplane(Airplane airplane) throws InvalidAttributeException;

    Airplane createAirplane(Airplane airplane, String airplanePassengerCapacity,
            String maximumRange, String airline, String maximumCargo,
            String maximumTakeoffWeight, String airplaneCode) throws InvalidAttributeException;

    Airplane updateAirplane(Airplane airplane) throws InvalidAttributeException;

    Airplane updateAirplane(Airplane airplane, String airplanePassengerCapacity,
            String maximumRange, String airline, String maximumCargo,
            String maximumTakeoffWeight, String airplaneCode) throws InvalidAttributeException;

    void updateAirplanes(List<Airplane> airplanes);

    void deleteAirplane(Airplane airplane) throws InvalidAttributeException;

    List<Route> findRoutes(Airplane airplane);

    Airplane find(int idAirplane);

    List<Airplane> findAll();

    List<Airplane> findAllOrdered();

    List<Airplane> findAllOrderedById();

    boolean eraseAirplaneRouteBound(int airplaneId, int routeId);

    /*If some parameter is null, parameter wont be used in select*/
    List<Airplane> findSpecified(String filterCode, String filterAirline,
            Integer filterMaxFuelCapacity, Integer filterMinFuelCapacity,
            Integer filterMaxLoadingCapacity, Integer filterMinLoadingCapacity);

}
