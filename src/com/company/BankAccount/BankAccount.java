package com.company.BankAccount;
import java.util.Scanner;

public class BankAccount {

    private String name;
    private String nric;
    private String accountNumber;
    private String accountType;
    private String password;
    private double balance;
    boolean activation;
    Scanner scanner = new Scanner(System.in);

    public BankAccount(String _name, String _nric, String _accountNumber, String _password, String _accountType) {
        this.name = _name;
        this.nric = _nric;
        this.accountNumber = _accountNumber;
        this.password = _password;
        this.accountType = _accountType;
        this.balance = 0.0;
        this.activation = false;
    }

    public void nav() {
        System.out.print("Enter password to access navigation: ");
        while (!checkPassword()) {
            checkPassword();
        }
        System.out.println("1. Deposit" +
                "\n2. Withdraw");
        directory();

    }

    public boolean checkPassword() {
        String password = scanner.nextLine();
        if (password.equals(this.password)) {
            setActivation();
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Wrong password. Try again.");
            return false;
        }
    }

    public void directory() {
        String input = scanner.nextLine();
        if (input.equals("1")) {
            System.out.print("Enter amount to deposit: ");
            creditAccount();
        } else if (input.equals("2")) {
            System.out.print("Enter amount to withdraw: ");
            debitAccount();
        }
        System.out.println("New balance: $" + this.balance);
        System.out.println("Session ended.");
    }

    public double creditAccount() { return this.balance += scanner.nextDouble(); }
    public double debitAccount() { return this.balance -= scanner.nextDouble(); }

    public double getBalance() { return this.balance; }
    public String getName() { return this.name; }
    public String getNric() { return this.nric; }
    public String getAccountNumber() { return this.accountNumber; }
    public String getAccountType() { return this.accountType; }
    public boolean setActivation() { return this.activation = true; }




//    public void transferAccount(double amountToTransfer, BankAccount transferTo) {
//        this.debitAccount(amountToTransfer);
//        transferTo.creditAccount(amountToTransfer);
//    }
}