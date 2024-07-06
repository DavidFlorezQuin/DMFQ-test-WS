package com.aerolinea.amonic.Repository;

import com.aerolinea.amonic.Entity.Routes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IRouteRepository extends IBaseRepository<Routes, Long> {

}
