package Model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;
import java.util.Collection;

/**
 * Created by M on 27. 4. 2016.
 */
@Entity
public class Route implements Serializable, Identifiable {
    private int idRoute;


    private Collection<Airplane> airplanes;

    private Airport origin;
    private Airport destination;


    public static Route createRoute() {
        Route route = new Route();
        route.setOrigin(null);
        route.setDestination(null);
        route.setAirplanes(new ArrayList<Airplane>());
        return route;
    }

    @Override
    public String toString() {
        return String.valueOf("| ROUTE | ORIGIN : " + getOrigin().getAirportName() 
                + " , "+ getOrigin().getCity() + " , " + getOrigin().getCountry() 
                + " , "+ getOrigin().getIcao() + " , " + getOrigin().getIata() 
                + " | DESTINATION : " + getDestination().getAirportName() + " , " 
                + getDestination().getCity() + " , " + getDestination().getCountry()
                + " , " + getOrigin().getIcao() + " , " + getOrigin().getIata()
                + " |");
    }
    
    public void addAirplane(Airplane airplane){
        if(!airplanes.contains(airplane)){
            airplanes.add(airplane);
        }
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

    @Override
    public int getId() {
        return idRoute;
    }


}
