package com.aerolinea.amonic.Service;

import com.aerolinea.amonic.Entity.Offices;
import com.aerolinea.amonic.IService.IOfficeService;
import com.aerolinea.amonic.Repository.IBaseRepository;
import com.aerolinea.amonic.Repository.IOfficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfficesService extends ABaseService<Offices> implements IOfficeService {

    @Autowired
    private IOfficeRepository repository;

    @Override
    protected IBaseRepository<Offices, Long> getRepository() {
        return repository;
    }
}
