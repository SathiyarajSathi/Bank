package User;

import models.Account;
import models.CurrentAccount;
import models.SavingsAccount;

import java.util.Scanner;

public class AccountPage {
    private final Account account;
    public AccountPage(Account account){
        this.account = account;
        run();
    }

    private void run(){
        Scanner sc = new Scanner(System.in);
        System.out.println("XYZ Bank");
        System.out.println("Welcome "+account.customerName);
        while(true) {
            System.out.println("1. View Balance");
            System.out.println("2. Deposit cash");
            System.out.println("3. Withdraw cash");
            System.out.println("4. Display Account info");
            System.out.println("5. Exit");
            System.out.println("Enter your choice by number: ");
            int opt = sc.nextInt();
            try {
                switch (opt) {
                    case 1 ->{
                        System.out.println("Available Balance : " + account.getBalance());
                    }
                    case 2 -> {
                        System.out.println("Enter Amount to deposit: ");
                        if(account.deposit(sc.nextDouble())) System.out.println("Transaction successful");
                        else System.out.println("Transaction Failed");
                    }
                    case 3 -> {
                        System.out.println("Enter Amount to withdraw: ");
                        if (account.withdraw(sc.nextDouble())) System.out.println("Transaction Successful");
                    }
                    case 4 ->{
                        displayInfo();
                    }
                    case 5 ->{
                        System.out.println("Thank You! Visit Again");
                        return;
                    }
                    default->{
                        System.out.println("Enter Valid option");
                    }
                }
            }catch(Exception e){
                System.out.println(e.getLocalizedMessage());
            }

        }
    }

    private void displayInfo(){
        System.out.println("Account Information");
        System.out.println("Account Holder Name: "+ account.customerName);
        System.out.println("Mobile Number: +91 "+account.getMobileNumber());
        System.out.println("Account Number: "+account.getAccountNumber());
        System.out.println("Account Type: "+ account.accountType);
        if(account instanceof CurrentAccount) System.out.println("Overdraft Limit: "+((CurrentAccount) account).getOverdraftLimit());
        else
            System.out.println("Transaction Limit: "+((SavingsAccount)account).transactionLimit);
    }

}