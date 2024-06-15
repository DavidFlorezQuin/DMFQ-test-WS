package com.aerolinea.amonic.Controller;


import com.aerolinea.amonic.Entity.Offices;
import com.aerolinea.amonic.IService.IOfficeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/office")
public class OfficeController extends ABaseController<Offices, IOfficeService>{
    /**
     * Constructor for ABaseController.
     *
     * @param service    The service for the entity.
     */
    protected OfficeController(IOfficeService service) {
        super(service, "Office");
    }
}
