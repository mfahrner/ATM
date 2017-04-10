package com.theironyard.charlotte;

import java.util.HashMap;

public class Main {

    public static HashMap<String, Person> accountInfo = new HashMap<>();

    public static void main(String[] args) throws Exception {

        //creating test person
        Person mike = new Person("mike", 100.0);
        accountInfo.put("mike", mike);

        ATM atm = new ATM();

        atm.menu();
    }
}