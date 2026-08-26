package com.booleanuk.core;

import com.booleanuk.core.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void shouldReturnUserName_success() {
        User user = new User("John Doe");

        Assertions.assertEquals("John Doe", user.getName());
    }

    @Test
    public void shouldThrowIllegalArgumentExceptionWhenEnteringNullName() {
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, () -> new User(null));

        Assertions.assertEquals("Name can't be null or empty",ex.getMessage());
    }
}
