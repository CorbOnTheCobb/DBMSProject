// UsersService.java
package com.example.airnet.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UsersService implements CrudListener<Users> {

    private final UsersRepository repository;

    @Override
    public Collection<Users> findAll() {
        return repository.findAll();
    }

    @Override
    public Users add(Users user) {
        return repository.save(user);
    }

    @Override
    public Users update(Users user) {
        return repository.save(user);
    }

    @Override
    public void delete(Users user) {
        repository.delete(user);
    }
}