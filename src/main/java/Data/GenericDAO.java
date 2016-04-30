package Data;

/**
 *
 * @author Martin
 * @param <T>
 */
public interface GenericDAO<T> {
    
    T create(T t);
    T update(T t);
    void delete(T t);
    
    
}
