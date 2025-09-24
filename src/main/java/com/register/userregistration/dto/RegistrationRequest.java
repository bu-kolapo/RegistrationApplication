package com.register.userregistration.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;


//@Data
//@Getter
//@Setter
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
   public class RegistrationRequest {

        private String  email;

        private String firstName;

        private String lastName;

        private String password;

        private LocalDate dateOfBirth;

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getFirstName() {
          return firstName;
     }

     public void setFirstName(String firstName) {
          this.firstName = firstName;
     }

     public String getLastName() {
          return lastName;
     }

     public void setLastName(String lastName) {
          this.lastName = lastName;
     }

     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     public LocalDate getDateOfBirth() {
          return dateOfBirth;
     }

     public void setDateOfBirth(LocalDate dateOfBirth) {
          this.dateOfBirth = dateOfBirth;
     }
}




