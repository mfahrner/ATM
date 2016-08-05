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

        System.out.println("Welcome");
        System.out.println("What is your name?");

        String name = scanner.nextLine();
        //if statement to verify if user is in hashmap

        if (name.equals("")) {
            throw new Exception("Gotta have a name to get cash!");
        }

        //if name is not recognized in hashmap-prompt for new account is good
        //created account should include name and starting balance
        if (!account.containsKey(name)) {
            System.out.println("Would you like to create a new account [y/n]?");

            String accPrompt = scanner.nextLine();

            //don't know how to test if this is working?
            if (accPrompt.equalsIgnoreCase("y")) {
                System.out.println("Please input starting account balance");
                String sBalance = scanner.nextLine();
                double startBalance = Double.parseDouble(sBalance);
                account.put(name, startBalance);
            }
            //thought about loop here but think i might be making it too hard
            else if (accPrompt.equalsIgnoreCase("n")) {
                System.out.println("Well fine then punk");
                System.exit(0);
            }
        }
        System.out.println("Hello " + name);
        System.out.println("Would you like to? \n1.Check Balance \n2.Withdraw Funds \n3.Cancel \n4.Remove Account");












    }
}



/*


        String promptResult = scanner.nextLine();
        //didnt need to use main could have set it to scanner.nextline() through out
        //should have reset this string to int

        if (promptResult.equals("1")){
            System.out.println("Your Balance is $100");
        }
        else if (promptResult.equals("3")){
            System.out.println("Thank you and please come again.");
        }
        else if (promptResult.equals("2")) {
            System.out.println("How much would you like to withdraw?");
        }

        String withdrawAmount = scanner.nextLine();

        int a = Integer.parseInt(withdrawAmount);
        //the way I interpreted hardmode was that withdraws that could be made with a combo of 5's, 10's and 20's were cool
        if (a < 100 && (a % 5 == 0)) {
            int remainingBalance = (100 - a);
            System.out.println("Your available balance is " + remainingBalance + " dollars");
            System.out.println("Please take your cash below");
        }
        else if (a > 100) {
            throw new Exception("You ain't that rich FOOL!");
        }
        //I thought about having this loop back to the prompt of line 31 but realized the loop would need to be endless and I
        //don't yet have the skill set to close the loop. so i just threw an exception
        // I was thinking a try catch statement might work but ran out of time
        else if (a < 100 && (a % 5 != 0)) {
            System.out.println("Invalid submission. \nCan only withdraw 5's, 10's or 20's");
            throw new Exception("Invalid submission");
        }
    }



}
     */
        // 2. prompt a user for a choice (1, 2, or 3.)
        // print "Make a selection: 1, 2, 3"
        // read in a value, convert it to an integer (1, 2, 3)
        // if that value == 1, then use the atm to check the balance
        // else if that value == 2, then withdraw funds from the atm
        // else cancel
