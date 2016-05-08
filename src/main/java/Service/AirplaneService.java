package Service;

import Data.GenericDAOImpl;
import Model.Airplane;
import Model.Route;
import Validator.InvalidAttributeException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.*;

/**
 *
 * @author Martin Cap
 */
public class AirplaneService extends GenericServiceImpl<Airplane> implements AirplaneManager {

    private Root<Airplane> root;

    private final GenericDAOImpl<Airplane> airplaneDAO = new GenericDAOImpl<>();

    public AirplaneService() {
        this.root = criteriaQuery.from(Airplane.class);
        this.criteriaQuery = criteriaQuery.select(root);
    }

    @Override
    public Airplane createAirplane(Airplane airplane) throws InvalidAttributeException {
        // validation
        checkConstraints(airplane);
        return airplaneDAO.createTx(airplane);
    }

    @Override
    public Airplane createAirplane(Airplane airplane, String airplanePassengerCapacity,
            String maximumRange, String airline, String maximumCargo,
            String maximumTakeoffWeight, String airplaneCode) throws InvalidAttributeException {
        setAttributes(airplane, airplanePassengerCapacity, maximumRange, airline, maximumCargo, maximumTakeoffWeight, airplaneCode);
        return createAirplane(airplane);
    }

    @Override
    public Airplane updateAirplane(Airplane airplane) throws InvalidAttributeException {
        // validation
        checkConstraints(airplane);
        return airplaneDAO.updateTx(airplane);
    }

    @Override
    public Airplane updateAirplane(Airplane airplane, String airplanePassengerCapacity,
            String maximumRange, String airline, String maximumCargo,
            String maximumTakeoffWeight, String airplaneCode) throws InvalidAttributeException {
        setAttributes(airplane, airplanePassengerCapacity, maximumRange, airline, maximumCargo, maximumTakeoffWeight, airplaneCode);
        return updateAirplane(airplane);
    }

    private void checkConstraints(Airplane airplane) throws InvalidAttributeException {
        List<Airplane> allAirplanes = findAll();
        allAirplanes.remove(airplane);
        // check UNIQUE constraints
        String tmpCode = airplane.getAirplaneCode();
        for (Airplane a : allAirplanes) {
            if (tmpCode.equals(a.getAirplaneCode()) && a.getIdAirplane() != airplane.getIdAirplane()) {
                throw new InvalidAttributeException("Airplane with the same code is already in the database!");
            }
        }
        // check correct_airplane_code constraint
        if (airplane.getAirplaneCode().length() <= 2) {
            throw new InvalidAttributeException("Airplane code must be at least 3 characters long!");
        }
        // check positive_maximum_cargo_capacity constraint
        if (airplane.getMaximumCargoCapacity() <= 0) {
            throw new InvalidAttributeException("Maximum cargo capacity of the airplane must be greater than 0!");
        }
        // check positive_maximum_range constraint
        if (airplane.getMaximumRange() <= 0) {
            throw new InvalidAttributeException("Maximum range of the airplane must be greater than 0!");
        }
        // check positive_maximum_takeoff_weight
        if (airplane.getMaximumTakeoffWeight() <= 0) {
            throw new InvalidAttributeException("Maximum takeoff weight of the airplane must be greater than 0!");
        }
        // check positive_passenger_capacity
        if (airplane.getPassengerCapacity() < 0) {
            throw new InvalidAttributeException("Passenger capacity of the airplane must be a positive number!");
        }

    }

    @Override
    public void deleteAirplane(Airplane airplane) throws InvalidAttributeException {

        // validation
        //airplaneDAO.delete(airplane);
        //Airplane airplaneToRemove = em.getReference(Airplane.class, airplane.getIdAirplane());
        Airplane airplaneToRemove = em.find(Airplane.class, airplane.getIdAirplane());
        em.remove(airplaneToRemove);
    }

    @Override
    public Airplane find(int idAirplane) {
        return em.find(Airplane.class, idAirplane);
    }

    @Override
    public List<Airplane> findAll() {
        refresh();
        createResultList();
        return getCastedResult();
    }

    @Override
    public List<Airplane> findAllOrdered() {
        refresh();
        List<Order> orders = new ArrayList<>(4);

        orders.add(criteriaBuilder.asc(root.get("code")));
        orders.add(criteriaBuilder.asc(root.get("airline")));
        orders.add(criteriaBuilder.asc(root.get("passengerCapacity")));
        orders.add(criteriaBuilder.asc(root.get("maximumRange")));
        criteriaQuery.orderBy(orders.toArray(new Order[orders.size()]));

        createResultList();
        return getCastedResult();
    }

    @Override
    public List<Airplane> findAllOrderedById() {
        refresh();
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("idAirplane")));
        createResultList();
        return getCastedResult();
    }

    public List<Airplane> findAllOrderedByCapacity() {
        refresh();
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("capacity")));
        createResultList();
        return getCastedResult();
    }

    public List<Airplane> findWithGreaterCapacity(int capacity) {
        refresh();
        CriteriaQuery tmp = criteriaQuery.select(root)
                .where(criteriaBuilder.gt(root.get("capacity"), capacity));
//        if (neco != null) {
//            tmp.select(root).where(criteriaBuilder.equal(root.get("neco"), necodalsiho));
//        }
        createResultList();
        return getCastedResult();
    }

    // REDUNDANT ???
    @Override
    public List<Route> findRoutes(Airplane airplane) {
        return (List) airplane.getRoutes();
    }

    @Override
    public boolean eraseAirplaneRouteBound(int airplaneId, int routeId) {
        // TO DO
        return false;
    }

    @Override
    public List<Airplane> findSpecified(String airplaneCode, String airline,
            Integer maxPassengerCapacity, Integer minPassengerCapacity,
            Integer maxMaximumRange, Integer minMaximumRange) {

        refresh();
        List<Predicate> predicates = new ArrayList<>(6);
        List<Order> orders = new ArrayList<>(4);

        orders.add(criteriaBuilder.asc(root.get("airplaneCode")));
        orders.add(criteriaBuilder.asc(root.get("airline")));
        orders.add(criteriaBuilder.asc(root.get("passengerCapacity")));
        orders.add(criteriaBuilder.asc(root.get("maximumRange")));

        if (airplaneCode != null) {
            predicates.add(criteriaBuilder.equal(root.get("airplaneCode"), airplaneCode));
        }
        if (airline != null) {
            predicates.add(criteriaBuilder.equal(root.get("airline"), airline));
        }
        if (maxPassengerCapacity != null) {
            predicates.add(criteriaBuilder.gt(root.get("passengerCapacity"), maxPassengerCapacity));
        }
        if (minPassengerCapacity != null) {
            predicates.add(criteriaBuilder.lt(root.get("passengerCapacity"), minPassengerCapacity));
        }
        if (maxMaximumRange != null) {
            predicates.add(criteriaBuilder.gt(root.get("maximumRange"), maxMaximumRange));
        }
        if (minMaximumRange != null) {
            predicates.add(criteriaBuilder.lt(root.get("maximumRange"), minMaximumRange));
        }
        if (!predicates.isEmpty()) {
            criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        }
        criteriaQuery.orderBy(orders.toArray(new Order[orders.size()]));
        createResultList();
        return getCastedResult();
    }

    public void refresh() {
        em.clear();
        root = criteriaQuery.from(Airplane.class);
        criteriaQuery = criteriaQuery.select(root);
    }

    private void setAttributes(Airplane airplane, String airplanePassengerCapacity,
            String maximumRange, String airline, String maximumCargo,
            String maximumTakeoffWeight, String airplaneCode) throws InvalidAttributeException {
        try {
            airplane.setPassengerCapacity(Integer.parseInt(airplanePassengerCapacity));
            airplane.setMaximumRange(Integer.parseInt(maximumRange));
            airplane.setAirline(airline);
            airplane.setMaximumCargoCapacity(Integer.parseInt(maximumCargo));
            airplane.setMaximumTakeoffWeight(Integer.parseInt(maximumTakeoffWeight));
            airplane.setAirplaneCode(airplaneCode);
        } catch (NumberFormatException e) {
            throw new InvalidAttributeException("Fields passenger capacity, maximum range, cargo capacity and takeoffweight must be integers.");
        }
    }

    @Override
    public void updateAirplanes(List<Airplane> airplanes) {
        for (Airplane a : airplanes) {
            airplaneDAO.update(a);
        }
    }
}
