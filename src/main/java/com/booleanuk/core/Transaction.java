package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.Instant;

public class Transaction {

    private Instant date;
    private BigDecimal balance;
    private BigDecimal debit;
    private BigDecimal credit;

    public Transaction(
            Instant date, BigDecimal credit, BigDecimal debit, BigDecimal balance
    ) {
        this.date = date;
        this.balance = balance;
        this.debit = debit;
        this.credit = credit;
    }

    public Instant getDate() {
        return this.date;
    }

    public BigDecimal getCredit() {
        return this.credit;
    }

    public BigDecimal getDebit() {
        return this.debit;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

}
