package Service;

import Model.Ticket;
import Validator.InvalidAttributeException;
import java.util.List;

/**
 *
 * @author Martin
 */
public interface TicketManager {

    Ticket createTicket(Ticket ticket) throws InvalidAttributeException;
    Ticket updateTicket(Ticket ticket) throws InvalidAttributeException;
    void deleteTicket(Ticket ticket) throws InvalidAttributeException;

    Ticket find(int idTicket);

    List<Ticket> findAll();
}
