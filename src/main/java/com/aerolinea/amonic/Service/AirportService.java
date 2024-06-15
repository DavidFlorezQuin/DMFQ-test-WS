package com.aerolinea.amonic.Service;

import com.aerolinea.amonic.Entity.AirPorts;
import com.aerolinea.amonic.IService.IAirportsService;
import com.aerolinea.amonic.Repository.IAirportsRepository;
import com.aerolinea.amonic.Repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService extends ABaseService<AirPorts> implements IAirportsService {
    @Autowired
    private IAirportsRepository repository;

    @Override
    protected IBaseRepository<AirPorts, Long> getRepository() {
        return repository;
    }
}
