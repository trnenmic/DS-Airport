package Service;

import Model.Airplane;
import Model.Airport;
import Model.Route;
import Validator.InvalidAttributeException;

/**
 *
 * @author M
 */
public interface ValidatorInterface {
    
    void validateAirplane(Airplane airplane) throws InvalidAttributeException;
    
    void validateAirport(Airport airport) throws InvalidAttributeException;
    
    void validateRoute(Route route) throws InvalidAttributeException;
    
}
