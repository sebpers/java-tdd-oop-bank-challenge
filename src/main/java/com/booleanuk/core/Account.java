package com.booleanuk.core;

import java.math.BigDecimal;

public abstract class Account {

    private String name;
    private BigDecimal balance;

    public Account(String name, BigDecimal balance) {
        this.name = name;
        this.balance = balance;
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
            return;
        }

        throw new IllegalArgumentException("You can not deposit 0$ or negative money. " + money + "$");
    }
}
