// AdminView.java
package com.example.airnet.ui;

import com.example.airnet.backend.*;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.RolesAllowed;
import org.vaadin.crudui.crud.impl.GridCrud;

@Route("admin")
@RolesAllowed("ADMIN")
public class AdminView extends VerticalLayout {

    public AdminView(AircraftService aircraftService, BaggageService baggageService, BookingService bookingService, FlightService flightService, RouteService routeService, UsersService usersService, PassengerService passengerService) {
        var aircraftCrud = new GridCrud<>(Aircraft.class, aircraftService);
        aircraftCrud.getGrid().setColumns("aircraft_code", "model", "total_seats");
        aircraftCrud.getCrudFormFactory().setVisibleProperties("aircraft_code", "model", "total_seats");

        var baggageCrud = new GridCrud<>(Baggage.class, baggageService);
        baggageCrud.getGrid().setColumns("confirmation_number", "baggage_number", "type", "weight");
        baggageCrud.getCrudFormFactory().setVisibleProperties("confirmation_number", "baggage_number", "type", "weight");

        var bookingCrud = new GridCrud<>(Booking.class, bookingService);
        bookingCrud.getGrid().setColumns("confirmation_number", "passport_number", "flight_number", "seat_number", "seat_class", "booking_date", "checked_in");
        bookingCrud.getCrudFormFactory().setVisibleProperties("confirmation_number", "passport_number", "flight_number", "seat_number", "seat_class", "booking_date", "checked_in");

        var flightCrud = new GridCrud<>(Flight.class, flightService);
        flightCrud.getGrid().setColumns("flight_number", "aircraft.aircraft_code", "route.route_id", "flight_date", "flight_status");
        flightCrud.getCrudFormFactory().setVisibleProperties("flight_number", "aircraft", "route", "flight_date", "flight_status");

        var routeCrud = new GridCrud<>(com.example.airnet.backend.Route.class, routeService);
        routeCrud.getGrid().setColumns("route_id", "departure_city", "arrival_city", "departure_time", "arrival_time", "gate_number", "airline", "terminal");
        routeCrud.getCrudFormFactory().setVisibleProperties("route_id", "departure_city", "arrival_city", "departure_time", "arrival_time", "gate_number", "airline", "terminal");

        var usersCrud = new GridCrud<>(Users.class, usersService);
        usersCrud.getGrid().setColumns("username", "email", "phone");
        usersCrud.getCrudFormFactory().setVisibleProperties("username", "password", "email", "phone");

        var passengerCrud = new GridCrud<>(Passenger.class, passengerService);
        passengerCrud.getGrid().setColumns("passport_number", "user.username", "date_of_birth");
        passengerCrud.getCrudFormFactory().setVisibleProperties("passport_number", "user", "date_of_birth");

        add(
                new H1("View Tables"),
                new H2("Aircrafts"),
                aircraftCrud,
                new H2("Baggage"),
                baggageCrud,
                new H2("Bookings"),
                bookingCrud,
                new H2("Flights"),
                flightCrud,
                new H2("Routes"),
                routeCrud,
                new H2("Users"),
                usersCrud,
                new H2("Passengers"),
                passengerCrud
        );
    }
}