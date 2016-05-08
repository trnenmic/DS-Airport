package Service;

import Data.GenericDAOImpl;
import Model.Flight;
import Validator.InvalidAttributeException;
import java.util.List;
import javax.persistence.criteria.Root;

/**
 *
 * @author Martin Cap
 */
public class FlightService extends GenericServiceImpl<Flight> implements FlightManager {
    
    private Root<Flight> root;
    
    private final GenericDAOImpl<Flight> flightDAO = new GenericDAOImpl<>();

    public FlightService() {
        this.root = criteriaQuery.from(Flight.class);
        this.criteriaQuery = criteriaQuery.select(root);
    }
    
    @Override
    public Flight createFlight(Flight flight) throws InvalidAttributeException {
        // validation
        checkConstraints(flight);
        return flightDAO.createTx(flight);
    }

    @Override
    public Flight updateFlight(Flight flight) throws InvalidAttributeException {
        // validation
        checkConstraints(flight);
        return flightDAO.updateTx(flight);
    }
    
    private void checkConstraints(Flight flight) throws InvalidAttributeException {
        // check correct_date_order constraint
        if (flight.getArrivalDate().before(flight.getDepartureDate())) {
            throw new InvalidAttributeException("Plane cannot arrive before it departure on a single flight!");
        }
        // check positive_num_booked_seats constraint
        if (flight.getNumBookedSeats() <= 0) {
            throw new InvalidAttributeException("Number of booked seats on a singe flight must be a positive number!");
        }
    }
    
    
    @Override
    public void deleteFlight(Flight flight) throws InvalidAttributeException {
        flightDAO.delete(flight);
    }
    
    @Override
    public Flight find(int idFlight) {
        return em.find(Flight.class, idFlight);
    }
    
    @Override
    public List<Flight> findAll() {
        refresh();
        createResultList();
        return getCastedResult();
    }
    
    public List<Flight> findAllOrderedByID() {
        refresh();
        criteriaQuery.orderBy(criteriaBuilder.asc(root.get("idFlight")));
        createResultList();
        return getCastedResult();
    }
    
    public void refresh() {
        criteriaQuery = criteriaBuilder.createQuery();
        root = criteriaQuery.from(Flight.class);
    }
    
}
