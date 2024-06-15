package com.aerolinea.amonic.Controller;

import com.aerolinea.amonic.Entity.Countries;
import com.aerolinea.amonic.IService.ICountriesService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/countries")
public class CountriesController extends ABaseController<Countries, ICountriesService> {
    /**
     * Constructor for ABaseController.
     *
     * @param service    The service for the entity.
     */
    protected CountriesController(ICountriesService service) {
        super(service, "countries");
    }
}
