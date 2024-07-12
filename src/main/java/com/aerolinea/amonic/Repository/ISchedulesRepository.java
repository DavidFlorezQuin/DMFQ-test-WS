package com.aerolinea.amonic.Repository;

import com.aerolinea.amonic.Dto.ScheduleDto;
import com.aerolinea.amonic.Entity.Schedules;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISchedulesRepository extends IBaseRepository<Schedules, Long> {



    @Query(value = "SELECT " +
            "s.flight_number AS flightNumber, " +
            "s.economy_price AS economyPrice " +
            "FROM schedules s " +
            "JOIN routes r ON s.route_id = r.id " +
            "JOIN air_ports a1 ON r.departure_airport_id = a1.id " +
            "JOIN air_ports a2 ON r.arrival_airport_id = a2.id " +
            "JOIN tickets t ON s.id = t.schedule_id " +
            "JOIN cabin_types c ON t.cabin_type_id = c.id " +
            "WHERE (:origen IS NULL OR r.departure_airport_id = :origen) " +
            "AND (:destino IS NULL OR r.arrival_airport_id = :destino) " +
            "AND (:inicio IS NULL OR :fin IS NULL OR r.created_at BETWEEN :inicio AND :fin)" +
            "AND s.state = 1",
            nativeQuery = true)
    List<ScheduleDto> getListFlight(@Param("origen") Integer origen,
                                    @Param("destino") Integer destino,
                                    @Param("inicio") LocalDate inicio,
                                    @Param("fin") LocalDate fin);

    @Query(value = "SELECT " +
            "s.id, " +
            "a1.name AS origenAeropuerto, " +
            "a2.name AS destinoAeropuerto, " +
            "s.date AS date, " +
            "s.time AS time, " +
            "s.flight_number AS flightNumber, " +
            "s.economy_price AS economyPrice " +
            "FROM schedules s " +
            "JOIN routes r ON s.route_id = r.id " +
            "JOIN air_ports a1 ON r.departure_airport_id = a1.id " +
            "JOIN air_ports a2 ON r.arrival_airport_id = a2.id " +
            "WHERE (:origen IS NULL OR r.departure_airport_id = :origen) " +
            "AND (:destino IS NULL OR r.arrival_airport_id = :destino) " +
            "AND (:fecha IS NULL OR s.date = :fecha)" +
            "AND s.state = 1",
            nativeQuery = true)
    List<ScheduleDto> getListSpecificFlight(@Param("origen") Integer origen,
                                    @Param("destino") Integer destino,
                                    @Param("fecha") LocalDate fecha);
}





