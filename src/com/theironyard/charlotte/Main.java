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
    }



}
        // 2. prompt a user for a choice (1, 2, or 3.)
        // print "Make a selection: 1, 2, 3"
        // read in a value, convert it to an integer (1, 2, 3)
        // if that value == 1, then use the atm to check the balance
        // else if that value == 2, then withdraw funds from the atm
        // else cancel
