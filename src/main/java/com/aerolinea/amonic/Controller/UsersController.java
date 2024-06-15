package com.aerolinea.amonic.Controller;


import com.aerolinea.amonic.Entity.Users;
import com.aerolinea.amonic.IService.IUsersService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/users")
public class UsersController extends ABaseController<Users, IUsersService>{
    /**
     * Constructor for ABaseController.
     *
     * @param service    The service for the entity.
     */
    protected UsersController(IUsersService service) {
        super(service, "Users");
    }
}
