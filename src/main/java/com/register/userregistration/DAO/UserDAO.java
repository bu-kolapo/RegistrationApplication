package com.register.userregistration.DAO;

import com.register.userregistration.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static java.time.LocalDateTime.*;
@Repository
public class UserDAO {
    private final Map<String, User> users = new HashMap<>();
    @PersistenceContext
    private EntityManager entityManager;


    public UserDAO() {
        // Initialize with some demo users
        initializeDemoUsers();
    }

    private void initializeDemoUsers() {
        // Demo users for testing
        users.put("kafayah@mycompany.com", new User("kafayah@mycompany.com", "password123", "Kafayah Wahab", 35, "+1234567890", "USER"));
        users.put("jane.smith@email.com", new User("jane.smith@email.com", "password456", "Jane Smith", 25, "+1234567891", "USER"));
        users.put("admin@email.com", new User("admin@email.com", "admin123", "Admin User", 45, "+1234567892", "ADMIN"));
    }
    public User findById(Long userId) {
        return entityManager.find(User.class, userId);
    }
    public User findByEmail(String email) {
        return users.get(email);
    }

    public boolean validatePassword(User user, String password) {
        return user != null && user.getPassword().equals(password);
    }

    public boolean isSessionValid(User user) {
        if (user.getLastLoginTime() == null) {
            return false;
        }
        return user.getLastLoginTime().plusMinutes(10).isAfter(now());
    }

    public void updateUserSession(User user, String deviceId, String sessionToken) {
        user.setDeviceId(deviceId);
        user.setSessionToken(sessionToken);
        user.setLastLoginTime(now());
    }

    public void invalidateUserSession(User user) {

        user.setSessionToken(null);
        user.setLastLoginTime(null);
        user.setSessionExpiryTime(null);

    }

    //anytime a user logs in,call the generateSessionToken method to generates a 128-bit random value

    public String generateSessionToken() {
        return UUID.randomUUID().toString();

    }

//    public boolean validateSessionToken(User user, String sessionToken) {
//        if (user.getSessionToken() == null || !user.getSessionToken().equals(sessionToken)) {
//            return false;
//        }
//        // Check if the session has expired
//        return LocalDateTime.now().isBefore(user.getSessionExpiryTime());
//    }

    public boolean validateSessionToken(User user, String token) {
        if (user == null) return false;
        if (token == null || user.getSessionToken() == null) return false;

        // check expiry is set
        if (user.getSessionExpiryTime() == null) return false;

        // check token match & not expired
        return token.equals(user.getSessionToken())
                && LocalDateTime.now().isBefore(user.getSessionExpiryTime());
    }



}

