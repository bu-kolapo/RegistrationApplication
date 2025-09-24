package com.register.userregistration.service;

import com.register.userregistration.dto.RegistrationRequest;
import com.register.userregistration.model.Registration;

public interface RegistrationService {

    Registration registerUser(RegistrationRequest registrationRequest);
}
