package com.aerolinea.amonic.IService;

import com.aerolinea.amonic.Dto.BuscarRutas;
import com.aerolinea.amonic.Dto.ScheduleDto;
<<<<<<< HEAD
import com.aerolinea.amonic.Dto.ScheduleFilter;
import com.aerolinea.amonic.Dto.ScheduleFilterFlight;
import com.aerolinea.amonic.Entity.Routes;
=======
>>>>>>> parent of 665c477 (ultimo git)
import com.aerolinea.amonic.Entity.Schedules;

import java.util.List;

public interface ISchedulesService extends IBaseService<Schedules> {

<<<<<<< HEAD
    List<ScheduleDto> buscarRutas(ScheduleFilter scheduleFilter);
    List<ScheduleDto> buscarRutasEspecificas(ScheduleFilterFlight scheduleFilterFlight);

=======
  /* List<ScheduleDto> findFlightsByCriteria(String origin, String destination, String cabinType, Date startDate, Date endDate); */

    List<ScheduleDto> getListFlight(String departureAirportCode, String arrivalAirportCode, String cabinType, LocalDate departureDate);
>>>>>>> parent of 665c477 (ultimo git)
}
