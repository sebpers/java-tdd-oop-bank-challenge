package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Instant;


public class TransactionTest {

  private Transaction transaction;

  @BeforeEach
  public void init() {
    this.transaction = new Transaction(
            Instant.now(),
            BigDecimal.valueOf(500),
            BigDecimal.valueOf(100),
            BigDecimal.valueOf(100));
  }

  @Test
  public void shouldGetDate_successfully() {
        Assertions.assertEquals(DateFormatter.format(Instant.now()), transaction.getDate());
  }


}
