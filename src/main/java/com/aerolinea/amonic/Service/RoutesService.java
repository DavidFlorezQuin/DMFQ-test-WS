package com.aerolinea.amonic.Service;

import com.aerolinea.amonic.Dto.BuscarRutas;
import com.aerolinea.amonic.Entity.Routes;
import com.aerolinea.amonic.IService.IRoutesService;
import com.aerolinea.amonic.Repository.IBaseRepository;
import com.aerolinea.amonic.Repository.IRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service

public class RoutesService extends ABaseService<Routes> implements IRoutesService {

    @Autowired
    private IRouteRepository repository;
    @Override
    protected IBaseRepository<Routes, Long> getRepository() {
        return repository;
    }

/**
    @Override
    public List<Routes> buscarRutas(BuscarRutas buscarRutas) {

        Integer salidaAeropuerto = buscarRutas.getSalidaAeropuerto();
        Integer destinoAeropuerto = buscarRutas.getDestinoAeropuerto();
        LocalDate inicioVuelo = buscarRutas.getInicioVuelo();
        LocalDate llegadaVuelo = buscarRutas.getLlegadaVuelo();

        return repository.buscarRutas(salidaAeropuerto,destinoAeropuerto, inicioVuelo, llegadaVuelo);
    }

    **/
}
