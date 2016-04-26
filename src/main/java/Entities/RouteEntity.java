package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by M on 23. 4. 2016.
 */
@Entity
@Table(name = "route", schema = "public", catalog = "student_db16_19")
public class RouteEntity {
    private int idRoute;

    @Id
    @Column(name = "id_route")
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

        RouteEntity that = (RouteEntity) o;

        if (idRoute != that.idRoute) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idRoute;
    }
}
