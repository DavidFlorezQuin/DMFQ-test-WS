package com.aerolinea.amonic.Service;

import com.aerolinea.amonic.Entity.Countries;
import com.aerolinea.amonic.IService.ICountriesService;
import com.aerolinea.amonic.Repository.IBaseRepository;
import com.aerolinea.amonic.Repository.ICountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountriesService extends ABaseService<Countries> implements ICountriesService {

    @Autowired
    private ICountriesRepository repository;
    @Override
    protected IBaseRepository<Countries, Long> getRepository() {
        return repository;
    }
}
