package com.aerolinea.amonic.Controller;

import com.aerolinea.amonic.Entity.Routes;
import com.aerolinea.amonic.IService.IRoutesService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
