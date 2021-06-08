package com.company.BankAccount;

public class BankAccount {
    private final String name, nric, accountNumber, accountType, password;
    private double balance;

    public BankAccount(String _name, String _nric, String _accountNumber, String _password, String _accountType) {
        this.name = _name;
        this.nric = _nric;
        this.accountNumber = _accountNumber;
        this.password = _password;
        this.accountType = _accountType;
    }

    public String getName() { return this.name; }
    public String getNric() { return this.nric; }
    public String getPassword() { return this.password; }
    public String getAccountNumber() { return this.accountNumber; }
    public String getAccountType() { return this.accountType; }
    public String getFileName() { return this.nric + ".txt"; }
    public double getBalance() { return this.balance; }
    public void setBalance(double num) { this.balance = num; }
}