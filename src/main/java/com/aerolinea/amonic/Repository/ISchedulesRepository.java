package com.aerolinea.amonic.Repository;

import com.aerolinea.amonic.Dto.ScheduleDto;
import com.aerolinea.amonic.Dto.ScheduleReturnDto;
import com.aerolinea.amonic.Entity.Schedules;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface ISchedulesRepository extends IBaseRepository<Schedules, Long> {

    @Query(value = "SELECT " +
            "s.id, "+
            "s.flight_number AS flightNumber, " +
            "a1.iatacode AS departureAirportCode, " +
            "a1.name AS departureAirportName, " +
            "a2.iatacode AS arrivalAirportCode, " +
            "a2.name AS arrivalAirportName, " +
            "s.date AS departureDate, " +
            "s.time AS departureTime, " +
            "c.name AS cabinType, " +
            "s.economy_price AS economyPrice " +
            "FROM schedules s " +
            "JOIN routes r ON s.route_id = r.id " +
            "JOIN air_ports a1 ON r.departure_airport_id = a1.id " +
            "JOIN air_ports a2 ON r.arrival_airport_id = a2.id " +
            "JOIN tickets t ON s.id = t.schedule_id " +
            "JOIN cabin_types c ON t.cabin_type_id = c.id " +
            "WHERE a1.iatacode = :departureAirportCode " +
            "AND a2.iatacode = :arrivalAirportCode " +
            "AND c.name = :cabinType " +
            "AND DATE(s.date) = :departureDate",
            nativeQuery = true)

    List<ScheduleDto> getListFlight(String departureAirportCode, String arrivalAirportCode, String cabinType, LocalDate departureDate);

    @Query(value = "SELECT " +
            "s.id, "+
            "s.flight_number AS flightNumber, " +
            "a1.iatacode AS departureAirportCode, " +
            "a1.name AS departureAirportName, " +
            "a2.iatacode AS arrivalAirportCode, " +
            "a2.name AS arrivalAirportName, " +
            "s.date AS departureDate, " +
            "s.time AS departureTime, " +
            "c.name AS cabinType, " +
            "s.economy_price AS economyPrice " +
            "FROM schedules s " +
            "JOIN routes r ON s.route_id = r.id " +
            "JOIN air_ports a1 ON r.departure_airport_id = a1.id " +
            "JOIN air_ports a2 ON r.arrival_airport_id = a2.id " +
            "JOIN tickets t ON s.id = t.schedule_id " +
            "JOIN cabin_types c ON t.cabin_type_id = c.id " +
            "WHERE a1.iatacode = :departureAirportCode " +
            "AND a2.iatacode = :arrivalAirportCode " +
            "AND c.name = :cabinType " +
            "AND DATE(s.date) = :departureDate",
            nativeQuery = true)

    List<ScheduleReturnDto> getListFlightReturn(String departureAirportCode, String arrivalAirportCode, String cabinType, LocalDate departureDate);

    }


