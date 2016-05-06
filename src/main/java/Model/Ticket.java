package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

/**
 * Created by M on 27. 4. 2016.
 */
@Entity
public class Ticket implements Serializable {
    private int idTicket;
    private String ticketNumber;
    private int travelClass;
    private int price;
    private int seat;
    private Flight flight;
    private Client client;
    private Collection<Luggage> luggages;

    public static Ticket createTicket(String ticketNumber, int travelClass, int price, int seat) {
        Ticket ticket = new Ticket();
        ticket.setTicketNumber(ticketNumber);
        ticket.setTravelClass(travelClass);
        ticket.setPrice(price);
        ticket.setSeat(seat);
        ticket.setLuggages(new ArrayList<>());
        ticket.setFlight(null);
        ticket.setClient(null);
        return ticket;
    }

    @Override
    public String toString() {
        return String.valueOf("[ " + this.getClass().toString() + " : " + this.getTicketNumber() + " ; "
                + this.getTravelClass() + " ; " + this.getPrice() + " ; " + this.getSeat() + " ]");
    }

    @Id
    @GeneratedValue
    @Column(name = "id_ticket", nullable = false, insertable = true, updatable = true)
    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    @Basic
    @Column(name = "ticket_number", nullable = false, insertable = true, updatable = true, length = 10000)
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    @Basic
    @Column(name = "travel_class", nullable = false, insertable = true, updatable = true)
    public int getTravelClass() {
        return travelClass;
    }

    public void setTravelClass(int travelClass) {
        this.travelClass = travelClass;
    }

    @Basic
    @Column(name = "price", nullable = false, insertable = true, updatable = true)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "seat", nullable = false, insertable = true, updatable = true)
    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (idTicket != ticket.idTicket) return false;
        if (travelClass != ticket.travelClass) return false;
        if (price != ticket.price) return false;
        if (seat != ticket.seat) return false;
        if (ticketNumber != null ? !ticketNumber.equals(ticket.ticketNumber) : ticket.ticketNumber != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTicket;
        result = 31 * result + (ticketNumber != null ? ticketNumber.hashCode() : 0);
        result = 31 * result + travelClass;
        result = 31 * result + price;
        result = 31 * result + seat;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "flight_id_flight", referencedColumnName = "id_flight", nullable = false)
    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @OneToMany
    public Collection<Luggage> getLuggages() {
        return luggages;
    }

    public void setLuggages(Collection<Luggage> luggages) {
        this.luggages = luggages;
    }

    @ManyToOne
    @JoinColumn(name = "client_id_passenger", referencedColumnName = "id_passenger", nullable = false)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
