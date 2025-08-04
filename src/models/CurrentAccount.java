package models;

import Exceptions.InsufficientBalance;
import Exceptions.InvalidAmount;

import java.util.Random;

public class CurrentAccount extends Account {
    private int overdraftLimit;


    public CurrentAccount(String customerName,long phoneNumber){
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        accountNumber = generateAccountNumber();
        this.accountType = "Current";
        balance = 1000;
        overdraftLimit = 5000;
    }

    @Override
    protected String generateAccountNumber() {
        return "CA" + (new Random().nextInt(90000000)+ 99999999);
    }

    @Override
    public boolean deposit(double amount) throws InvalidAmount {
        if(amount<=0) throw new InvalidAmount("Amount must be positive");
        balance += amount;
        return true;
    }

    @Override
    public boolean withdraw(double amount) throws InsufficientBalance {
        if(amount >= balance + overdraftLimit) throw new InsufficientBalance("Overdraft Limit Exceeded for this transaction. Can't Withdrawn");
        balance -= amount;
        return true;
    }

    public void setOverdraftLimit(int overdraftLimit){
        this.overdraftLimit = overdraftLimit;
    }

    public int getOverdraftLimit(){
        return this.overdraftLimit;
    }
}
