package Entities;

import javax.persistence.*;

/**
 * Created by M on 23. 4. 2016.
 */
@Entity
@Table(name = "airplane", schema = "public", catalog = "student_db16_19")
public class AirplaneEntity {
    private int idAirplane;
    private int capacity;
    private int fuel;
    private String airline;
    private Integer payload;
    private Integer loadingCapacity;

    @Id
    @Column(name = "id_airplane")
    public int getIdAirplane() {
        return idAirplane;
    }

    public void setIdAirplane(int idAirplane) {
        this.idAirplane = idAirplane;
    }

    @Basic
    @Column(name = "capacity")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "fuel")
    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    @Basic
    @Column(name = "airline")
    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    @Basic
    @Column(name = "payload")
    public Integer getPayload() {
        return payload;
    }

    public void setPayload(Integer payload) {
        this.payload = payload;
    }

    @Basic
    @Column(name = "loading_capacity")
    public Integer getLoadingCapacity() {
        return loadingCapacity;
    }

    public void setLoadingCapacity(Integer loadingCapacity) {
        this.loadingCapacity = loadingCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AirplaneEntity that = (AirplaneEntity) o;

        if (idAirplane != that.idAirplane) return false;
        if (capacity != that.capacity) return false;
        if (fuel != that.fuel) return false;
        if (airline != null ? !airline.equals(that.airline) : that.airline != null) return false;
        if (payload != null ? !payload.equals(that.payload) : that.payload != null) return false;
        if (loadingCapacity != null ? !loadingCapacity.equals(that.loadingCapacity) : that.loadingCapacity != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAirplane;
        result = 31 * result + capacity;
        result = 31 * result + fuel;
        result = 31 * result + (airline != null ? airline.hashCode() : 0);
        result = 31 * result + (payload != null ? payload.hashCode() : 0);
        result = 31 * result + (loadingCapacity != null ? loadingCapacity.hashCode() : 0);
        return result;
    }
}
