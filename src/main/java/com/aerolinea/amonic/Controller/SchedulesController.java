package com.aerolinea.amonic.Controller;

import com.aerolinea.amonic.Dto.ApiResponseDto;
import com.aerolinea.amonic.Dto.ScheduleDto;
import com.aerolinea.amonic.Entity.Schedules;
import com.aerolinea.amonic.IService.ISchedulesService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/schedules")

public class SchedulesController extends ABaseController<Schedules, ISchedulesService> {
    /**
     * Constructor for ABaseController.
     *
     * @param service    The service for the entity.
     */
    protected SchedulesController(ISchedulesService service) {
        super(service, "Schedules");
    }

    @PostMapping("/search")
    public ResponseEntity<ApiResponseDto<List<ScheduleDto>>> show( @RequestParam("origin") String origin,
                                                                   @RequestParam("destination") String destination,
                                                                   @RequestParam("cabinType") String cabinType,
                                                                   @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                                   @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        try {
            List<ScheduleDto> entity = service.findFlightsByCriteria(origin, destination, cabinType, startDate, endDate);
            return ResponseEntity.ok(new ApiResponseDto<List<ScheduleDto>>("Registro encontrado", entity, true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<ScheduleDto>>(e.getMessage(), null, false));
        }
    }
}
