package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CurrentAccountTest {

    CurrentAccount currenAccount;

    @BeforeEach
    public void init() {
        this.currenAccount = new CurrentAccount("John Doe", BigDecimal.ZERO);
    }

    @Test
    public void getName() {
        String name = currenAccount.getName();

        Assertions.assertEquals("John Doe", name);
    }

    @Test
    public void getBalance() {
        BigDecimal balance = currenAccount.getBalance();

        Assertions.assertEquals(BigDecimal.valueOf(0), balance);
    }
}
