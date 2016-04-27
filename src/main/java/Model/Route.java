package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by M on 27. 4. 2016.
 */
@Entity
public class Route {
    private int idRoute;

    @Id
    @Column(name = "id_route", nullable = false, insertable = true, updatable = true)
    public int getIdRoute() {
        return idRoute;
    }

    public void setIdRoute(int idRoute) {
        this.idRoute = idRoute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Route route = (Route) o;

        if (idRoute != route.idRoute) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idRoute;
    }
}
