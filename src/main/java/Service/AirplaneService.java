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

    @Override
    public List<Route> findRoutes(Airplane airplane) {
        // TO DO
        return null;
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
        
        return findAll();
    }


}
