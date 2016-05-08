package Data;

/**
 * Created by M on 1. 5. 2016.
 * @param <T>
 */
public interface GenericDAO<T> {

    void deleteTx(T t);
    void delete(T t);

    T updateTx(T t);
    T update(T t);

    T createTx(T t);
    T create(T t);

}
