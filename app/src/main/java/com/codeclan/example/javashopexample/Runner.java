package com.codeclan.example.javashopexample;

/**
 * Created by user on 26/02/2017.
 */

public class Runner {

    public static void main(String[] args) {
        Customer customer = new Customer("Florian Schneider");
        CreditCard creditCard = new CreditCard("Amex", 200.);
        DebitCard debitCard = new DebitCard("Nationwide", 100.);
        customer.addPaymentMethod(CardType.CREDIT, creditCard);
        customer.addPaymentMethod(CardType.DEBIT, debitCard);

        Shop shop = new Shop("Briss Butchers Shop");


        Console console = new Console();

        console.show("Welcome to " + shop.getShopName());
        System.out.println();
        console.mainMenu();
        console.mainMenuInput(console.getInput());





    }
}
