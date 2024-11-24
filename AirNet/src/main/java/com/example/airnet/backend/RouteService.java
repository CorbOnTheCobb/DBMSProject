package com.example.airnet.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class RouteService implements CrudListener<Route> {

    private final RouteRepository repository;

    @Override
    public Collection<Route> findAll() {
        return repository.findAll();
    }

    @Override
    public Route add(Route route) {
        return repository.save(route);
    }

    @Override
    public Route update(Route route) {
        return repository.save(route);
    }

    @Override
    public void delete(Route route) {
        repository.delete(route);
    }
}
