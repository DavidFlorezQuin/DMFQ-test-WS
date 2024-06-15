package com.aerolinea.amonic.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "air_ports")
public class AirPorts extends ABaseEntity{

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Countries countries;
    @Column(name = "iatacode", length = 50, nullable = false)
    private String iatacode;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    public Countries getCountries() {
        return countries;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
    }

    public String getIatacode() {
        return iatacode;
    }

    public void setIatacode(String iatacode) {
        this.iatacode = iatacode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
