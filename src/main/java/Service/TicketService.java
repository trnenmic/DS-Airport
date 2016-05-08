package Service;

import Data.GenericDAOImpl;
import Model.Ticket;
import Validator.InvalidAttributeException;
import java.util.List;
import javax.persistence.criteria.Root;

/**
 *
 * @author Martin Cap
 */
public class TicketService extends GenericServiceImpl<Ticket> implements TicketManager {
    
    private Root<Ticket> root;
    
    private final GenericDAOImpl<Ticket> ticketDAO = new GenericDAOImpl<>();

    public TicketService() {
        this.root = criteriaQuery.from(Ticket.class);
        this.criteriaQuery = criteriaQuery.select(root);
    }
    
    @Override
    public Ticket createTicket(Ticket ticket) throws InvalidAttributeException {
        // validation
        checkConstraints(ticket);
        return ticketDAO.createTx(ticket);
    }

    @Override
    public Ticket updateTicket(Ticket ticket) throws InvalidAttributeException {
        // validation
        checkConstraints(ticket);
        return ticketDAO.updateTx(ticket);
    }
    
    private void checkConstraints(Ticket ticket) throws InvalidAttributeException {
        // check existing_class constraint
        int tmp;
        if ((tmp = ticket.getTravelClass()) <= 0 || tmp >= 4) {
            throw new InvalidAttributeException("Incorrect travel class on the ticket! Must be from <1,3>.");
        }
        // check positive_price constraint
        if (ticket.getPrice() <= 0) {
            throw new InvalidAttributeException("The price of the ticket must be a positive number!");
        }
        // check positive_seat constraint
        if (ticket.getSeat() <= 0) {
            throw new InvalidAttributeException("The seat number must be a positive number!");
        }
    }
    
    
    @Override
    public void deleteTicket(Ticket ticket) throws InvalidAttributeException {
        ticketDAO.deleteTx(ticket);
    }
    
    @Override
    public Ticket find(int idTicket) {
        return em.find(Ticket.class, idTicket);
    }
    
    @Override
    public List<Ticket> findAll() {
        refresh();
        createResultList();
        return getCastedResult();
    }
    
    public void refresh() {
        criteriaQuery = criteriaBuilder.createQuery();
        root = criteriaQuery.from(Ticket.class);
    }
}
