package Service;

import java.util.List;

/**
 * Created by M on 1. 5. 2016.
 */
public interface GenericManager<T> {

    T findById(int id);

    boolean delete(int id);

    List<T> findAllOrdered();

    T update(T t);

    T create(T t);

}
