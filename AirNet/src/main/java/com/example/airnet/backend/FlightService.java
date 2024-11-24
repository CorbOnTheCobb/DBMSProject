package com.example.airnet.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class FlightService implements CrudListener<Flight> {

    private final FlightRepository repository;

    @Override
    public Collection<Flight> findAll() {
        return repository.findAll();
    }

    @Override
    public Flight add(Flight flight) {
        return repository.save(flight);
    }

    @Override
    public Flight update(Flight flight) {
        return repository.save(flight);
    }

    @Override
    public void delete(Flight flight) {
        repository.delete(flight);
    }
}
