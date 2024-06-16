package com.aerolinea.amonic.Service;

import com.aerolinea.amonic.Dto.ScheduleDto;
import com.aerolinea.amonic.Entity.Schedules;
import com.aerolinea.amonic.IService.ISchedulesService;
import com.aerolinea.amonic.Repository.IBaseRepository;
import com.aerolinea.amonic.Repository.ISchedulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
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
    public List<ScheduleDto> getListFlight(String departureAirportCode, String arrivalAirportCode, String cabinType, LocalDate departureDate) {
        return repository.getListFlight(departureAirportCode, arrivalAirportCode, cabinType, departureDate);
    }

   /* @Override
    public List<ScheduleDto> findFlightsByCriteria(String origin, String destination, String cabinType, Date startDate, Date endDate) {
        return repository.findFlightsByCriteria(origin, destination, cabinType, startDate, endDate);
    }

    */
}
