package com.company.BankAccount;

public class PasswordChecker {

    public boolean checkPassword(String password, String accountPassword) {
        return password.equals(accountPassword);
    }
}