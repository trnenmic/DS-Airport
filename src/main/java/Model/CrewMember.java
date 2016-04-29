package Model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by M on 27. 4. 2016.
 */
@Entity
@Table(name = "crew_member", schema = "public", catalog = "student_db16_19")
public class CrewMember {
    private int idCrewMember;
    private String passportNumber;
    private String address;
    private String gender;

    private Collection<Flight> flights;

    @Id
    @Column(name = "id_crew_member", nullable = false, insertable = true, updatable = true)
    public int getIdCrewMember() {
        return idCrewMember;
    }

    public void setIdCrewMember(int idCrewMember) {
        this.idCrewMember = idCrewMember;
    }

    @Basic
    @Column(name = "passport_number", nullable = false, insertable = true, updatable = true, length = 2147483647)
    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Basic
    @Column(name = "address", nullable = false, insertable = true, updatable = true, length = 2147483647)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "gender", nullable = false, insertable = true, updatable = true, length = 2147483647)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CrewMember that = (CrewMember) o;

        if (idCrewMember != that.idCrewMember) return false;
        if (passportNumber != null ? !passportNumber.equals(that.passportNumber) : that.passportNumber != null)
            return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCrewMember;
        result = 31 * result + (passportNumber != null ? passportNumber.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    @ManyToMany
    public Collection<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Collection<Flight> flights) {
        this.flights = flights;
    }
}
