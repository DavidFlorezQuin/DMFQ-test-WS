package com.aerolinea.amonic.Controller;

import com.aerolinea.amonic.Entity.AirCrafts;
import com.aerolinea.amonic.IService.IAicraftsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/aircraft")
public class AircraftController extends ABaseController<AirCrafts, IAicraftsService> {

    /**
     * Constructor for ABaseController.
     *
     * @param service    The service for the entity.
     */
    protected AircraftController(IAicraftsService service) {
        super(service, "aircraft");
    }
}
