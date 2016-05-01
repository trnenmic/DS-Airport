package Service;

import Model.Airplane;
import Model.Route;
import java.util.List;
import javax.persistence.criteria.Root;

/**
 *
 * @author Martin
 */
public class AirplaneService extends GenericManagerImpl implements AirplaneManager {

    private final Root<Airplane> from;
    
    public AirplaneService() {
        this.from = criteriaQuery.from(Airplane.class);
        this.select = criteriaQuery.select(from);
    }

    public Airplane find(int idAirplane) {
        return em.find(Airplane.class, idAirplane);
    }

    @Override
    public List<Airplane> findAll() {
        update();
        resultList = typedQuery.getResultList();
        return getCastedResult();
    }

    @Override
    public List<Airplane> findAllOrderedById() {
        select.orderBy(criteriaBuilder.asc(from.get("idAirplane")));
        update();
        resultList = typedQuery.getResultList();
        return getCastedResult();
    }

    public List<Airplane> findAllOrderedByCapacity() {
        select.orderBy(criteriaBuilder.asc(from.get("capacity")));
        update();
        resultList = typedQuery.getResultList();
        return getCastedResult();
    }

    @Override
    public List<Route> findJoinedRoutes(Airplane airplane) {
        // TO DO
        return null;
    }

    @Override
    public boolean eraseAirplaneRouteBound(int airplaneId, int routeId) {
        // TO DO
        return false;
    }

    @Override
    public List<Airplane> findSpecified(Integer capacity, Integer fuelTankCapacity, String airline, Integer payload, Integer loadingCapacity, String airplaneCode) {
        // TO DO
        return null;
    }
    
    
}
