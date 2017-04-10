package com.theironyard.charlotte;

import java.util.Scanner;

/**
 * Created by mfahrner on 8/3/16.
 */
public class ATM {

    private Person user;

    private Scanner scannerStr = new Scanner(System.in);
    private Scanner scannerDbl = new Scanner(System.in);
    private Scanner scannerInt = new Scanner(System.in);


    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }

    public void menu() throws Exception {

        while (true) {
            greetUser();
            checkUser();
            hello();
            options();
        }
    }

    public void greetUser() {
        //greet user and ask for name
        System.out.println("Welcome");
        System.out.println("What is your name?");
    }

    public void checkUser() throws Exception {
        String name = scannerStr.nextLine();
        if (name.equals("")) {
                throw new Exception("Gotta have a name to get cash!");
        }

        if (!Main.accountInfo.containsKey(name)) {
                System.out.println("Would you like to create a new account [y/n]?");

                String accPrompt = scannerStr.nextLine();

                if (accPrompt.equalsIgnoreCase("y")) {
                    System.out.println("Please input starting account balance");

                    double  startBalance = Double.parseDouble(scannerDbl.nextLine());
                    user = new Person(name, startBalance);
                    Main.accountInfo.put(name, user);
                }
                else if (accPrompt.equalsIgnoreCase("n")) {
                    System.out.println("Well fine then punk");
                    System.exit(0);
                }
        } else {
            user = Main.accountInfo.get(name);
        }
    }

    public void hello() {
        System.out.println(String.format("Hello %s. Your balance is %.2f", user.getName(), user.getAccountBalance()));

    }

    public void options() throws Exception {

        int update = 0;
        while (update == 0) {
            System.out.println("\nWould you like to? \n1.Check Balance \n2.Withdraw Funds \n3.Cancel \n4.Remove Account \n5.Transfer Funds");
            int optResult = Integer.parseInt(scannerInt.nextLine());

            while (optResult < 6) {
                switch (optResult) {
                    case 1:
                        //code for check balance
                        checkBalance();
                        break;
                    case 2:
                        //code for withdraw
                        withdraw();
                        break;
                    case 3:
                        System.out.println("Thank you come again");
                        update++;
                        break;
                    case 4:
                        //code for remove account
                        removeAccount();
                        update++;
                        break;
                    case 5:
                        //code for transfer funds
                        transfer();
                        break;
                }
                break;
            }
        }
    }

    public void checkBalance() {
        System.out.printf("Your Balance is %.2f", user.getAccountBalance());
    }

    public void withdraw() throws Exception {
        System.out.println("How much would you like to withdraw?");

        double withdrawAmount = Double.parseDouble(scannerDbl.nextLine());

        if (withdrawAmount > user.getAccountBalance()) {
            throw new Exception("Insufficient funds");
        } else {
            user.setAccountBalance(user.getAccountBalance() - withdrawAmount);
        }

        System.out.printf("Your remaining balance is %.2f\n", user.getAccountBalance());
        System.out.println("Please take your cash below.");
    }

    public void removeAccount() {
        System.out.println("Are you sure you would like to remove account? y/n");
        String rmOption = scannerStr.nextLine();

        if (rmOption.equalsIgnoreCase("y")) {
            Main.accountInfo.remove(user.getName());
            System.out.println("Your account has now been removed \nThank you have a good day");
        } else {
            System.out.println("Thank you for continuing to have an account with us");
        }
    }

    public void transfer() throws Exception {
        System.out.println("Which account would you like to transfer funds to?");
        String transferAccount = scannerStr.nextLine();

        if (!Main.accountInfo.containsKey(transferAccount)) {
            throw new Exception("Invalid Account!");
        }

        System.out.println("How much would you like to transfer?");
        double transferAmmount = Double.parseDouble(scannerDbl.nextLine());

        if (transferAmmount > user.getAccountBalance()) {
            throw new Exception("Sorry you don't have that much to give");
        } else {
            Main.accountInfo.get(transferAccount).setAccountBalance(Main.accountInfo.get(transferAccount).getAccountBalance() +
                                                                    transferAmmount);
            user.setAccountBalance(user.getAccountBalance() - transferAmmount);
        }

        System.out.printf("Your funds have been transfered.\nYour remaining balance is %.2f", user.getAccountBalance());
    }

}