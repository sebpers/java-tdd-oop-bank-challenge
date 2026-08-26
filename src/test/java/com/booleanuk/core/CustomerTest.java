package com.booleanuk.core;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {

    @Test
    public void createAccount_shouldCreateANewAccount_successfully() {
        Customer customer = new Customer("John Doe");
        CurrentAccount currentAccount = new CurrentAccount();

        Account createdAccount = customer.createAccount(currentAccount);

        Assertions.assertEquals(currentAccount, createdAccount);
        Assertions.assertNotNull(createdAccount);
    }

}