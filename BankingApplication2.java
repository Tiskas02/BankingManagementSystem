package BankingApplication2;

import java.util.Random;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;

public class BankingApplication2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Bank Bank = new Bank("scb");
        int option = 0,accountNumber;
        String accountName;
        double amount,balance = 0;

        while(option != 6 ){
            System.out.println("Main Menu");
            System.out.println("1. Display All Accounts​");
            System.out.println("2. Open New Account​");
            System.out.println("3. Close Existing Account​");
            System.out.println("4. Deposit Money​");
            System.out.println("5. Withdraw Money​");
            System.out.println("6. Exit");
            System.out.println();

            System.out.print("Enter your choice : ");
            option = scan.nextInt();//รับข้อมูลintegerจากkeyboard
            scan.nextLine();//clear enter

            switch(option){
                case 1:
                    Bank.listAccount();
                    break;
                case 2:
                    accountNumber = generateAccNumber();
                    System.out.print("Enter Account Name:");
                    accountName = scan.nextLine();
                    System.out.print("Enter Initial Balance:");
                    balance = scan.nextDouble();
                    Bank.openAccout(accountNumber,accountName,balance);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scan.nextInt();
                    scan.nextLine();//clear Enter
                    accountNumber = 1111;
                    Bank.closeAccount(accountNumber);
                    break;
                case 4: 
                    System.out.print("Enter Account Number: ");
                    accountNumber = scan.nextInt();
                    scan.nextLine();//clear Enter
                    System.out.print("Enter Amout: ");
                    amount = scan.nextDouble();
                    Bank.depositMoney(accountNumber, amount);
                    break;
                case 5:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scan.nextInt();
                    scan.nextLine();//clear Enter
                    System.out.print("Enter Amout: ");
                    amount = scan.nextDouble();
                    Bank.withdrawMoney(accountNumber, amount);
                    break;
            }
            System.out.println();
        }
    }
    public static int generateAccNumber(){
        Random ran = new Random(); 
        int accNumber = 100000 + ran.nextInt(900000);
        return accNumber;
    }
}
