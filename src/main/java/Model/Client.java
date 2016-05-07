package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

/**
 * Created by M on 27. 4. 2016.
 */
@Entity
public class Client implements Serializable {
    private int idClient;
    private String passportNumber;
    private String address;
    private String gender;
    private String email;
    private String phoneNumber;
    private Collection<Ticket> tickets;

    public static Client createClient(String passportNumber, String address, String gender, String email, String phoneNumber){
        Client client = new Client();
        client.setPassportNumber(passportNumber);
        client.setAddress(address);
        client.setGender(gender);
        client.setEmail(email);
        client.setPhoneNumber(phoneNumber);
        client.setTickets(new ArrayList<>());
        return client;
    }

    @Override
    public String toString() {
        return String.valueOf("[ " + this.getClass().toString() + " : " + this.getIdClient() + " ; "
                + this.email + " ; " + this.getPassportNumber() + " ; " + this.getAddress() + " ; " +
                this.getPhoneNumber() + " ; " + this.getGender() + " ]");
    }

    @Id
    @GeneratedValue
    @Column(name = "id_client", nullable = false, insertable = true, updatable = true)
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "passport_number", nullable = false, insertable = true, updatable = true, length = 10000)
    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Basic
    @Column(name = "address", nullable = false, insertable = true, updatable = true, length = 10000)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "gender", nullable = false, insertable = true, updatable = true, length = 10000)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "email", nullable = true, insertable = true, updatable = true, length = 10000)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone_number", nullable = true, insertable = true, updatable = true, length = 10000)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (idClient != client.idClient) return false;
        if (passportNumber != null ? !passportNumber.equals(client.passportNumber) : client.passportNumber != null)
            return false;
        if (address != null ? !address.equals(client.address) : client.address != null) return false;
        if (gender != null ? !gender.equals(client.gender) : client.gender != null) return false;
        if (email != null ? !email.equals(client.email) : client.email != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(client.phoneNumber) : client.phoneNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idClient;
        result = 31 * result + (passportNumber != null ? passportNumber.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        return result;
    }

    @OneToMany
    public Collection<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Collection<Ticket> tickets) {
        this.tickets = tickets;
    }
}
