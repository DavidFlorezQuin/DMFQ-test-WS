package com.aerolinea.amonic.Service;

import com.aerolinea.amonic.Entity.Routes;
import com.aerolinea.amonic.IService.IRoutesService;
import com.aerolinea.amonic.Repository.IBaseRepository;
import com.aerolinea.amonic.Repository.IRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class RoutesService extends ABaseService<Routes> implements IRoutesService {

    @Autowired
    private IRouteRepository repository;
    @Override
    protected IBaseRepository<Routes, Long> getRepository() {
        return repository;
    }
}
