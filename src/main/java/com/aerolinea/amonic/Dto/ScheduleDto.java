package com.aerolinea.amonic.Dto;

import java.time.LocalDate;

public interface ScheduleDto {

    Long getId();
    String getOrigenAeropuerto();
    String getDestinoAeropuerto();
    LocalDate getDate();

    String getTime();   
    String getFlightNumber();
    String EconomyPrice();

}
