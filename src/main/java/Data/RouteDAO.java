package Data;

import Model.Route;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Martin
 */
public class RouteDAO extends GenericDAOImpl<Route> {
    
    private final Root<Route> from = criteriaQuery.from(Route.class);
    private final CriteriaQuery<Object> select = criteriaQuery.select(from);
    private TypedQuery<Object> typedQuery;
    private List<Object> resultList;

    public Route find(int idRoute) {
        return em.find(Route.class, idRoute);
    }
    
    public List<Route> findAll() {
        update();
        resultList = typedQuery.getResultList();
        List<Route> result = new ArrayList<>();
        cast(result);
        return result;
    }
    
    public List<Route> findAllOrderedByID() {
        select.orderBy(criteriaBuilder.asc(from.get("idRoute")));
        update();
        resultList = typedQuery.getResultList();
        List<Route> result = new ArrayList<>();
        cast(result);
        return result;
    }
    
    private void update() {
        typedQuery = em.createQuery(select);
    }
    
    private void cast(List<Route> result) {
        for (Object o : resultList) {
            result.add((Route)o);
        }
    }
}
