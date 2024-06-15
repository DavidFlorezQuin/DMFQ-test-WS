package com.aerolinea.amonic.Entity;

import jakarta.persistence.*;
import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@Entity
    @Table(name = "tickets")
    public class Tickets extends ABaseEntity {

        @ManyToOne(fetch = FetchType.EAGER, optional = false)
        @JoinColumn(name = "user_id", nullable = false)
        private Users userId;

        @ManyToOne(fetch = FetchType.EAGER, optional = false)
        @JoinColumn(name = "schedule_id", nullable = false)
        private Schedules schedulesId;

        @ManyToOne(fetch = FetchType.EAGER, optional = false)
        @JoinColumn(name = "cabin_type_id", nullable = false)
        private CabinTypes cabinTypesId;

        @Column(name = "first_name", length = 50, nullable = false)
        private String firstName;
        @Column(name = "last_name", length = 50, nullable = false)
        private String lastName;

        @Column(name = "email", length = 50, nullable = false)
        private String email;
        @Column(name = "phone", length = 50, nullable = false)
        private String phone;
        @Column(name = "passport_number", length = 50, nullable = false)
        private String passportNumber;

        @ManyToOne(fetch = FetchType.EAGER, optional = false)
        @JoinColumn(name = "passport_country_id", nullable = false)
        private Countries passportCountryId;

        @Column(name = "passport_photo", length = 50, nullable = false)
        private String passportPhoto;

        @Column(name = "booking_reference", length = 50, nullable = false)
        private String bookingReference;

        @Column(name = "confirmed", length = 50, nullable = false)
        private String confirmed;

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
    }

    public Schedules getSchedulesId() {
        return schedulesId;
    }

    public void setSchedulesId(Schedules schedulesId) {
        this.schedulesId = schedulesId;
    }

    public CabinTypes getCabinTypesId() {
        return cabinTypesId;
    }

    public void setCabinTypesId(CabinTypes cabinTypesId) {
        this.cabinTypesId = cabinTypesId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Countries getPassportCountryId() {
        return passportCountryId;
    }

    public void setPassportCountryId(Countries passportCountryId) {
        this.passportCountryId = passportCountryId;
    }

    public String getPassportPhoto() {
        return passportPhoto;
    }

    public void setPassportPhoto(String passportPhoto) {
        this.passportPhoto = passportPhoto;
    }

    public String getBookingReference() {
        return bookingReference;
    }

    public void setBookingReference(String bookingReference) {
        this.bookingReference = bookingReference;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }
}
