package com.example.airnet.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class BaggageService implements CrudListener<Baggage> {

    private final BaggageRepository repository;

    @Override
    public Collection<Baggage> findAll() {
        return repository.findAll();
    }

    @Override
    public Baggage add(Baggage baggage) {
        return repository.save(baggage);
    }

    @Override
    public Baggage update(Baggage baggage) {
        return repository.save(baggage);
    }

    @Override
    public void delete(Baggage baggage) {
        repository.delete(baggage);
    }
}
