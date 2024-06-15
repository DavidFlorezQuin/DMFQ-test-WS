package com.aerolinea.amonic.Controller;

import com.aerolinea.amonic.Entity.Roles;
import com.aerolinea.amonic.IService.IRoleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/roles")
public class RolesController extends ABaseController<Roles, IRoleService> {
    /**
     * Constructor for ABaseController.
     *
     * @param service    The service for the entity.
     */
    protected RolesController(IRoleService service) {
        super(service, "roles");
    }
}
