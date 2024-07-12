package com.aerolinea.amonic.Repository;

import com.aerolinea.amonic.Dto.AsientosVueloDto;
import com.aerolinea.amonic.Dto.FiltrarPrecio;
import com.aerolinea.amonic.Dto.PrecioVuelo;
import com.aerolinea.amonic.Dto.ScheduleDto;
import com.aerolinea.amonic.Entity.Tickets;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ITicketsRepository extends IBaseRepository<Tickets, Long> {

    @Query(value = "SELECT COUNT(t.cabin_type_id) + :ticket AS ticketSolicitados, " +
            "CASE " +
            "  WHEN t.cabin_type_id = 1 THEN ai.economy_seats " +
            "  WHEN t.cabin_type_id = 2 THEN ai.business_seats " +
            "END AS asientosTotales, " +
            "CASE " +
            "  WHEN t.cabin_type_id = 1 THEN (ai.economy_seats - COUNT(t.cabin_type_id)) " +
            "  WHEN t.cabin_type_id = 2 THEN (ai.business_seats - COUNT(t.cabin_type_id)) " +
            "END AS disponible " +
            "FROM tickets t " +
            "JOIN schedules s ON t.schedule_id = s.id " +
            "JOIN air_crafts ai ON s.air_craft_id = ai.id " +
            "WHERE t.schedule_id = :vuelo " +
            "AND t.cabin_type_id = :silla " +
            "GROUP BY t.cabin_type_id, ai.economy_seats, ai.business_seats",
            nativeQuery = true)
    Optional<AsientosVueloDto> getVuelosDisponibles(@Param("vuelo") Integer vuelo, @Param("ticket") Integer ticket, @Param("silla") Integer silla);


    @Query(value =
            "SELECT " +
                    "CASE " +
                    "WHEN t.cabin_type_id = 1 THEN s.economy_price " +
                    "WHEN t.cabin_type_id = 2 THEN (s.economy_price * 1.3) " +
                    "END AS precioUnitario, " +
                    " CASE" +
                    " WHEN t.cabin_type_id = 1 THEN s.economy_price * :ticket" +
                    " WHEN t.cabin_type_id = 2 THEN (s.economy_price * 1.3) * :ticket" +
                    " END AS precioTotal" +
                    " FROM tickets t" +
                    " JOIN schedules s ON t.schedule_id = s.id" +
                    " WHERE t.cabin_type_id = :silla" +
                    " AND t.schedule_id = :vuelo " +
                    " LIMIT 1", nativeQuery = true)
    Optional<PrecioVuelo> getPrecio(@Param("vuelo") Integer vuelo, @Param("ticket") Integer ticket, @Param("silla") Integer silla);

    @Transactional
    @Modifying
    @Query(value = "UPDATE schedules s " +
            " JOIN air_crafts ai ON s.air_craft_id = ai.id " +
            " SET s.state = CASE " +
            "               WHEN (" +
            "                   SELECT COUNT(t.cabin_type_id) " +
            "                   FROM tickets t " +
            "                   WHERE t.schedule_id = :scheduleId " +
            "               ) = ai.total_seats THEN 0 " +
            "               ELSE s.state " +
            "           END " +
            " WHERE s.id = :scheduleId",
            nativeQuery = true)
            void updateScheduleState(@Param("scheduleId") Integer scheduleId);

}