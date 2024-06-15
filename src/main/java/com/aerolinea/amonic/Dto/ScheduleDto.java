package com.aerolinea.amonic.Dto;

import java.util.Date;

public interface ScheduleDto extends IGenericDto{


    String getFlightNumber();

    Date getDepartureDate();

    String getDepartureTime();

    Double getEconomyPrice();

    String getAircraftMakeModel();

    String getAircraftName();

    Long getDepartureAirportId();

    Long getArrivalAirportId();

    String getDepartureAirport();

    String getArrivalAirport();

    String getCabinType();}
