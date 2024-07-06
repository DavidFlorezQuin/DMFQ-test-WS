package com.aerolinea.amonic.Controller;

import com.aerolinea.amonic.Dto.ApiResponseDto;
import com.aerolinea.amonic.Dto.BuscarRutas;
import com.aerolinea.amonic.Entity.Routes;
import com.aerolinea.amonic.IService.IRoutesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/routes")
public class RoutesController extends ABaseController<Routes, IRoutesService> {
    /**
     * Constructor for ABaseController.
     *
     * @param service    The service for the entity.
     */
    protected RoutesController(IRoutesService service) {
        super(service, "routes");
    }


}
