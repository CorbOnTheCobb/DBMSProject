// Passenger.java
package com.example.airnet.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Passenger {

    @EqualsAndHashCode.Include
    @Id
    private String passport_number;

    @ManyToOne
    @JoinColumn(name = "username")
    private Users user;

    private Date date_of_birth;
}