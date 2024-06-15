package com.aerolinea.amonic.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "air_crafts")
public class AirCrafts extends ABaseEntity{

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "make_model", length = 50, nullable = false)
    private String makeModel;

    @Column(name = "total_seats", nullable = false)
    private Integer totalSeats;

    @Column(name = "economy_seats", nullable = false)
    private Integer economySeats;
    @Column(name = "business_seats", nullable = false)
    private Integer businessSeats;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Integer getEconomySeats() {
        return economySeats;
    }

    public void setEconomySeats(Integer economySeats) {
        this.economySeats = economySeats;
    }

    public Integer getBusinessSeats() {
        return businessSeats;
    }

    public void setBusinessSeats(Integer businessSeats) {
        this.businessSeats = businessSeats;
    }
}
