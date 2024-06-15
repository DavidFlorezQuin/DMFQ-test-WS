package com.aerolinea.amonic.Service;

import com.aerolinea.amonic.Entity.Tickets;
import com.aerolinea.amonic.IService.ITicketsService;
import com.aerolinea.amonic.Repository.IBaseRepository;
import com.aerolinea.amonic.Repository.ITicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketsService extends ABaseService<Tickets> implements ITicketsService {
    @Autowired
    private ITicketsRepository repository;
    @Override
    protected IBaseRepository<Tickets, Long> getRepository() {
        return repository;
    }
}
