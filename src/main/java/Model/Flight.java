package Model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by M on 27. 4. 2016.
 */
@Entity
public class Flight implements Serializable {
    private int idFlight;
    private Date departureDate;
    private Date arrivalDate;
    private boolean inspected;
    private int fuelRequired;
    private int numBookedSeats;
    private Route route;
    private Airplane airplane;
    private Collection<CrewMember> crewMembers;
    private Collection<Ticket> tickets;

    public static Flight createFlight(Date departureDate, Date arrivalDate, boolean inspected, int fuelRequired, int numBookedSeats) {
        Flight flight = new Flight();
        flight.setDepartureDate(departureDate);
        flight.setArrivalDate(arrivalDate);
        flight.setInspected(inspected);
        flight.setFuelRequired(fuelRequired);
        flight.setNumBookedSeats(numBookedSeats);
        flight.setCrewMembers(new ArrayList<CrewMember>());
        flight.setTickets(new ArrayList<Ticket>());
        flight.setAirplane(null);
        flight.setRoute(null);
        return flight;
    }

    @Override
    public String toString() {
        return String.valueOf("[ " + this.getClass().toString() + " : " + this.getIdFlight() + " ; "
                + this.getDepartureDate().toString() + " ; " + this.getArrivalDate().toString() + " ; "
                + this.getFuelRequired() + " ; " + (this.isInspected() ? "inspected" : "not inspected") + " ; "
                + this.getNumBookedSeats() + " ]");
    }

    @Id
    @GeneratedValue
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
    public Route getRoute() {
        return route;
    }

    public void setRoute(Route routeByRouteIdRoute) {
        this.route = routeByRouteIdRoute;
    }

    @ManyToMany(mappedBy = "flights")
    @JoinTable(name = "crew_member")
    public Collection<CrewMember> getCrewMembers() {
        return crewMembers;
    }

    public void setCrewMembers(Collection<CrewMember> crewMembers) {
        this.crewMembers = crewMembers;
    }

    @ManyToOne
    @JoinColumn(name = "airplane_id_airplane", referencedColumnName = "id_airplane", nullable = false)
    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    @OneToMany
    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }
}
