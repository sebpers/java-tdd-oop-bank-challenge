package com.booleanuk.core;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class CustomerTest {

    Customer customer;
    CurrentAccount currentAccount = new CurrentAccount("Salary account", BigDecimal.ZERO);
    SavingsAccount savingsAccount = new SavingsAccount("House account", BigDecimal.ZERO);

    @BeforeEach
    public void init() {
        this.customer = new Customer("John Doe");

    }

    @Test
    public void createAccount_shouldCreateANewAccount_successfully() {
        Account createdAccount = customer.createAccount(currentAccount);

        Assertions.assertEquals(currentAccount, createdAccount);
        Assertions.assertNotNull(createdAccount);
    }

    @Test
    public void createAccount_shouldCreateANewSavingsAccount() {
        Account savingsAccount = customer.createAccount(this.savingsAccount);

        Assertions.assertEquals(currentAccount, this.savingsAccount);
        Assertions.assertNotNull(this.savingsAccount);
    }

    @Test
    public void getAllAccounts_shouldReturnAllAccounts_successfully() {
        customer.createAccount(currentAccount);
        customer.createAccount(currentAccount);

        List<Account> accounts = customer.getAccounts();

        Assertions.assertEquals(2, accounts.size());
    }

    @Test
    public void getAllAccounts_shouldReturnNoAccounts_successfully() {
        List<Account> accounts = customer.getAccounts();

        Assertions.assertEquals(0, accounts.size());
    }
}