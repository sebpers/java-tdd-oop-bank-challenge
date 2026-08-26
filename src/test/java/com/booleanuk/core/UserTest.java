package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void shouldReturnUserName_success() {
        User user = new User("John Doe");

        Assertions.assertEquals("John Doe", user.getName());
    }
}
