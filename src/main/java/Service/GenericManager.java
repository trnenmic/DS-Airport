package Service;

import java.util.List;

/**
 * Created by M on 1. 5. 2016.
 * @param <T>
 */
public interface GenericManager<T> {

//    T findById(int id);

//    boolean delete(int id);
    void delete(T t);

//    List<T> findAllOrdered();

    T update(T t);

    T create(T t);
    
    void refresh();

}
