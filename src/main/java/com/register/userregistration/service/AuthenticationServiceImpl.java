package com.register.userregistration.service;

import com.register.userregistration.DAO.UserDAO;
import com.register.userregistration.model.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserDAO userdao;

    public AuthenticationServiceImpl(UserDAO userdao) {
        this.userdao = userdao;
    }

    @Override
    public LoginResponse loginUser(LoginRequest loginRequest) {
        User user = userdao.findByEmail(loginRequest.getEmail());
        if (user == null || !userdao.validatePassword(user, loginRequest.getPassword())) {
            LoginResponse response = new LoginResponse("Invalid email or password", false);
            return response;

        }

        // Check for existing session on another device
        if (user.getDeviceId() != null && !user.getDeviceId().equals(loginRequest.getDeviceId())) {
            if (userdao.isSessionValid(user)) {
                if (user.getAge() <= 40) {
                    LoginResponse response = new LoginResponse("You are already logged in from another device. Please logout from the other device first.", false);

                    return response;
                } else {
                    userdao.invalidateUserSession(user);
                }
            }
        }

        // Generate new session token and update session

        LocalDateTime now = LocalDateTime.now();
        String sessionToken = userdao.generateSessionToken();

        user.setSessionToken(sessionToken);
        user.setLastLoginTime(now);
        user.setSessionExpiryTime(now.plusMinutes(10));

        userdao.updateUserSession(user, loginRequest.getDeviceId(), sessionToken);
        UserSessionInfo userInfo = new UserSessionInfo(
                user.getName(),
                user.getEmail(),
                user.getRole(),
                user.getPhoneNumber(),
                sessionToken,
                user.getLastLoginTime(),
                user.getSessionExpiryTime()
        );

        LoginResponse loginResponse = new LoginResponse("Login successful", true, userInfo);
        return loginResponse;
    }


        @Override
        public LogoutResponse logoutUser(LogoutRequest logoutRequest) {
            System.out.println("Logout attempt:");
            System.out.println("  Request email: " + logoutRequest.getEmail());


            if (logoutRequest.getEmail() == null || logoutRequest.getSessionToken() == null) {
                return new LogoutResponse("Email and token required", false);
            }

            User user = userdao.findByEmail(logoutRequest.getEmail());
            if (user == null) {
                return new LogoutResponse("User not found", false);
            }

            // validate session token
            if (!userdao.validateSessionToken(user, logoutRequest.getSessionToken())) {
                System.out.println(">>> Debug: Stored user token = " + user.getSessionToken());
                System.out.println(">>> Debug: Stored expiry = " + user.getSessionExpiryTime());

                return new LogoutResponse("Invalid or expired session token", false);

            }

            // invalidate the session
            userdao.invalidateUserSession(user);

            // keep response minimal
            return new LogoutResponse("Logout successful", true);
        }




}

