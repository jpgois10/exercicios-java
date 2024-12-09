package application;

import entities.Account;

import java.util.Locale;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Account account;

        System.out.print("Enter account number: ");
        int accountNumber = sc.nextInt();
        System.out.print("Enter account holder: ");
        sc.nextLine();
        String accountHolder = sc.nextLine();
        System.out.print("Is there a initial deposit (Y/N)? ");
        char responseInitialDeposit = sc.next().charAt(0);

        if (Character.toLowerCase(responseInitialDeposit) == 'y') {
            System.out.print("Enter initial deposit value: ");
            double initialDeposit = sc.nextDouble();
            account = new Account(accountNumber, accountHolder, initialDeposit);
        } else {
            account = new Account(accountNumber, accountHolder);
        }

        System.out.println();
        System.out.println("Account data: ");
        System.out.println(account);

        System.out.println();
        System.out.print("Enter a deposit value: ");
        double depositValue = sc.nextDouble();
        account.deposit(depositValue);
        System.out.println("Updated account data: ");
        System.out.println(account);

        System.out.println();
        System.out.print("Enter a withdraw value: ");
        double withdrawValue = sc.nextDouble();
        account.withdraw(withdrawValue);
        System.out.println("Updated account data: ");
        System.out.println(account);



        sc.close();
    }
}
