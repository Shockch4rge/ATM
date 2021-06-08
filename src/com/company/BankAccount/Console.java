package com.company.BankAccount;

import java.util.Scanner;

public class Console {
    private final Scanner scanner = new Scanner(System.in);
    private final TransactionCalculator calculator = new TransactionCalculator();
    private final BankAccount account = new BankAccount("John Doe", "T0303030E",
            "123-123-123-1", "mypass", "Savings");
    // References BankAccount `account` object ^
    private final FileReader fileReader = new FileReader(account.getNric());
    private final PasswordChecker passwordChecker = new PasswordChecker();

    public void start() {
        System.out.print("""
                BANK ACCOUNT!
                -------------
                Enter password to access navigation:\s""");
        String password = scanner.nextLine();
        while (!passwordChecker.checkPassword(password, account.getPassword())) {
            System.out.print("Wrong password. Try again: ");
            password = scanner.nextLine();
        }
        System.out.println("Login successful!");
        account.setBalance(fileReader.readBalance());

        System.out.print("""
                DIRECTORY
                ---------
                1. ACCOUNT DETAILS
                2. MAKE A TRANSACTION
                
                Enter a number:\s""");
        switch (scanner.nextLine()) {
            case "1" -> {
                System.out.println("ACCOUNT DETAILS" +
                        "\n---------------" +
                        "\nAccount Name: " + account.getName() +
                        "\nAccount Number: " + account.getAccountNumber() +
                        "\nAccount Type: " + account.getAccountType() +
                        "\nAccount Balance: $" + account.getBalance());
                endSession();
            }
            case "2" -> {
                System.out.print("""
                        TRANSACTIONS
                        ------------
                        1. DEPOSIT
                        2. WITHDRAW
                                                
                        Enter a number: """);
                switch (scanner.nextLine()) {
                    case "1" -> {
                        System.out.print("Amount to deposit: $");
                        System.out.println("New balance: $" + calculator.creditAccount());
                        endSession();
                    }
                    case "2" -> {
                        System.out.print("Amount to withdraw: $");
                        System.out.println("New balance: $" + calculator.debitAccount());
                        endSession();
                    }
                }
            }
            default -> System.out.println("Invalid input.");
        }
        fileReader.saveBalance(account.getBalance());
    }

    private void endSession() { System.out.println("\nSession ended!\n-"); }
}

