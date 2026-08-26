package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.Instant;

public class Transaction {

    private final Instant date;
    private final BigDecimal balance;
    private final BigDecimal debit;
    private final BigDecimal credit;

    public Transaction(
            Instant date, BigDecimal credit, BigDecimal debit, BigDecimal balance
    ) {
        this.date = date;
        this.balance = balance;
        this.debit = debit;
        this.credit = credit;
    }

    public String getDate() {
        return DateFormatter.format(this.date);
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
