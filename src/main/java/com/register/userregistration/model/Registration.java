package com.register.userregistration.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Registration {

    private String  email;
    private String firstName;
    private String lastName;
    private String password;
    private LocalDate dateOfBirth;
}
