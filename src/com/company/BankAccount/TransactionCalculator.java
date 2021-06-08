package com.company.BankAccount;

import java.util.Scanner;

public class TransactionCalculator {
    private double balance;

    private final Scanner scanner = new Scanner(System.in);

    public double debitAccount() { return this.balance -= scanner.nextDouble(); }
    public double creditAccount() { return this.balance += scanner.nextDouble(); }
}
