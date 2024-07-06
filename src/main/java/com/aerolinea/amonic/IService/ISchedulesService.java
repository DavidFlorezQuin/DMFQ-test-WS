package com.aerolinea.amonic.IService;

import com.aerolinea.amonic.Dto.BuscarRutas;
import com.aerolinea.amonic.Dto.ScheduleDto;
import com.aerolinea.amonic.Dto.ScheduleFilter;
import com.aerolinea.amonic.Dto.ScheduleFilterFlight;
import com.aerolinea.amonic.Entity.Routes;
import com.aerolinea.amonic.Entity.Schedules;

import java.util.List;

public interface ISchedulesService extends IBaseService<Schedules> {

    List<ScheduleDto> buscarRutas(ScheduleFilter scheduleFilter);
    List<ScheduleDto> buscarRutasEspecificas(ScheduleFilterFlight scheduleFilterFlight);

}
