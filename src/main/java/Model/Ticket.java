package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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

    @Id
    @Column(name = "id_ticket", nullable = false, insertable = true, updatable = true)
    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    @Basic
    @Column(name = "ticket_number", nullable = false, insertable = true, updatable = true, length = 2147483647)
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
}
