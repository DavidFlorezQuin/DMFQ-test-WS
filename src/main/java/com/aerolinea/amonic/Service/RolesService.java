package com.aerolinea.amonic.Service;

import com.aerolinea.amonic.Entity.Roles;
import com.aerolinea.amonic.IService.IRoleService;
import com.aerolinea.amonic.Repository.IBaseRepository;
import com.aerolinea.amonic.Repository.IRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService extends ABaseService<Roles> implements IRoleService {

    @Autowired
    private IRolesRepository repository;
    @Override
    protected IBaseRepository<Roles, Long> getRepository() {
        return repository;
    }
}
