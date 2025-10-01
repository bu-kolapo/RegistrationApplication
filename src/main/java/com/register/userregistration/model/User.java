package com.register.userregistration.model;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

public class User {
    private String email;
    private String password;
    private String name;
    private int age;
    private String phoneNumber;
    private String role;
    private LocalDateTime lastLoginTime;
    private String deviceId;
    private String sessionToken;
    private LocalDateTime sessionExpiryTime;

//    public User() {
//
//    }

    public User(String email, String password, String name, int age, String phoneNumber, String role) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.role = role;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getSessionToken() {
        return sessionToken;
    }
    public LocalDateTime getSessionExpiryTime() {
        return sessionExpiryTime;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
    public void setSessionExpiryTime(LocalDateTime sessionExpiryTime) {
        this.sessionExpiryTime = sessionExpiryTime;
    }


}
