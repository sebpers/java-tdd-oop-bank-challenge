package com.booleanuk.core;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public abstract class Account {

    private String name;
    private BigDecimal balance;
    private final List<Transaction> transactions;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            .withZone(ZoneId.systemDefault());

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

            Transaction transaction = new Transaction(
                    Instant.now(),
                    money,
                    null,
                    getBalance());

            transactions.add(transaction);
            return;
        }

        throw new IllegalArgumentException("You can not withdraw 0$ or negative money. " + money + "$");
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public String getTransactionsOnPrint() {
        String headers = String.format("%s || %6s || %5s || %s\n", "date", "credit", "debit", "balance");

        StringBuilder print = new StringBuilder();

        for (Transaction t : this.transactions) {
            String date = formatter.format(t.getDate());
            String credit = formatNullToString(t.getCredit());
            String debit = formatNullToString(t.getDebit());
            String balance = formatNullToString(t.getBalance());

            print.append(String.format("%10s || %6s || %5s || %s\n", date, credit, debit, balance));
        }

        return headers + print.toString();
    }

    private String formatNullToString(BigDecimal num) {
        if (num == null) {
            return "";
        }

        return num.toString();
    }
}
