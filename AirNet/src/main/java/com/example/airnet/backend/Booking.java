package com.example.airnet.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

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
public class Booking {

    @EqualsAndHashCode.Include
    @Id

    private String confirmation_number;
    private String passport_number;
    private String flight_number;
    private String seat_number;
    private String seat_class;
    private Date booking_date;
    private Integer checked_in;

}
