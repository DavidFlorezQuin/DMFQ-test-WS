package com.aerolinea.amonic.Service;

import com.aerolinea.amonic.Entity.CabinTypes;
import com.aerolinea.amonic.IService.ICabinTypesService;
import com.aerolinea.amonic.Repository.IBaseRepository;
import com.aerolinea.amonic.Repository.ICabinTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CabinTypesService extends ABaseService<CabinTypes> implements ICabinTypesService {

    @Autowired
    private ICabinTypesRepository repository;
    @Override
    protected IBaseRepository<CabinTypes, Long> getRepository() {
        return repository;
    }
}
