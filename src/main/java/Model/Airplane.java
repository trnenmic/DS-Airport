package Model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;
import java.util.Collection;

/**
 * Created by M on 27. 4. 2016.
 */
@Entity
public class Airplane implements Serializable {

    private int idAirplane;
    private int passengerCapacity;
    private int maximumRange;
    private String airline;
    private Integer maximumCargoCapacity;
    private Integer maximumTakeoffWeight;
    private String airplaneCode;
    private Collection<Route> routes;
    private Collection<Flight> flights;

    public static Airplane createAirplane(String airplaneCode, String airline, int passengerCapacity, int maximumRange,
            Integer maximumCargoCapacity, Integer maximumTakeoffWeight) {
        Airplane airplane = new Airplane();
        airplane.setAirplaneCode(airplaneCode);
        airplane.setAirline(airline);
        airplane.setPassengerCapacity(passengerCapacity);
        airplane.setMaximumRange(maximumRange);
        airplane.setMaximumCargoCapacity(maximumCargoCapacity);
        airplane.setMaximumTakeoffWeight(maximumTakeoffWeight);
        airplane.setRoutes(new ArrayList<>());
        airplane.setFlights(new ArrayList<>());
        return airplane;
    }

    @Override
    public String toString() {
        return String.valueOf("| AIRPLANE | CODE : " + this.getAirplaneCode()
                + " | AIRLINE : " + this.getAirline() + " | PASSENGER C. : "
                + this.getPassengerCapacity() + " | RANGE : "
                + this.getMaximumRange() + " | CARGO C. : " + this.getMaximumCargoCapacity()
                + " | TAKEOFF WEIGHT : " + this.getMaximumTakeoffWeight() + " |");
    }

    public void addRoute(Route route) {
        if (!routes.contains(route)) {
            routes.add(route);
        }
    }

    @Id
    @GeneratedValue
    @Column(name = "id_airplane", nullable = false, insertable = true, updatable = true)
    public int getIdAirplane() {
        return idAirplane;
    }

    public void setIdAirplane(int idAirplane) {
        this.idAirplane = idAirplane;
    }
    
    @Basic
    @Column(name = "passenger_capacity", nullable = false, insertable = true, updatable = true)
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    @Basic
    @Column(name = "maximum_range", nullable = false, insertable = true, updatable = true)
    public int getMaximumRange() {
        return maximumRange;
    }

    public void setMaximumRange(int maximumRange) {
        this.maximumRange = maximumRange;
    }

    @Basic
    @Column(name = "airline", nullable = true, insertable = true, updatable = true, length = 10000)
    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    @Basic
    @Column(name = "maximum_cargo_capacity", nullable = true, insertable = true, updatable = true)
    public Integer getMaximumCargoCapacity() {
        return maximumCargoCapacity;
    }

    public void setMaximumCargoCapacity(Integer maximumCargoCapacity) {
        this.maximumCargoCapacity = maximumCargoCapacity;
    }

    @Basic
    @Column(name = "maximum_takeoff_weight", nullable = true, insertable = true, updatable = true)
    public Integer getMaximumTakeoffWeight() {
        return maximumTakeoffWeight;
    }

    public void setMaximumTakeoffWeight(Integer maximumTakeoffWeight) {
        this.maximumTakeoffWeight = maximumTakeoffWeight;
    }

    @Basic
    @Column(name = "airplane_code", nullable = false, insertable = true, updatable = true, length = 10000)
    public String getAirplaneCode() {
        return airplaneCode;
    }

    public void setAirplaneCode(String airplaneCode) {
        this.airplaneCode = airplaneCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Airplane airplane = (Airplane) o;

        if (idAirplane != airplane.idAirplane) {
            return false;
        }
        if (passengerCapacity != airplane.passengerCapacity) {
            return false;
        }
        if (maximumRange != airplane.maximumRange) {
            return false;
        }
        if (airline != null ? !airline.equals(airplane.airline) : airplane.airline != null) {
            return false;
        }
        if (maximumCargoCapacity != null ? !maximumCargoCapacity.equals(airplane.maximumCargoCapacity) : airplane.maximumCargoCapacity != null) {
            return false;
        }
        if (maximumTakeoffWeight != null ? !maximumTakeoffWeight.equals(airplane.maximumTakeoffWeight) : airplane.maximumTakeoffWeight != null) {
            return false;
        }
        if (airplaneCode != null ? !airplaneCode.equals(airplane.airplaneCode) : airplane.airplaneCode != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAirplane;
        result = 31 * result + passengerCapacity;
        result = 31 * result + maximumRange;
        result = 31 * result + (airline != null ? airline.hashCode() : 0);
        result = 31 * result + (maximumCargoCapacity != null ? maximumCargoCapacity.hashCode() : 0);
        result = 31 * result + (maximumTakeoffWeight != null ? maximumTakeoffWeight.hashCode() : 0);
        result = 31 * result + (airplaneCode != null ? airplaneCode.hashCode() : 0);
        return result;
    }

    @ManyToMany(mappedBy = "airplanes")
    @JoinTable(name = "route")
    public Collection<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(Collection<Route> routes) {
        this.routes = routes;
    }

    @OneToMany
    public Collection<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Collection<Flight> flights) {
        this.flights = flights;
    }

}
