package com.company.BankAccount;

public class TestBankAccount {

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("John Doe", "T0303030E",
                "123-123-123-1", "123456789","Savings");
        BankAccount account2 = new BankAccount("Mary Lim", "T0101010E",
                "321-321-321-3", "987654321","Savings");

        account1.nav();
//        account1.creditAccount(0.00);
//        account1.debitAmount(250.00);
//        account1.transferAmount(500, account2);
//        System.out.println("The new balance for " + account1.getName() + " is $" + account1.getBalance());
//        System.out.println(account1.nav());

//        account2.activateAccount(false);
//        account2.creditAccount(25000.00);
//        account2.debitAmount(5000.00);
//        System.out.println("The new balance for " + account2.getName() + " is $" + account2.getBalance());
    }
}