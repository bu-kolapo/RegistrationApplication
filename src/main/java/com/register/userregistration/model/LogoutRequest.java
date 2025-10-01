package com.register.userregistration.model;

public class LogoutRequest {
    private String userId;
//    private String token;
    private String sessionToken;
    private String email;

    public LogoutRequest(String userId, String sessionToken) {
        this.userId = userId;
        this.sessionToken = sessionToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
