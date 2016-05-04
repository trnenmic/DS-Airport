package Service;

import Model.Airplane;
import Model.Route;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Martin
 */
public class AirplaneService extends GenericManagerImpl implements AirplaneManager {

    private final Root<Airplane> root;
    
    public AirplaneService() {
        this.root = criteriaQuery.from(Airplane.class);
        this.criteriaQuery = criteriaQuery.select(root);
    }

    
    @Override
    public Airplane find(int idAirplane) {
        return em.find(Airplane.class, idAirplane);
    }

    @Override
    public List<Airplane> findAll() {
        createResultList();
        return getCastedResult();
    }

    @Override
    public List<Airplane> findAllOrderedById() {
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("idAirplane")));
        createResultList();
        return getCastedResult();
    }

    public List<Airplane> findAllOrderedByCapacity() {
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("capacity")));
        createResultList();
        return getCastedResult();
    }
    
    public List<Airplane> findWithGreaterCapacity(int capacity) {
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
        return (List)airplane.getRoutes();
    }

    @Override
    public boolean eraseAirplaneRouteBound(int airplaneId, int routeId) {
        // TO DO
        return false;
    }
        

    @Override
    public List<Airplane> findSpecified(String code, String airline,
            Integer maxFuelCapacity, Integer minFuelCapacity, 
            Integer maxLoadingCapacity, Integer minLoadingCapacity) {
        
        criteriaQuery = criteriaQuery.select(root);
        if (code != null) {
            criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("code"), code));
        }
        if (airline != null) {
            criteriaQuery = criteriaQuery.where(criteriaBuilder.equal(root.get("airline"), airline));
        }
        if (maxFuelCapacity != null) {
            criteriaQuery = criteriaQuery.where(criteriaBuilder.lt(root.get("fuelTankCapacity"), maxFuelCapacity));
        }
        if (minFuelCapacity != null) {
            criteriaQuery = criteriaQuery.where(criteriaBuilder.gt(root.get("fuelTankCapacity"), minFuelCapacity));
        }
        if (maxLoadingCapacity != null) {
            criteriaQuery = criteriaQuery.where(criteriaBuilder.lt(root.get("loadingCapacity"), maxLoadingCapacity));
        }
        if (minLoadingCapacity != null) {
            criteriaQuery = criteriaQuery.where(criteriaBuilder.gt(root.get("loadingCapacity"), minLoadingCapacity));
        }
        if (code == null && airline == null && maxFuelCapacity == null && minFuelCapacity == null && maxLoadingCapacity == null && minLoadingCapacity == null) {
            return findAll();
        }
        createResultList();
        return getCastedResult();
    }


}
