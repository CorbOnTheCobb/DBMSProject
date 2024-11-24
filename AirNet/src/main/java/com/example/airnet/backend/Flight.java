package com.example.airnet.backend;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Flight {

    @EqualsAndHashCode.Include
    @Id
    private String flight_number;

    @ManyToOne
    @JoinColumn(name = "aircraft_code")
    private Aircraft aircraft;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;

    private Date flight_date;
    private String flight_status;
}