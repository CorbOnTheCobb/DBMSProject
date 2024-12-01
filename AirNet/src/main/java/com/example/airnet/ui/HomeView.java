package com.example.airnet.ui;

import com.example.airnet.backend.*;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import java.util.stream.Collectors;

@Route("")
@AnonymousAllowed
public class HomeView extends VerticalLayout {

    public HomeView(AircraftService aircraftService, BaggageService baggageService, BookingService bookingService, FlightService flightService, RouteService routeService, UsersService usersService, PassengerService passengerService) {
        add(new H1("Home view"));

        TextField searchField = new TextField();
        searchField.setPlaceholder("Search...");
        searchField.setValueChangeMode(ValueChangeMode.EAGER);

        Grid<Aircraft> aircraftGrid = new Grid<>(Aircraft.class);
        aircraftGrid.setItems(aircraftService.findAll());
        aircraftGrid.setColumns("aircraft_code", "model", "total_seats");

        Grid<Baggage> baggageGrid = new Grid<>(Baggage.class);
        baggageGrid.setItems(baggageService.findAll());
        baggageGrid.setColumns("confirmation_number", "baggage_number", "type", "weight");

        Grid<Booking> bookingGrid = new Grid<>(Booking.class);
        bookingGrid.setItems(bookingService.findAll());
        bookingGrid.setColumns("confirmation_number", "flight_number", "seat_class", "booking_date", "checked_in");

        Grid<Flight> flightGrid = new Grid<>(Flight.class);
        flightGrid.setItems(flightService.findAll());
        flightGrid.setColumns("flight_number", "aircraft.aircraft_code", "route.route_id", "flight_date", "flight_status");

        Grid<com.example.airnet.backend.Route> routeGrid = new Grid<>(com.example.airnet.backend.Route.class);
        routeGrid.setItems(routeService.findAll());
        routeGrid.setColumns("route_id", "departure_city", "arrival_city", "departure_time", "arrival_time", "gate_number", "airline", "terminal");

        Grid<Users> usersGrid = new Grid<>(Users.class);
        usersGrid.setItems(usersService.findAll());
        usersGrid.setColumns("username", "email", "phone");

        Grid<Passenger> passengerGrid = new Grid<>(Passenger.class);
        passengerGrid.setItems(passengerService.findAll());
        passengerGrid.setColumns("passport_number", "user.username", "date_of_birth");

        searchField.addValueChangeListener(e -> {
            String filter = e.getValue().toLowerCase();
            aircraftGrid.setItems(aircraftService.findAll().stream()
                    .filter(aircraft -> aircraft.getAircraft_code().toLowerCase().contains(filter) ||
                            aircraft.getModel().toLowerCase().contains(filter) ||
                            String.valueOf(aircraft.getTotal_seats()).contains(filter))
                    .collect(Collectors.toList()));
            baggageGrid.setItems(baggageService.findAll().stream()
                    .filter(baggage -> baggage.getConfirmation_number().toLowerCase().contains(filter) ||
                            baggage.getBaggage_number().toLowerCase().contains(filter) ||
                            baggage.getType().toLowerCase().contains(filter) ||
                            String.valueOf(baggage.getWeight()).contains(filter))
                    .collect(Collectors.toList()));
            bookingGrid.setItems(bookingService.findAll().stream()
                    .filter(booking -> booking.getConfirmation_number().toLowerCase().contains(filter) ||
                            //booking.getPassport_number().toLowerCase().contains(filter) ||
                            booking.getFlight_number().toLowerCase().contains(filter) ||
                            booking.getSeat_class().toLowerCase().contains(filter) ||
                            booking.getBooking_date().toString().contains(filter) ||
                            String.valueOf(booking.getChecked_in()).contains(filter))
                    .collect(Collectors.toList()));
            flightGrid.setItems(flightService.findAll().stream()
                    .filter(flight -> flight.getFlight_number().toLowerCase().contains(filter) ||
                            flight.getAircraft().getAircraft_code().toLowerCase().contains(filter) ||
                            flight.getRoute().getRoute_id().toLowerCase().contains(filter) ||
                            flight.getFlight_date().toString().contains(filter) ||
                            flight.getFlight_status().toLowerCase().contains(filter))
                    .collect(Collectors.toList()));
            routeGrid.setItems(routeService.findAll().stream()
                    .filter(route -> route.getRoute_id().toLowerCase().contains(filter) ||
                            route.getDeparture_city().toLowerCase().contains(filter) ||
                            route.getArrival_city().toLowerCase().contains(filter) ||
                            route.getDeparture_time().toString().contains(filter) ||
                            route.getArrival_time().toString().contains(filter) ||
                            route.getGate_number().toLowerCase().contains(filter) ||
                            route.getAirline().toLowerCase().contains(filter) ||
                            route.getTerminal().toLowerCase().contains(filter))
                    .collect(Collectors.toList()));
        });

        add(searchField,
                new H2("Aircrafts"), aircraftGrid,
                new H2("Baggage"), baggageGrid,
                new H2("Bookings"), bookingGrid,
                new H2("Flights"), flightGrid,
                new H2("Routes"), routeGrid);
    }
}