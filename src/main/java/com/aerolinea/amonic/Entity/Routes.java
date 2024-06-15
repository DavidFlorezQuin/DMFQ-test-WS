package com.aerolinea.amonic.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "routes")
public class Routes extends ABaseEntity{
    @Column(name = "distance", length = 50, nullable = false)
    private String distance;

    @Column(name = "flight_time", length = 50, nullable = false)
    private String flightTime;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "departure_airport_id", nullable = false)
    private AirPorts airPortsDepartureId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "arrival_airport_id", nullable = false)
    private AirPorts airPortsArrivalId;


    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }

    public AirPorts getAirPortsDepartureId() {
        return airPortsDepartureId;
    }

    public void setAirPortsDepartureId(AirPorts airPortsDepartureId) {
        this.airPortsDepartureId = airPortsDepartureId;
    }

    public AirPorts getAirPortsArrivalId() {
        return airPortsArrivalId;
    }

    public void setAirPortsArrivalId(AirPorts airPortsArrivalId) {
        this.airPortsArrivalId = airPortsArrivalId;
    }
}
