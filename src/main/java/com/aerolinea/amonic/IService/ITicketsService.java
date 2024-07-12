package com.aerolinea.amonic.IService;

import com.aerolinea.amonic.Dto.ConsultaAsientosDto;
import com.aerolinea.amonic.Dto.AsientosVueloDto;
import com.aerolinea.amonic.Dto.FiltrarPrecio;
import com.aerolinea.amonic.Dto.PrecioVuelo;
import com.aerolinea.amonic.Entity.Tickets;

import java.util.Optional;

public interface ITicketsService extends IBaseService<Tickets> {

    Optional<AsientosVueloDto> vuelosDisponibles(ConsultaAsientosDto consultaAsientosDto);
    Optional<PrecioVuelo> obtenerPrecio(FiltrarPrecio filtrarPrecio);

    void actualizarAvion(Integer  scheduleId);
}
