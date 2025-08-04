package models;

public abstract class Account{
    protected String accountNumber;
    public String customerName;
    protected double balance;
    protected long phoneNumber;
    public String accountType;

    abstract String generateAccountNumber();
    public abstract boolean deposit(double amount);
    public abstract boolean withdraw(double amount);

    public String getAccountNumber(){
        return accountNumber;
    }
    public double getBalance(){
        return balance;
    }
    public long getMobileNumber(){
        return phoneNumber;
    }
}