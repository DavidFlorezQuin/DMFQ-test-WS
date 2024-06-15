package com.aerolinea.amonic.Controller;

import com.aerolinea.amonic.Entity.CabinTypes;
import com.aerolinea.amonic.IService.ICabinTypesService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/cabintypes")
public class CabinTypesController extends ABaseController<CabinTypes, ICabinTypesService> {

    /**
     * Constructor for ABaseController.
     *
     * @param service    The service for the entity.
     */
    protected CabinTypesController(ICabinTypesService service) {
        super(service, "CabinTypes");
    }
}
