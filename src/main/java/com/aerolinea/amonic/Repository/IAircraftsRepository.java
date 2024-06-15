package com.aerolinea.amonic.Repository;

import com.aerolinea.amonic.Entity.ABaseEntity;
import com.aerolinea.amonic.Entity.AirCrafts;
import org.springframework.stereotype.Repository;

@Repository
public interface IAircraftsRepository extends IBaseRepository<AirCrafts, Long> {
}
