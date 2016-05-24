package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;

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
        route.setOrigin(null);
        route.setDestination(null);
        route.setAirplanes(new ArrayList<>());
        return route;
    }
    
    public static Route createRoute(Airport origin, Airport destination) {
        Route route = new Route();
        route.setOrigin(origin);
        route.setDestination(destination);
        route.setAirplanes(new ArrayList<>());
        return route;
    }
    
    public static Route createRoute(Airport origin, Airport destination, Airplane... airplanes) {
        Route route = new Route();
        route.setOrigin(origin);
        route.setDestination(destination);
        List<Airplane> airplanesToAdd = new ArrayList<>();
        airplanesToAdd.addAll(Arrays.asList(airplanes));
        route.setAirplanes(airplanesToAdd);
        return route;
    }

    @Override
    public String toString() {
        return String.valueOf("| ROUTE | ORIGIN : " + getOrigin().getAirportName() 
                + " , "+ getOrigin().getCity() + " , " + getOrigin().getCountry() 
                + " , "+ getOrigin().getIcao() + " , " + getOrigin().getIata() 
                + " | DESTINATION : " + getDestination().getAirportName() + " , " 
                + getDestination().getCity() + " , " + getDestination().getCountry()
                + " , " + getDestination().getIcao() + " , " + getDestination().getIata()
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
    @JoinColumn(name = "origin_id_airport")
    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    @ManyToOne
    @JoinColumn(name = "destination_id_airport")
    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }


    @ManyToMany
    public Collection<Airplane> getAirplanes() {
        return airplanes;
    }

    public void setAirplanes(Collection<Airplane> airplanes) {
        this.airplanes = airplanes;
    }


}
