package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class AccountTest {

    private Account account;

    @BeforeEach
    public void init() {
        this.account = new Account("John Does savings", BigDecimal.ZERO) {};
    }

    @Test
    public void shouldSetAndGetName_successfully() {
        String name = account.getName();

        Assertions.assertEquals("John Does savings", name);
    }

    @Test
    public void shouldHaveABalance_successfully() {
        Assertions.assertEquals("John Does savings", account.getName());
        Assertions.assertEquals(BigDecimal.ZERO, account.getBalance());
    }

    @Test
    public void deposit_shouldDeposit_successfully() {
        account.deposit(BigDecimal.valueOf(100));

        BigDecimal balance = account.getBalance();

        Assertions.assertEquals(BigDecimal.valueOf(100), balance);
    }

    @Test
    public void deposit_shouldFailIfDepositingNegativeNumber_fail() {
        BigDecimal money = BigDecimal.valueOf(-100);
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, () -> account.deposit(money));

        Assertions.assertEquals("You can not deposit 0$ or negative money. " + BigDecimal.valueOf(-100) + "$", ex.getMessage());
    }

    @Test
    public void deposit_shouldAddTransaction_successfully() {
        account.deposit(BigDecimal.valueOf(100));
        account.deposit(BigDecimal.valueOf(200));

        List<Transaction> transactions = account.getTransactions();

        Assertions.assertEquals(2, transactions.size());
    }

    @Test
    public void withdraw_shouldWithdraw_successfully() {
        BigDecimal money = BigDecimal.valueOf(200);
        account.deposit(money);

        account.withdraw(BigDecimal.valueOf(100));

        BigDecimal balance = account.getBalance();

        Assertions.assertEquals(BigDecimal.valueOf(100), balance);
    }

    @Test
    public void withdraw_shouldThrowIllegalArgumentException_successfully() {
        BigDecimal money = BigDecimal.valueOf(100);
        account.deposit(money);

        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, () -> account.withdraw(BigDecimal.valueOf(200)));
        Assertions.assertEquals("Not enough balance. (" + money + "$)", ex.getMessage());
    }

    @Test
    public void getTransactionsOnPrint_shouldGetAllTransaction_successfully() {
        account.deposit(BigDecimal.valueOf(100));
        account.deposit(BigDecimal.valueOf(200));
        account.withdraw(BigDecimal.valueOf(50.53));

        String print = account.getTransactionsOnPrint();

        String expectedResult = "" +
                "date || credit || debit || balance\n" +
                "26/08/2026 ||        ||   100 || 100\n" +
                "26/08/2026 ||        ||   200 || 300\n" +
                "26/08/2026 ||  50.53 ||       || 249.47\n";

        Assertions.assertEquals(expectedResult, print);
    }
}
