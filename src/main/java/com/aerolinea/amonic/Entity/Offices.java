package com.aerolinea.amonic.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "offices")
public class Offices extends ABaseEntity{
    @Column(name = "title", length = 50, nullable = false)
    private String title;
    @Column(name = "phone", length = 50, nullable = false)
    private String phone;

    @Column(name = "contact", length = 50, nullable = false)
    private String contact;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Countries countries;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Countries getCountries() {
        return countries;
    }

    public void setCountries(Countries countries) {
        this.countries = countries;
    }
}
