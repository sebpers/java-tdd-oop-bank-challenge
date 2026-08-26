package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AccountTest {

    @Test
    public void shouldSetAndGetName_successfully() {
        Account account = new Account("John Does savings", BigDecimal.ZERO) {};

        String name = account.getName();

        Assertions.assertEquals("John Does savings", name);
    }

    @Test
    public void shouldHaveABalance_successfully() {
        Account account = new Account("John Does savings", BigDecimal.ZERO) {};

        Assertions.assertEquals("John Does savings", account.getName());
        Assertions.assertEquals(BigDecimal.ZERO, account.getBalance());
    }
}
