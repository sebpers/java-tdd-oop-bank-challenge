package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {

    @Test
    public void shouldSetAndGetName_successfully() {
        Account account = new Account("John Does savings") {};

        String name = account.getName();

        Assertions.assertEquals("John Does savings", name);
    }

}
