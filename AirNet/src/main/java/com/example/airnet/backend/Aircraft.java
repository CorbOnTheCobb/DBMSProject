package com.example.airnet.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Aircraft {

    @EqualsAndHashCode.Include
    @Id

    private String aircraft_code;
    private String model;
    private Integer total_seats;

}
