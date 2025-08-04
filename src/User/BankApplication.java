package User;

import Exceptions.AccountNotFound;
import Exceptions.InvalidAmount;
import Exceptions.InvalidInput;
import models.Account;
import models.CurrentAccount;
import models.SavingsAccount;

import java.util.HashMap;
import java.util.Scanner;

public class BankApplication {
    static HashMap<String,Account> accounts = new HashMap<>();
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to XYZ Bank");
        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit Application");
            System.out.println("Enter your Choice");
            int opt = sc.nextInt();
            try{
            switch (opt) {
                case 1 -> createAccount();
                case 2 -> Login();
                case 3 -> {
                    System.out.println("Exiting Application");
                    return;
                }
                default -> System.out.println("Enter Valid option");

            }
        }catch (Exception e){
                System.out.println(e.getLocalizedMessage());
            }
    }
    }
    static void createAccount() throws InvalidInput {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome New User!");
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Enter Phone Number");
        long number = sc.nextLong();
        System.out.println("Choose Account Type: 1.Savings 2.Current");
        int type = sc.nextInt();
        accounts.put(name,type==1?new SavingsAccount(name,number):new CurrentAccount(name,number));
        new AccountPage(accounts.get(name));

    }
    static void Login() throws AccountNotFound{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name to Login");
        String name = sc.nextLine();
        if(accounts.get(name) != null)
            new AccountPage(accounts.get(name));
        else
            throw new AccountNotFound("Account Not Exist");

    }
}
