package com.example.airnet.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class AircraftService implements CrudListener<Aircraft> {

    private final AircraftRepository repository;

    @Override
    public Collection<Aircraft> findAll() {
        return repository.findAll();
    }

    @Override
    public Aircraft add(Aircraft aircraft) {
        return repository.save(aircraft);
    }

    @Override
    public Aircraft update(Aircraft aircraft) {
        return repository.save(aircraft);
    }

    @Override
    public void delete(Aircraft aircraft) {
        repository.delete(aircraft);
    }
}
