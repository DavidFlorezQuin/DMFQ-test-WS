package com.aerolinea.amonic.Service;

import com.aerolinea.amonic.Entity.Users;
import com.aerolinea.amonic.IService.IUsersService;
import com.aerolinea.amonic.Repository.IBaseRepository;
import com.aerolinea.amonic.Repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService extends ABaseService<Users> implements IUsersService{
    @Autowired
    private IUsersRepository repository;
    @Override
    protected IBaseRepository<Users, Long> getRepository() {
        return repository;
    }
}
