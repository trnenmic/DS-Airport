package Service;

import Data.GenericDAOImpl;
import Model.Airplane;
import Model.Route;
import Validator.InvalidAttributeException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
        
        return airplaneDAO.create(airplane);
    }

    @Override
    public Airplane updateAirplane(Airplane airplane) throws InvalidAttributeException {
        
        // validation
        
        return airplaneDAO.update(airplane);
    }

    @Override
    public void deleteAirplane(Airplane airplane) throws InvalidAttributeException {
        
        // validation
        
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
        return (List)airplane.getRoutes();
    }

    @Override
    public boolean eraseAirplaneRouteBound(int airplaneId, int routeId) {
        // TO DO
        return false;
    }
        
    @Override
    public List<Airplane> findSpecified(String code, String airline,
            Integer maxPassengerCapacity, Integer minPassengerCapacity, 
            Integer maxMaximumRange, Integer minMaximumRange) {
        
        refresh();
        List<Predicate> predicates = new ArrayList<>(6);
        if (code != null) {
            predicates.add(criteriaBuilder.equal(root.get("code"), code));
        }
        if (airline != null) {
            predicates.add(criteriaBuilder.equal(root.get("airline"), airline));
        }
        if (maxPassengerCapacity != null) {
            predicates.add(criteriaBuilder.lt(root.get("passengerCapacity"), maxPassengerCapacity));
        }
        if (minPassengerCapacity != null) {
            predicates.add(criteriaBuilder.gt(root.get("passengerCapacity"), minPassengerCapacity));
        }
        if (maxMaximumRange != null) {
            predicates.add(criteriaBuilder.lt(root.get("maximumRange"), maxMaximumRange));
        }
        if (minMaximumRange != null) {
            predicates.add(criteriaBuilder.gt(root.get("maximumRange"), minMaximumRange));
        }
        if (!predicates.isEmpty()) {
            criteriaQuery.where(predicates.toArray(new Predicate[predicates.size()]));
        }
        createResultList();
        return getCastedResult();
    }

    public void refresh() {
        root = criteriaQuery.from(Airplane.class);
        criteriaQuery = criteriaQuery.select(root);
    }
    
}
