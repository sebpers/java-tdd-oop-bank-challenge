package com.booleanuk.core;

public abstract class Account {

    private String name;

    public Account(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
