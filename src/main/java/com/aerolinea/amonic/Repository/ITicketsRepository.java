package com.aerolinea.amonic.Repository;

import com.aerolinea.amonic.Entity.Tickets;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketsRepository extends IBaseRepository<Tickets, Long> {
}
