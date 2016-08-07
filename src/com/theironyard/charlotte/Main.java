package com.theironyard.charlotte;

import java.util.HashMap;
import java.util.Scanner;
//imported Scanner class to imprint name
public class Main {

    private static HashMap<String, Double> account = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        account.put("mike", 100.00);
        account.put("ben", 200.00);

        while (true) {
            System.out.println("Welcome");
            System.out.println("What is your name?");

            String name = scanner.nextLine();

            //if statement to verify if user is in hashmap
            if (name.equals("")) {
                throw new Exception("Gotta have a name to get cash!");
            }

            //if name is not recognized in hashmap
            //created account should include name and starting balance
            if (!account.containsKey(name)) {
                System.out.println("Would you like to create a new account [y/n]?");

                String accPrompt = scanner.nextLine();

                if (accPrompt.equalsIgnoreCase("y")) {
                    System.out.println("Please input starting account balance");

                    String sBalance = scanner.nextLine();
                    double startBalance = Double.parseDouble(sBalance);

                    account.put(name, startBalance);
                }
                else if (accPrompt.equalsIgnoreCase("n")) {
                    System.out.println("Well fine then punk");
                    System.exit(0);
                }
            }
            System.out.println("Hello " + name);
            System.out.println("Would you like to? \n1.Check Balance \n2.Withdraw Funds \n3.Cancel \n4.Remove Account \n5.Transfer Funds");

            String optPrompt = scanner.nextLine();
            int optResult = Integer.parseInt(optPrompt);

            while (optResult < 6) {
                switch (optResult) {
                    case 1:
                        //code for check balance
                        System.out.println("Your Balance is " + account.get(name));
                        System.out.println("Would you like to? \n1.Check Balance \n2.Withdraw Funds \n3.Cancel \n4.Remove Account \n5.Transfer Funds");

                        optPrompt = scanner.nextLine();
                        optResult = Integer.parseInt(optPrompt);
                        continue;

                    case 2:
                        //code for withdraw
                        System.out.println("How much would you like to withdraw?");

                        String withdrawAmount = scanner.nextLine();
                        double a = Double.parseDouble(withdrawAmount);

                        if (a > account.get(name)) {
                            throw new Exception("insufficient funds");
                        }

                        double remainingBalance = (account.get(name) - a);
                        account.put(name, remainingBalance);

                        System.out.println("Your remaining balance is " + account.get(name));
                        System.out.println("Please take your cash below.");
                        System.out.println("Would you like to? \n1.Check Balance \n2.Withdraw Funds \n3.Cancel \n4.Remove Account \n5.Transfer Funds");

                        optPrompt = scanner.nextLine();
                        optResult = Integer.parseInt(optPrompt);
                        continue;
                    case 3:
                        System.out.println("Thank you come again");
                        break;

                    case 4:
                        //code for remove account
                        System.out.println("Which account name would you like to remove?");

                        String removeAccount = scanner.nextLine();
                        account.remove(removeAccount);

                        System.out.println("Your account has now been removed \nThank you have a good day");
                        break;
                    case 5:
                        //code for transfer funds
                        System.out.println("Which account would you like to transfer funds to?");

                        String transferAccount = scanner.nextLine();

                        if (!account.containsKey(transferAccount)) {
                            throw new Exception("Invalid Account!");
                        }

                        System.out.println("How much would you like to transfer?");

                        String transAmmount = scanner.nextLine();
                        double transferAmmount = Double.parseDouble(transAmmount);

                        double balanceSubTransfer = (account.get(name) - transferAmmount);

                        if (transferAmmount > (account.get(name))) {
                            throw new Exception("Sorry you don't have that much to give");
                        }

                        account.put(name, balanceSubTransfer);

                        double balanceAddTransfer = (account.get(transferAccount) + transferAmmount);

                        account.put(transferAccount, balanceAddTransfer);

                        System.out.println("Your funds have been transfered.\nYour remaining balance is " + balanceSubTransfer);
                        System.out.println("Would you like to? \n1.Check Balance \n2.Withdraw Funds \n3.Cancel \n4.Remove Account \n5.Transfer Funds");

                        optPrompt = scanner.nextLine();
                        optResult = Integer.parseInt(optPrompt);
                        continue;
                }
                break;
        }
        }
    }
}