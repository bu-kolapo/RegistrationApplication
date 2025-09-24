package com.register.userregistration.service;

import com.register.userregistration.dto.RegistrationRequest;
import com.register.userregistration.model.Registration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Random;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private static final Logger log = LoggerFactory.getLogger(RegistrationServiceImpl.class);
    private static final List<String> BLOCKED_DOMAINS = List.of("gmail.com", "yahoo.com", "outlook.com");

    @Override
    public Registration  registerUser(RegistrationRequest registrationRequest) {
        validateAge(registrationRequest.getDateOfBirth());
        validateCorporateEmail(registrationRequest.getEmail());

        Registration registration = new Registration(
                registrationRequest.getEmail(),
                registrationRequest.getFirstName(),
                registrationRequest.getLastName(),
                registrationRequest.getPassword(),
                registrationRequest.getDateOfBirth()
        );

        // Persist user (stubbed)
        log.info("User [{} {}] registered with email [{}]", registrationRequest.getEmail());

        // Generate random transactions
        generateTransactions( 200);

        // Send email (stubbed with logging)
        log.info("Sent registration email to {}", registrationRequest.getEmail());
        return registration;
    }
    private void validateAge(LocalDate dob) {
        if (Period.between(dob, LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("User must be at least 18 years old.");
        }
    }

    private void validateCorporateEmail(String email) {
        String domain = email.substring(email.indexOf('@') + 1).toLowerCase();
        if (BLOCKED_DOMAINS.contains(domain)) {
            throw new IllegalArgumentException("Registration requires a corporate email address.");
        }
    }
            private void generateTransactions(int count) {
                Random random = new Random();
                for (int i = 0; i < count; i++) {
                    log.debug("Generated transaction #{} with amount {}", i + 1, random.nextDouble() * 1000);
                }
            }
        }








