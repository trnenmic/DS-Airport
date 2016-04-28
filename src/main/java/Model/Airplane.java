package Model;

import javax.persistence.*;

/**
 * Created by M on 27. 4. 2016.
 */
@Entity
public class Airplane {
    private int idAirplane;
    private int capacity;
    private int fuelTankCapacity;
    private String airline;
    private Integer payload;
    private Integer loadingCapacity;
    private String airplaneCode;


    public static Airplane createAirplane(int capacity, int fuelTankCapacity,
                                          String airline, Integer payload, Integer loadingCapacity, String airplaneCode) {
        Airplane airplane = new Airplane();
        airplane.setCapacity(capacity);
        airplane.setFuelTankCapacity(fuelTankCapacity);
        airplane.setAirline(airline);
        airplane.setPayload(payload);
        airplane.setLoadingCapacity(loadingCapacity);
        //
        airplane.setAirplaneCode(airplaneCode);
        return airplane;
    }

    public String toString() {
        return String.valueOf("[ " + this.getClass().toString() + " : " + this.getIdAirplane() + " ; "
                + this.getAirplaneCode() + " ; " + this.getAirline() + " ; " + this.getCapacity() + " ; " +
                this.getFuelTankCapacity() + " ; " + this.getPayload() + " ]");
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
    @Column(name = "capacity", nullable = false, insertable = true, updatable = true)
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "fuel_tank_capacity", nullable = false, insertable = true, updatable = true)
    public int getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public void setFuelTankCapacity(int fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    @Basic
    @Column(name = "airline", nullable = true, insertable = true, updatable = true, length = 2147483647)
    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    @Basic
    @Column(name = "payload", nullable = true, insertable = true, updatable = true)
    public Integer getPayload() {
        return payload;
    }

    public void setPayload(Integer payload) {
        this.payload = payload;
    }

    @Basic
    @Column(name = "loading_capacity", nullable = true, insertable = true, updatable = true)
    public Integer getLoadingCapacity() {
        return loadingCapacity;
    }

    public void setLoadingCapacity(Integer loadingCapacity) {
        this.loadingCapacity = loadingCapacity;
    }

    @Basic
    @Column(name = "airplane_code", nullable = false, insertable = true, updatable = true, length = 2147483647)
    public String getAirplaneCode() {
        return airplaneCode;
    }

    public void setAirplaneCode(String airplaneCode) {
        this.airplaneCode = airplaneCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airplane airplane = (Airplane) o;

        if (idAirplane != airplane.idAirplane) return false;
        if (capacity != airplane.capacity) return false;
        if (fuelTankCapacity != airplane.fuelTankCapacity) return false;
        if (airline != null ? !airline.equals(airplane.airline) : airplane.airline != null) return false;
        if (payload != null ? !payload.equals(airplane.payload) : airplane.payload != null) return false;
        if (loadingCapacity != null ? !loadingCapacity.equals(airplane.loadingCapacity) : airplane.loadingCapacity != null)
            return false;
        if (airplaneCode != null ? !airplaneCode.equals(airplane.airplaneCode) : airplane.airplaneCode != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAirplane;
        result = 31 * result + capacity;
        result = 31 * result + fuelTankCapacity;
        result = 31 * result + (airline != null ? airline.hashCode() : 0);
        result = 31 * result + (payload != null ? payload.hashCode() : 0);
        result = 31 * result + (loadingCapacity != null ? loadingCapacity.hashCode() : 0);
        result = 31 * result + (airplaneCode != null ? airplaneCode.hashCode() : 0);
        return result;
    }
}