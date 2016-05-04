package Data;

import Model.Identifiable;

/**
 *
 * @author Martin
 * @param <T>
 */
public interface GenericDAO {
    
    Identifiable create(Identifiable t);
    Identifiable update(Identifiable t);
    void delete(Identifiable t);
    Object refresh(Object t);
    
    
}
