package Service;

import Model.Luggage;
import Validator.InvalidAttributeException;
import java.util.List;

/**
 *
 * @author Martin
 */
public interface LuggageManager {
    
    Luggage createLuggage(Luggage luggage) throws InvalidAttributeException;
    Luggage updateLuggage(Luggage luggage) throws InvalidAttributeException;
    void deleteLuggage(Luggage luggage) throws InvalidAttributeException;
    
    Luggage find(int idLuggage);
    
    List<Luggage> findAll();
}
