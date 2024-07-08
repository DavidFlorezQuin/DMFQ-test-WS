package com.aerolinea.amonic.Controller;

import com.aerolinea.amonic.Dto.*;
import com.aerolinea.amonic.Entity.Routes;
import com.aerolinea.amonic.Dto.ApiResponseDto;
import com.aerolinea.amonic.Dto.ScheduleDto;
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

    @PostMapping("/Flight")
    public ResponseEntity<ApiResponseDto<List<ScheduleDto>>> vuelosEspecifico(@RequestBody ScheduleFilterFlight scheduleFilterFlight){
        try {
            return ResponseEntity.ok(new ApiResponseDto<List<ScheduleDto>>("Datos obtenidos",service.buscarRutasEspecificas(scheduleFilterFlight),true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<List<ScheduleDto>>("Error en la consulta", null, false));


        }}

}
