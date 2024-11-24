package com.example.airnet.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

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
public class Route {

    @EqualsAndHashCode.Include
    @Id

    private String route_id;
    private String departure_city;
    private String arrival_city;
    private Time departure_time;
    private Time arrival_time;
    private String gate_number;
    private String airline;
    private String terminal;

}
