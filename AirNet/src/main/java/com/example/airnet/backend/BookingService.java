package com.example.airnet.backend;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class BookingService implements CrudListener<Booking> {

    private final BookingRepository repository;

    @Override
    public Collection<Booking> findAll() {
        return repository.findAll();
    }

    @Override
    public Booking add(Booking booking) {
        return repository.save(booking);
    }

    @Override
    public Booking update(Booking booking) {
        return repository.save(booking);
    }

    @Override
    public void delete(Booking booking) {
        repository.delete(booking);
    }
}
