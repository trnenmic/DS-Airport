package Entities;

import javax.persistence.*;

/**
 * Created by M on 23. 4. 2016.
 */
@Entity
@Table(name = "crew_member", schema = "public", catalog = "student_db16_19")
public class CrewMemberEntity {
    private int idCrewMember;
    private int passportNumber;
    private int address;
    private int gender;

    @Id
    @Column(name = "id_crew_member")
    public int getIdCrewMember() {
        return idCrewMember;
    }

    public void setIdCrewMember(int idCrewMember) {
        this.idCrewMember = idCrewMember;
    }

    @Basic
    @Column(name = "passport_number")
    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Basic
    @Column(name = "address")
    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    @Basic
    @Column(name = "gender")
    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CrewMemberEntity that = (CrewMemberEntity) o;

        if (idCrewMember != that.idCrewMember) return false;
        if (passportNumber != that.passportNumber) return false;
        if (address != that.address) return false;
        if (gender != that.gender) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCrewMember;
        result = 31 * result + passportNumber;
        result = 31 * result + address;
        result = 31 * result + gender;
        return result;
    }
}
