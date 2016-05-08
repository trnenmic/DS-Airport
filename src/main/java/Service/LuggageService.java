package Service;

import Data.GenericDAOImpl;
import Model.Luggage;
import Validator.InvalidAttributeException;
import java.util.List;
import javax.persistence.criteria.Root;

/**
 *
 * @author Martin Cap
 */
public class LuggageService extends GenericServiceImpl<Luggage> implements LuggageManager {
    
    private Root<Luggage> root;
    
    private final GenericDAOImpl<Luggage> luggageDAO = new GenericDAOImpl<>();

    public LuggageService() {
        this.root = criteriaQuery.from(Luggage.class);
        this.criteriaQuery = criteriaQuery.select(root);
    }
    
    @Override
    public Luggage createLuggage(Luggage luggage) throws InvalidAttributeException {
        // validation
        checkConstraints(luggage);
        return luggageDAO.createTx(luggage);
    }

    @Override
    public Luggage updateLuggage(Luggage luggage) throws InvalidAttributeException {
        // validation
        checkConstraints(luggage);
        return luggageDAO.updateTx(luggage);
    }
    
    private void checkConstraints(Luggage luggage) throws InvalidAttributeException {
        // check luggage_type constraint
        if (luggage.getLuggageType() <= 0) {
            throw new InvalidAttributeException("Luggage type must be a positive number!");
        }
        // check positive_weight constraint
        if (luggage.getWeight() <= 0) {
            throw new InvalidAttributeException("Weight of the luggage must be a positive number!");
        }
    }
    
    
    @Override
    public void deleteLuggage(Luggage luggage) throws InvalidAttributeException {
        luggageDAO.delete(luggage);
    }
    
    @Override
    public Luggage find(int idLuggage) {
        return em.find(Luggage.class, idLuggage);
    }
    
    @Override
    public List<Luggage> findAll() {
        refresh();
        createResultList();
        return getCastedResult();
    }
    
    public void refresh() {
        criteriaQuery = criteriaBuilder.createQuery();
        root = criteriaQuery.from(Luggage.class);
    }
}
