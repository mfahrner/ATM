package com.theironyard.charlotte;

/**
 * Created by mfahrner on 8/3/16.
 */
public class ATM {
    public Person getUser() {
        return user;
    }

    public void setUser(Person user) {
        this.user = user;
    }

    private Person user;

    public void checkBalance() {
        System.out.printf("You currently have %d dollars.\n", user.getAccountBalance());
    }

    public void endSession() {
        System.out.println("Thank you and please come again.");
    }

    public void withdrawFunds(int amount) throws Exception {
        // if the user has enough money
        // and the amount is a mult of 5
        //print "please take your cash" and the amount,
        //and the amount the user has left

        if (amount < 0) {
            throw new Exception("Please enter an amount that's greater than 0");
        }

        if (amount % 5 != 0) {
            throw new Exception("The amount withdrawn must be a multiple of 5.");
        }

        if (amount % 5 == 0 && user.getAccountBalance() >= amount) {
            System.out.printf("");
        }
    }
}