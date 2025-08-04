package models;

import Exceptions.*;

import java.util.Random;

public class SavingsAccount extends Account {
    static double interestRate = 9;
    public int transactionLimit = 100000;


    public SavingsAccount(String customerName,long phoneNumber){
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        accountNumber = generateAccountNumber();
        this.accountType = "Savings";
        balance = 1000;
    }

    @Override
    protected String generateAccountNumber() {
        return "SB" + (new Random().nextInt(90000000)+ 99999999);
    }

    @Override
    public boolean deposit(double amount) throws InvalidAmount {
        if(amount<=0) throw new InvalidAmount("Amount must be positive");
        balance += amount;
        return true;
    }

    @Override
    public boolean withdraw(double amount) throws InsufficientBalance {
        if(amount > balance) throw new InsufficientBalance("Insufficient Balance. Enter Valid amount");
        balance -= amount;
        return true;
    }
}