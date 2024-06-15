package com.aerolinea.amonic.Controller;

import com.aerolinea.amonic.Entity.Tickets;
import com.aerolinea.amonic.IService.IBaseService;
import com.aerolinea.amonic.IService.ITicketsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/tickets")
public class TicketsController extends ABaseController<Tickets, ITicketsService> {


    /**
     * Constructor for ABaseController.
     *
     * @param service    The service for the entity.
     */
    protected TicketsController(ITicketsService service) {
        super(service, "tickets");
    }
}