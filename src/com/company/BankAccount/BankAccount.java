package com.company.BankAccount;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
        this.activation = false;

        initialise();
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

    public void creditAccount() {
        this.balance += scanner.nextDouble();
        try {
            FileWriter writer = new FileWriter(this.getFileName());
            writer.write(String.valueOf(this.balance));
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void debitAccount() {
        this.balance -= scanner.nextDouble();
        try {
            FileWriter writer = new FileWriter(this.getFileName());
            writer.write(String.valueOf(this.balance));
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String getFileName() { return this.nric + ".txt"; }
    public double getBalance() { return this.balance; }
    public String getName() { return this.name; }
    public String getNric() { return this.nric; }
    public String getAccountNumber() { return this.accountNumber; }
    public String getAccountType() { return this.accountType; }
    public void setActivation() { this.activation = true; }

    public void initialise() {
        // Get previous bank balance if it exists
        try {
            File balance = new File(this.getFileName());
            Scanner reader = new Scanner(balance);
            String data = reader.nextLine();
            try {
                this.balance = Double.parseDouble(data);
            } catch (NumberFormatException e) {
                balance.delete();
                this.balance = 0;
            }

        } catch (IOException e) {
            System.out.println("No previous balance for " + this.nric + " exists.");
            this.balance = 0;
        }
    }


//    public void transferAccount(double amountToTransfer, BankAccount transferTo) {
//        this.debitAccount(amountToTransfer);
//        transferTo.creditAccount(amountToTransfer);
//    }
}