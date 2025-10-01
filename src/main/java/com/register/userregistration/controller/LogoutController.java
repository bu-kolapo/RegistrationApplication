package com.register.userregistration.controller;

import com.register.userregistration.model.LogoutRequest;
import com.register.userregistration.model.LogoutResponse;
import com.register.userregistration.service.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class LogoutController {

    private final AuthenticationService authenticationService;

    public LogoutController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/logout")
    public ResponseEntity<LogoutResponse> logoutUser(@RequestBody LogoutRequest logoutRequest) {
        LogoutResponse response = authenticationService.logoutUser(logoutRequest);
        if (response.isSuccess()) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
