package com.aerolinea.amonic.Repository;

import com.aerolinea.amonic.Dto.ScheduleDto;
import com.aerolinea.amonic.Entity.Schedules;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ISchedulesRepository extends IBaseRepository<Schedules, Long> {

        @Query("SELECT s FROM Schedule s " +
                "JOIN s.aircraft ac " +
                "JOIN s.route rt " +
                "JOIN rt.departureAirport d_airport " +
                "JOIN rt.arrivalAirport a_airport " +
                "JOIN s.cabinType c_type " +
                "WHERE d_airport.name = :origin " +
                "AND a_airport.name = :destination " +
                "AND c_type.name = :cabinType " +
                "AND s.date BETWEEN :startDate AND :endDate " +
                "AND s.state = true " +
                "ORDER BY s.date, s.time")
        List<ScheduleDto> findFlightsByCriteria(String origin, String destination, String cabinType, Date startDate, Date endDate);

    }


