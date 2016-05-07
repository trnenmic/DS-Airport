package Service;

import Model.Flight;
import Validator.InvalidAttributeException;
import java.util.List;

/**
 *
 * @author Martin
 */
public interface FlightManager {
    
    Flight createFlight(Flight flight) throws InvalidAttributeException;
    Flight updateFlight(Flight flight) throws InvalidAttributeException;
    void deleteFlight(Flight flight) throws InvalidAttributeException;
    
    Flight find(int idFlight);
    
    List<Flight> findAll();
}
