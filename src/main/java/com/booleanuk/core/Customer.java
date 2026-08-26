package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{

    private List<Account> accounts;

    public Customer(String name) {
        super(name);
        this.accounts = new ArrayList<>();
    }

    public Account createAccount(Account account) {
        this.accounts.add(account);

        return account;
    }
}
