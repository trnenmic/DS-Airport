package Entities;

import javax.persistence.*;

/**
 * Created by M on 23. 4. 2016.
 */
@Entity
@Table(name = "airport", schema = "public", catalog = "student_db16_19")
public class AirportEntity {
    private int idAirport;
    private String city;
    private String airportName;
    private String icao;
    private String iata;
    private String country;

    @Id
    @Column(name = "id_airport")
    public int getIdAirport() {
        return idAirport;
    }

    public void setIdAirport(int idAirport) {
        this.idAirport = idAirport;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "airport_name")
    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    @Basic
    @Column(name = "icao")
    public String getIcao() {
        return icao;
    }

    public void setIcao(String icao) {
        this.icao = icao;
    }

    @Basic
    @Column(name = "iata")
    public String getIata() {
        return iata;
    }

    public void setIata(String iata) {
        this.iata = iata;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AirportEntity that = (AirportEntity) o;

        if (idAirport != that.idAirport) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (airportName != null ? !airportName.equals(that.airportName) : that.airportName != null) return false;
        if (icao != null ? !icao.equals(that.icao) : that.icao != null) return false;
        if (iata != null ? !iata.equals(that.iata) : that.iata != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAirport;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (airportName != null ? airportName.hashCode() : 0);
        result = 31 * result + (icao != null ? icao.hashCode() : 0);
        result = 31 * result + (iata != null ? iata.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }
}
