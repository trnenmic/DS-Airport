package Service;

import Data.GenericDAOImpl;
import Model.Client;
import Validator.InvalidAttributeException;
import java.util.List;
import javax.persistence.criteria.Root;

/**
 *
 * @author Martin Cap
 */
public class ClientService extends GenericServiceImpl<Client> implements ClientManager {
    
    private Root<Client> root;

    private final GenericDAOImpl<Client> clientDAO = new GenericDAOImpl<>();

    @Override
    public Client createClient(Client client) throws InvalidAttributeException {
        // validation
        checkConstraints(client);
        return clientDAO.createTx(client);
    }

    @Override
    public Client updateClient(Client client) throws InvalidAttributeException {
        // validation
        checkConstraints(client);
        return clientDAO.updateTx(client);
    }
    
    private void checkConstraints(Client client) throws InvalidAttributeException {
        List<Client> allClients = findAll();
        // check unique_passport_number_client
        String tmpPassportNumber = client.getPassportNumber();
        for (Client c : allClients) {
            if (tmpPassportNumber.equals(c.getPassportNumber())) {
                throw new InvalidAttributeException("Passport number of the client must be unique!");
            }
        }
    }

    @Override
    public void deleteClient(Client client) throws InvalidAttributeException {
        
        clientDAO.deleteTx(client);
    }

    @Override
    public Client find(int idClient) {
        return em.find(Client.class, idClient);
    }

    @Override
    public List<Client> findAll() {
        refresh();
        createResultList();
        return getCastedResult();
    }
    
    public void refresh() {
        criteriaQuery = criteriaBuilder.createQuery();
        root = criteriaQuery.from(Client.class);
    }

}
