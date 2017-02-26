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

        while(true) {
            console.show("Make a new sale");
            console.show("Please enter sale amount");
            String s = console.getInput();
            Double saleAmount = Double.parseDouble(s);

            console.show("Please select payment type");
            String cardChoice = console.selectCardType();
            if (cardChoice == "c"){
                shop.manageTransaction(TransactionType.SALE, customer, saleAmount, console, CardType.CREDIT);
            }
            else if (cardChoice == "d") {
                shop.manageTransaction(TransactionType.SALE, customer, saleAmount, console, CardType.DEBIT);
            }
                else{
                break;
            }


        }






    }
}
