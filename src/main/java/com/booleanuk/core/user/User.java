package com.booleanuk.core.user;

public class User {
    private String name;

    public User(String name) {
        setName(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isBlank()) {
            throw new IllegalArgumentException("Name can't be null or empty");
        }

        this.name = name;
    }
}
