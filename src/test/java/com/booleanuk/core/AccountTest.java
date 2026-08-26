package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AccountTest {

    private Account account;

    @BeforeEach
    public void init() {
        this.account = new Account("John Does savings", BigDecimal.ZERO) {};
    }

    @Test
    public void shouldSetAndGetName_successfully() {
        String name = account.getName();

        Assertions.assertEquals("John Does savings", name);
    }

    @Test
    public void shouldHaveABalance_successfully() {
        Assertions.assertEquals("John Does savings", account.getName());
        Assertions.assertEquals(BigDecimal.ZERO, account.getBalance());
    }

    @Test
    public void deposit_shouldDeposit_successfully() {
        account.deposit(BigDecimal.valueOf(100));

        BigDecimal balance = account.getBalance();

        Assertions.assertEquals(BigDecimal.valueOf(100), balance);
    }
}
