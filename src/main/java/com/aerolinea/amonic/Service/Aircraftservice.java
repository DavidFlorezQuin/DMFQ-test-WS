package com.aerolinea.amonic.Service;

import com.aerolinea.amonic.Entity.AirCrafts;
import com.aerolinea.amonic.IService.IAicraftsService;
import com.aerolinea.amonic.Repository.IAircraftsRepository;
import com.aerolinea.amonic.Repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Aircraftservice extends ABaseService<AirCrafts> implements IAicraftsService {

    @Autowired
    private IAircraftsRepository repository;

    @Override
    protected IBaseRepository<AirCrafts, Long> getRepository() {
        return repository;
    }
}
