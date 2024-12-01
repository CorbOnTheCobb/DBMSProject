package com.example.airnet.ui;

import com.example.airnet.backend.*;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.vaadin.crudui.crud.impl.GridCrud;

import java.util.stream.Collectors;

@Route("admin")
@AnonymousAllowed
public class AdminView extends VerticalLayout {

    public AdminView(AircraftService aircraftService, BaggageService baggageService, BookingService bookingService, FlightService flightService, RouteService routeService, UsersService usersService, PassengerService passengerService) {
        add(new H1("Admin view"));

        TextField searchField = new TextField();
        searchField.setPlaceholder("Search...");
        searchField.setValueChangeMode(ValueChangeMode.EAGER);

        GridCrud<Aircraft> aircraftCrud = new GridCrud<>(Aircraft.class);
        aircraftCrud.getGrid().setColumns("aircraft_code", "model", "total_seats");
        aircraftCrud.setCrudListener(aircraftService);

        GridCrud<Baggage> baggageCrud = new GridCrud<>(Baggage.class);
        baggageCrud.getGrid().setColumns("confirmation_number", "baggage_number", "type", "weight");
        baggageCrud.setCrudListener(baggageService);

        GridCrud<Booking> bookingCrud = new GridCrud<>(Booking.class);
        bookingCrud.getGrid().setColumns("confirmation_number", "passport_number", "flight_number", "seat_class", "booking_date", "checked_in");
        bookingCrud.setCrudListener(bookingService);

        GridCrud<Flight> flightCrud = new GridCrud<>(Flight.class);
        flightCrud.getGrid().setColumns("flight_number", "aircraft.aircraft_code", "route.route_id", "flight_date", "flight_status");
        flightCrud.setCrudListener(flightService);

        GridCrud<com.example.airnet.backend.Route> routeCrud = new GridCrud<>(com.example.airnet.backend.Route.class);
        routeCrud.getGrid().setColumns("route_id", "departure_city", "arrival_city", "departure_time", "arrival_time", "gate_number", "airline", "terminal");
        routeCrud.setCrudListener(routeService);

        GridCrud<Users> usersCrud = new GridCrud<>(Users.class);
        usersCrud.getGrid().setColumns("username", "email", "phone");
        usersCrud.setCrudListener(usersService);

        GridCrud<Passenger> passengerCrud = new GridCrud<>(Passenger.class);
        passengerCrud.getGrid().setColumns("passport_number", "user.username", "date_of_birth");
        passengerCrud.setCrudListener(passengerService);

        searchField.addValueChangeListener(e -> {
            String filter = e.getValue().toLowerCase();
            aircraftCrud.getGrid().setItems(aircraftService.findAll().stream()
                    .filter(aircraft -> aircraft.getAircraft_code().toLowerCase().contains(filter) ||
                            aircraft.getModel().toLowerCase().contains(filter) ||
                            String.valueOf(aircraft.getTotal_seats()).contains(filter))
                    .collect(Collectors.toList()));
            baggageCrud.getGrid().setItems(baggageService.findAll().stream()
                    .filter(baggage -> baggage.getConfirmation_number().toLowerCase().contains(filter) ||
                            baggage.getBaggage_number().toLowerCase().contains(filter) ||
                            baggage.getType().toLowerCase().contains(filter) ||
                            String.valueOf(baggage.getWeight()).contains(filter))
                    .collect(Collectors.toList()));
            bookingCrud.getGrid().setItems(bookingService.findAll().stream()
                    .filter(booking -> booking.getConfirmation_number().toLowerCase().contains(filter) ||
                            booking.getPassport_number().toLowerCase().contains(filter) ||
                            booking.getFlight_number().toLowerCase().contains(filter) ||
                            booking.getSeat_class().toLowerCase().contains(filter) ||
                            booking.getBooking_date().toString().contains(filter) ||
                            String.valueOf(booking.getChecked_in()).contains(filter))
                    .collect(Collectors.toList()));
            flightCrud.getGrid().setItems(flightService.findAll().stream()
                    .filter(flight -> flight.getFlight_number().toLowerCase().contains(filter) ||
                            flight.getAircraft().getAircraft_code().toLowerCase().contains(filter) ||
                            flight.getRoute().getRoute_id().toLowerCase().contains(filter) ||
                            flight.getFlight_date().toString().contains(filter) ||
                            flight.getFlight_status().toLowerCase().contains(filter))
                    .collect(Collectors.toList()));
            routeCrud.getGrid().setItems(routeService.findAll().stream()
                    .filter(route -> route.getRoute_id().toLowerCase().contains(filter) ||
                            route.getDeparture_city().toLowerCase().contains(filter) ||
                            route.getArrival_city().toLowerCase().contains(filter) ||
                            route.getDeparture_time().toString().contains(filter) ||
                            route.getArrival_time().toString().contains(filter) ||
                            route.getGate_number().toLowerCase().contains(filter) ||
                            route.getAirline().toLowerCase().contains(filter) ||
                            route.getTerminal().toLowerCase().contains(filter))
                    .collect(Collectors.toList()));
            usersCrud.getGrid().setItems(usersService.findAll().stream()
                    .filter(user -> user.getUsername().toLowerCase().contains(filter) ||
                            user.getEmail().toLowerCase().contains(filter) ||
                            user.getPhone().toLowerCase().contains(filter))
                    .collect(Collectors.toList()));
            passengerCrud.getGrid().setItems(passengerService.findAll().stream()
                    .filter(passenger -> passenger.getPassport_number().toLowerCase().contains(filter) ||
                            passenger.getUser().getUsername().toLowerCase().contains(filter) ||
                            passenger.getDate_of_birth().toString().contains(filter))
                    .collect(Collectors.toList()));
        });

        add(searchField,
                new H2("Aircrafts"), aircraftCrud,
                new H2("Baggage"), baggageCrud,
                new H2("Bookings"), bookingCrud,
                new H2("Flights"), flightCrud,
                new H2("Routes"), routeCrud,
                new H2("Users"), usersCrud,
                new H2("Passengers"), passengerCrud);
    }
}