package Model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Collection;

/**
 * Created by M on 27. 4. 2016.
 */
@Entity
public class Route implements Serializable {
    private int idRoute;


    private Collection<Airplane> airplanes;

    private Airport origin;
    private Airport destination;


    public static Route createRoute() {
        Route route = new Route();
        return route;
    }

    @Override
    public String toString() {
        return String.valueOf("[ " + Route.class + " : " + getIdRoute() + " ; Airport origin: " + getOrigin().getAirportName()
                + " ; Airport destination: " + getDestination().getAirportName() + " ]");
    }

    @Id
    @GeneratedValue
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

    @ManyToOne
    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    @ManyToOne
    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }


    @ManyToMany
    //@JoinTable(name = "airplane_has_route")
    public Collection<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(Collection<Airplane> airplanes) {
        this.airplanes = airplanes;
    }


}
