package com.aerolinea.amonic.IService;

import com.aerolinea.amonic.Dto.ScheduleDto;
import com.aerolinea.amonic.Dto.ScheduleReturnDto;
import com.aerolinea.amonic.Entity.Schedules;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ISchedulesService extends IBaseService<Schedules> {

  /* List<ScheduleDto> findFlightsByCriteria(String origin, String destination, String cabinType, Date startDate, Date endDate); */

    List<ScheduleDto> getListFlight(String departureAirportCode, String arrivalAirportCode, String cabinType, LocalDate departureDate);
    List<ScheduleReturnDto> getListFlightReturn(String departureAirportCode, String arrivalAirportCode, String cabinType, LocalDate departureDate);

}
