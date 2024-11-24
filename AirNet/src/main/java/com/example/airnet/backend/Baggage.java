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
public class Baggage {

    @EqualsAndHashCode.Include
    @Id

    private String confirmation_number;
    private String baggage_number;
    private String type;
    private Integer weight;

}
