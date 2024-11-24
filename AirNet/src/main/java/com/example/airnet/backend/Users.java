// Users.java
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
public class Users {

    @EqualsAndHashCode.Include
    @Id
    private String username;
    private String password;
    private String email;
    private String phone;
}