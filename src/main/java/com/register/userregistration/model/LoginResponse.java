package com.register.userregistration.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
public class LoginResponse {
    private String message;
    private boolean success;
    private UserSessionInfo userInfo;

    public LoginResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public LoginResponse(String message, boolean success, UserSessionInfo userInfo) {
        this.message = message;
        this.success = success;
        this.userInfo = userInfo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public UserSessionInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserSessionInfo userInfo) {
        this.userInfo = userInfo;
    }


}
