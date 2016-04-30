package Data;

import Model.Airplane;

/**
 *
 * @author Martin
 */
public class AirplaneDAO extends GenericDAOImpl<Airplane> {
    
    public Airplane find(int idAirplane) {
        return em.find(Airplane.class, idAirplane);
    }
    
}
