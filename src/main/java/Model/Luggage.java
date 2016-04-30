package Model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by M on 27. 4. 2016.
 */
@Entity
public class Luggage implements Serializable {
    private int idLuggage;
    private int weight;
    private Integer luggageType;
    private String code;
    private Ticket ticketByTicketIdTicket;

    @Id
    @Column(name = "id_luggage", nullable = false, insertable = true, updatable = true)
    public int getIdLuggage() {
        return idLuggage;
    }

    public void setIdLuggage(int idLuggage) {
        this.idLuggage = idLuggage;
    }

    @Basic
    @Column(name = "weight", nullable = false, insertable = true, updatable = true)
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "luggage_type", nullable = true, insertable = true, updatable = true)
    public Integer getLuggageType() {
        return luggageType;
    }

    public void setLuggageType(Integer luggageType) {
        this.luggageType = luggageType;
    }

    @Basic
    @Column(name = "code", nullable = false, insertable = true, updatable = true, length = 2147483647)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Luggage luggage = (Luggage) o;

        if (idLuggage != luggage.idLuggage) return false;
        if (weight != luggage.weight) return false;
        if (luggageType != null ? !luggageType.equals(luggage.luggageType) : luggage.luggageType != null) return false;
        if (code != null ? !code.equals(luggage.code) : luggage.code != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLuggage;
        result = 31 * result + weight;
        result = 31 * result + (luggageType != null ? luggageType.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "ticket_id_ticket", referencedColumnName = "id_ticket", nullable = false)
    public Ticket getTicketByTicketIdTicket() {
        return ticketByTicketIdTicket;
    }

    public void setTicketByTicketIdTicket(Ticket ticketByTicketIdTicket) {
        this.ticketByTicketIdTicket = ticketByTicketIdTicket;
    }
}
