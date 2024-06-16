package com.aerolinea.amonic.Controller;

import com.aerolinea.amonic.Dto.ApiResponseDto;
import com.aerolinea.amonic.Dto.ScheduleDto;
import com.aerolinea.amonic.Entity.Schedules;
import com.aerolinea.amonic.IService.ISchedulesService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/schedules")

public class SchedulesController extends ABaseController<Schedules, ISchedulesService> {


    protected SchedulesController(ISchedulesService service) {
        super(service, "Schedules");
    }



    @GetMapping("/search")
    public ResponseEntity<ApiResponseDto<List<ScheduleDto>>> show( @RequestParam("departureAirportCode") String departureAirportCode,
                                                                   @RequestParam("arrivalAirportCode") String arrivalAirportCode,
                                                                   @RequestParam("cabinType") String cabinType,
                                                                   @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departureDate){
        try{
            List<ScheduleDto> entity = service.getListFlight(departureAirportCode, arrivalAirportCode, cabinType, departureDate);
            return ResponseEntity.ok(new ApiResponseDto<List<ScheduleDto>>("Registro encontrado", entity, true));

        } catch (Exception e){
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<ScheduleDto>>(e.getMessage(), null, false));

        }
    }


    @GetMapping("/searchReturn")
    public ResponseEntity<ApiResponseDto<List<ScheduleDto>>> showReturn( @RequestParam("departureAirportCode") String departureAirportCode,
                                                                   @RequestParam("arrivalAirportCode") String arrivalAirportCode,
                                                                   @RequestParam("cabinType") String cabinType,
                                                                   @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departureDate){
        try{
            List<ScheduleDto> entity = service.getListFlight(departureAirportCode, arrivalAirportCode, cabinType, departureDate);
            return ResponseEntity.ok(new ApiResponseDto<List<ScheduleDto>>("Registro encontrado", entity, true));

        } catch (Exception e){
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<ScheduleDto>>(e.getMessage(), null, false));

        }
    }



}
