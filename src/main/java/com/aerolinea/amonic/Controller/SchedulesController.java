package com.aerolinea.amonic.Controller;

<<<<<<< HEAD
import com.aerolinea.amonic.Dto.*;
import com.aerolinea.amonic.Entity.Routes;
=======
import com.aerolinea.amonic.Dto.ApiResponseDto;
import com.aerolinea.amonic.Dto.ScheduleDto;
>>>>>>> parent of 665c477 (ultimo git)
import com.aerolinea.amonic.Entity.Schedules;
import com.aerolinea.amonic.IService.ISchedulesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/schedules")

public class SchedulesController extends ABaseController<Schedules, ISchedulesService> {


    protected SchedulesController(ISchedulesService service) {
        super(service, "Schedules");
    }

    @PostMapping("/serchFlight")
    public ResponseEntity<ApiResponseDto<List<ScheduleDto>>> vuelos(@RequestBody ScheduleFilter scheduleFilter){
        try {
            return ResponseEntity.ok(new ApiResponseDto<List<ScheduleDto>>("Datos obtenidos",service.buscarRutas(scheduleFilter),true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<ScheduleDto>>("Error en la consulta",null,false));
        }
    }

<<<<<<< HEAD
    @PostMapping("/Flight")
    public ResponseEntity<ApiResponseDto<List<ScheduleDto>>> vuelosEspecifico(@RequestBody ScheduleFilterFlight scheduleFilterFlight){
        try {
            return ResponseEntity.ok(new ApiResponseDto<List<ScheduleDto>>("Datos obtenidos",service.buscarRutasEspecificas(scheduleFilterFlight),true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<ScheduleDto>>("Error en la consulta",null,false));
=======

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

>>>>>>> parent of 665c477 (ultimo git)
        }
    }



}
