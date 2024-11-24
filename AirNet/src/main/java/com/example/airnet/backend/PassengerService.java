// PassengerService.java
package com.example.airnet.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class PassengerService implements CrudListener<Passenger> {

    private final PassengerRepository repository;

    @Override
    public Collection<Passenger> findAll() {
        return repository.findAll();
    }

    @Override
    public Passenger add(Passenger passenger) {
        return repository.save(passenger);
    }

    @Override
    public Passenger update(Passenger passenger) {
        return repository.save(passenger);
    }

    @Override
    public void delete(Passenger passenger) {
        repository.delete(passenger);
    }
}