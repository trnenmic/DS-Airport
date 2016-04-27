package Model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by M on 27. 4. 2016.
 */
@Entity
public class Flight {
    private int idFlight;
    private Date departureDate;
    private Date arrivalDate;
    private boolean inspected;
    private int fuelRequired;
    private int numBookedSeats;
    private Route routeByRouteIdRoute;

    @Id
    @Column(name = "id_flight", nullable = false, insertable = true, updatable = true)
    public int getIdFlight() {
        return idFlight;
    }

    public void setIdFlight(int idFlight) {
        this.idFlight = idFlight;
    }

    @Basic
    @Column(name = "departure_date", nullable = false, insertable = true, updatable = true)
    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    @Basic
    @Column(name = "arrival_date", nullable = false, insertable = true, updatable = true)
    public Date getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Basic
    @Column(name = "inspected", nullable = false, insertable = true, updatable = true)
    public boolean isInspected() {
        return inspected;
    }

    public void setInspected(boolean inspected) {
        this.inspected = inspected;
    }

    @Basic
    @Column(name = "fuel_required", nullable = false, insertable = true, updatable = true)
    public int getFuelRequired() {
        return fuelRequired;
    }

    public void setFuelRequired(int fuelRequired) {
        this.fuelRequired = fuelRequired;
    }

    @Basic
    @Column(name = "num_booked_seats", nullable = false, insertable = true, updatable = true)
    public int getNumBookedSeats() {
        return numBookedSeats;
    }

    public void setNumBookedSeats(int numBookedSeats) {
        this.numBookedSeats = numBookedSeats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (idFlight != flight.idFlight) return false;
        if (inspected != flight.inspected) return false;
        if (fuelRequired != flight.fuelRequired) return false;
        if (numBookedSeats != flight.numBookedSeats) return false;
        if (departureDate != null ? !departureDate.equals(flight.departureDate) : flight.departureDate != null)
            return false;
        if (arrivalDate != null ? !arrivalDate.equals(flight.arrivalDate) : flight.arrivalDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFlight;
        result = 31 * result + (departureDate != null ? departureDate.hashCode() : 0);
        result = 31 * result + (arrivalDate != null ? arrivalDate.hashCode() : 0);
        result = 31 * result + (inspected ? 1 : 0);
        result = 31 * result + fuelRequired;
        result = 31 * result + numBookedSeats;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "route_id_route", referencedColumnName = "id_route", nullable = false)
    public Route getRouteByRouteIdRoute() {
        return routeByRouteIdRoute;
    }

    public void setRouteByRouteIdRoute(Route routeByRouteIdRoute) {
        this.routeByRouteIdRoute = routeByRouteIdRoute;
    }
}
