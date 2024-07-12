package com.aerolinea.amonic.Service;

import com.aerolinea.amonic.Dto.ConsultaAsientosDto;
import com.aerolinea.amonic.Dto.AsientosVueloDto;
import com.aerolinea.amonic.Dto.FiltrarPrecio;
import com.aerolinea.amonic.Dto.PrecioVuelo;
import com.aerolinea.amonic.Entity.Tickets;
import com.aerolinea.amonic.IService.ITicketsService;
import com.aerolinea.amonic.Repository.IBaseRepository;
import com.aerolinea.amonic.Repository.ITicketsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TicketsService extends ABaseService<Tickets> implements ITicketsService {
    @Autowired
    private ITicketsRepository repository;
    @Override
    protected IBaseRepository<Tickets, Long> getRepository() {
        return repository;
    }


    @Override
    public Optional<AsientosVueloDto> vuelosDisponibles(ConsultaAsientosDto consultaAsientosDto) {

        Integer vuelo = consultaAsientosDto.getId();
        Integer ticket = consultaAsientosDto.getTicketsComprar();
        Integer silla = consultaAsientosDto.getSilla();

        return repository.getVuelosDisponibles(vuelo, ticket, silla);

    }

    @Override
    public Optional<PrecioVuelo> obtenerPrecio(FiltrarPrecio filtrarPrecio) {

        Integer silla = filtrarPrecio.getSilla();
        Integer ticket = filtrarPrecio.getTickets();
        Integer vuelo = filtrarPrecio.getVuelo();
        return repository.getPrecio(vuelo, ticket, silla);
    }

    @Override
    @Transactional
    public void actualizarAvion(Integer scheduleId) {
        repository.updateScheduleState(scheduleId);
    }

}
