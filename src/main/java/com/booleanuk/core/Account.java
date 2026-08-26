package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    private String name;
    private BigDecimal balance;
    private final List<Transaction> transactions;

    public Account(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void deposit(BigDecimal money) {
        if (money.compareTo(BigDecimal.ZERO) > 0) {
            this.balance = this.balance.add(money);

            Transaction transaction = new Transaction(
                    Instant.now(),
                    null,
                    money,
                    getBalance());

            transactions.add(transaction);

            return;
        }

        throw new IllegalArgumentException("You can not deposit 0$ or negative money. " + money + "$");
    }

    public void withdraw(BigDecimal money) {
        if (money.compareTo(BigDecimal.ZERO) > 0) {

            if (this.balance.compareTo(money) < 0) {
                throw new IllegalArgumentException("Not enough balance. (" + balance + "$)");
            }

            this.balance = this.balance.subtract(money);
            return;
        }

        throw new IllegalArgumentException("You can not withdraw 0$ or negative money. " + money + "$");
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }
}
