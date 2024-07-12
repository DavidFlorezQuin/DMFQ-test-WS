package com.aerolinea.amonic.Controller;

import com.aerolinea.amonic.Dto.*;
import com.aerolinea.amonic.Entity.Tickets;
import com.aerolinea.amonic.IService.ITicketsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/tickets")
public class TicketsController extends ABaseController<Tickets, ITicketsService> {


    /**
     * Constructor for ABaseController.
     *
     * @param service The service for the entity.
     */
    protected TicketsController(ITicketsService service) {
        super(service, "tickets");
    }

    @PostMapping("consultaSillas")
    public ResponseEntity<ApiResponseDto<Optional<AsientosVueloDto>>> consultaSillas(@RequestBody ConsultaAsientosDto consultaAsientosDto) {

        try {
            return ResponseEntity.ok(new ApiResponseDto<Optional<AsientosVueloDto>>("Datos obtenidos", service.vuelosDisponibles(consultaAsientosDto), true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<Optional<AsientosVueloDto>>("Error en la consulta", null, false));
        }
    }

    @PostMapping("facturacion")
    public ResponseEntity<ApiResponseDto<Optional<PrecioVuelo>>> facturacion(@RequestBody FiltrarPrecio filtrarPrecio) {

        try {
            return ResponseEntity.ok(new ApiResponseDto<Optional<PrecioVuelo>>("Datos obtenidos", service.obtenerPrecio(filtrarPrecio), true));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(new ApiResponseDto<Optional<PrecioVuelo>>("Error en la consulta", null, false));
        }
    }

    @PutMapping("/estado-vuelo")
    public void updateScheduleState(@RequestParam Integer scheduleId) {
        service.actualizarAvion(scheduleId);
    }
}
