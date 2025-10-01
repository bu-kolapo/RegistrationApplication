package com.register.userregistration.model;

import java.time.LocalDateTime;

public class UserSessionInfo {
    private String name;
    private String email;
    private String role;
    private String phoneNumber;
    private String sessionToken;
    private LocalDateTime loginTime;
    private LocalDateTime sessionExpiryTime;

    public UserSessionInfo(String name, String email, String role, String phoneNumber,
                           String sessionToken, LocalDateTime loginTime, LocalDateTime sessionExpiryTime) {
        this.name = name;
        this.email = email;
        this.role = role;
        this.phoneNumber = phoneNumber;
        this.sessionToken = sessionToken;
        this.loginTime = loginTime;
        this.sessionExpiryTime = sessionExpiryTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public LocalDateTime getSessionExpiryTime() {
        return sessionExpiryTime;
    }

    public void setSessionExpiryTime(LocalDateTime sessionExpiryTime) {
        this.sessionExpiryTime = sessionExpiryTime;
    }
}



