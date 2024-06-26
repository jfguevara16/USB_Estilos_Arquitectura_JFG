package com.example.repository;

import java.util.HashMap;
import java.util.Map;

import com.example.model.User;

public class UserRepository {
    private Map<String, User> userDatabase = new HashMap<>();

    public User getUserById(String id) {
        return userDatabase.get(id);
    }

    public void saveUser(User user) {
        userDatabase.put(user.getId(), user);
    }
}

