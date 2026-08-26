package com.booleanuk.core;

import com.booleanuk.core.account.SavingsAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class SavingsAccountTest {

    SavingsAccount savingsAccount;

    @BeforeEach
    public void init() {
        this.savingsAccount = new SavingsAccount("John Doe", BigDecimal.ZERO);
    }

    @Test
    public void getName() {
        String name = savingsAccount.getName();

        Assertions.assertEquals("John Doe", name);
    }

    @Test
    public void getBalance() {
        BigDecimal balance = savingsAccount.getBalance();

        Assertions.assertEquals(BigDecimal.valueOf(0), balance);
    }
}
