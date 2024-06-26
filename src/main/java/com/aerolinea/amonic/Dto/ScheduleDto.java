package com.aerolinea.amonic.Dto;

import java.util.Date;

public interface ScheduleDto extends IGenericDto{


    String getFlightNumber();

    String getDepartureAirportCode();

    String getDepartureAirportName();

    String getArrivalAirportCode();

    String getArrivalAirportName();

    Date getDepartureDate();

    String getDepartureTime();

    String getCabinType();
    String getEconomyPrice();

}
