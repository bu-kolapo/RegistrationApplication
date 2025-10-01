package com.register.userregistration.service;

import com.register.userregistration.model.LoginRequest;
import com.register.userregistration.model.LoginResponse;
import com.register.userregistration.model.LogoutRequest;
import com.register.userregistration.model.LogoutResponse;

public interface AuthenticationService {

    LoginResponse loginUser(LoginRequest loginRequest);
    LogoutResponse logoutUser(LogoutRequest logoutRequest);
}
