package Service;

import Model.Client;
import Validator.InvalidAttributeException;
import java.util.List;

/**
 *
 * @author Martin
 */
public interface ClientManager {

    Client createClient(Client client) throws InvalidAttributeException;
    Client updateClient(Client client) throws InvalidAttributeException;
    void deleteClient(Client client) throws InvalidAttributeException;

    Client find(int idClient);
    
    List<Client> findAll();
    
}
