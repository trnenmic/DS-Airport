package Service;

import Data.AirplaneDAO;
import Model.Airplane;

/**
 *
 * @author Martin
 */
public class AirplaneService {

    private AirplaneDAO airplaneDAO = new AirplaneDAO();
    
    // trosku zbytecne, budto DAO, nebo services
    public void addAirplane(Airplane airplane) {
        airplaneDAO.create(airplane);
    }
    
    
    
    
}
