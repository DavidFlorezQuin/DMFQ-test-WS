package com.aerolinea.amonic.Repository;

import com.aerolinea.amonic.Entity.Countries;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountriesRepository extends IBaseRepository<Countries, Long> {
}
