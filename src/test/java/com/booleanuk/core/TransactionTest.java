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
            BigDecimal.valueOf(100), // balance
            BigDecimal.valueOf(100), // credit
            BigDecimal.valueOf(500)); // debit
  }

  @Test
  public void shouldGetDate_successfully() {
        Assertions.assertEquals(DateFormatter.format(Instant.now()), transaction.getDate());
  }

  @Test
  public void shouldGetBalance_successfully() {
    Assertions.assertEquals(BigDecimal.valueOf(500), transaction.getBalance());
  }

}
