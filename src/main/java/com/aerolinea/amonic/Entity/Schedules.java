package com.aerolinea.amonic.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "schedules")
public class Schedules extends ABaseEntity{

    @Column(name = "date", length = 50, nullable = false)
    private LocalDateTime date;
    @Column(name = "time", length = 50, nullable = false)
    private String time;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "air_craft_id", nullable = false)
    private AirCrafts airCrafts;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "route_id", nullable = false)
    private Routes routes;

    @Column(name = "economy_price", nullable = false)
    private Double economyPrice;

    @Column(name = "confirmed", length = 50, nullable = false)
    private boolean confirmed;

    @Column(name = "flight_number", length = 50, nullable = false)
    private String flightNumber;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public AirCrafts getAirCrafts() {
        return airCrafts;
    }

    public void setAirCrafts(AirCrafts airCrafts) {
        this.airCrafts = airCrafts;
    }

    public Routes getRoutes() {
        return routes;
    }

    public void setRoutes(Routes routes) {
        this.routes = routes;
    }

    public Double getEconomyPrice() {
        return economyPrice;
    }

    public void setEconomyPrice(Double economyPrice) {
        this.economyPrice = economyPrice;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}
