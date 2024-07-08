package com.aerolinea.amonic.Service;

import com.aerolinea.amonic.Dto.ScheduleDto;
import com.aerolinea.amonic.Dto.ScheduleFilter;
import com.aerolinea.amonic.Dto.ScheduleFilterFlight;
import com.aerolinea.amonic.Entity.Schedules;
import com.aerolinea.amonic.IService.ISchedulesService;
import com.aerolinea.amonic.Repository.IBaseRepository;
import com.aerolinea.amonic.Repository.ISchedulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduleService extends ABaseService<Schedules> implements ISchedulesService {

    @Autowired
    private ISchedulesRepository repository;

    @Override
    protected IBaseRepository<Schedules, Long> getRepository() {
        return repository;
    }


    @Override
    public List<ScheduleDto> buscarRutas(ScheduleFilter scheduleFilter) {

        Integer origen = scheduleFilter.getOrigen();
        Integer destino = scheduleFilter.getDestino();
        LocalDate inicio = scheduleFilter.getInicio();
        LocalDate fin = scheduleFilter.getFin();

        return repository.getListFlight(origen, destino, inicio, fin);
    }

    @Override
    public List<ScheduleDto> buscarRutasEspecificas(ScheduleFilterFlight scheduleFilterFlight) {
        Integer origen = scheduleFilterFlight.getOrigen();
        Integer destino = scheduleFilterFlight.getDestino();
        LocalDate fecha = scheduleFilterFlight.getFecha();
        return repository.getListSpecificFlight(origen, destino, fecha);
    }

}
