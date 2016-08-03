package com.theironyard.charlotte;

import java.util.Scanner;
//imported Scanner class to imprint name
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome");
        System.out.println("What is your name?");

        String name = Main.scanner.nextLine();

        if (name.equals("")) {
            throw new Exception("Gotta have a name to get cash!");
        }

        System.out.println("Hello " + name);

        System.out.println("Would you like to? \n1.Check Balance \n2.Withdraw Funds \n3.Cancel");

        String promptResult = Main.scanner.nextLine();

        if (promptResult.equals("1")){
            System.out.println("Your Balance is $100");
        }
        else if (promptResult.equals("3")){
            System.out.println("Thank you and please come again.");
        }
        else if (promptResult.equals("2")) {
            System.out.println("How much would you like to withdraw?");
        }

        String withdrawAmount = Main.scanner.nextLine();

        int a = Integer.parseInt(withdrawAmount);

        if (a < 100) {
            int remainingBalance = (100 - a);
            System.out.println("Your available balance is " + remainingBalance + " dollars");
            System.out.println("Please take your cash below");
        }
        else if (a > 100) {
            throw new Exception("You ain't that rich FOOL!");
        }
    }



}
        // 2. prompt a user for a choice (1, 2, or 3.)
        // print "Make a selection: 1, 2, 3"
        // read in a value, convert it to an integer (1, 2, 3)
        // if that value == 1, then use the atm to check the balance
        // else if that value == 2, then withdraw funds from the atm
        // else cancel
