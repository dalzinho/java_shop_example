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

        while (true) {
            console.show("Welcome to " + shop.getShopName());

            console.show("Make a new sale");
            console.show("Please enter sale amount");
            String s = console.getInput();
            Double saleAmount = Double.parseDouble(s);

            console.show("Please select payment type");
            String cardChoice = console.selectCardType();
            if (cardChoice.equals("c")) {
                shop.manageCCTransaction(TransactionType.SALE, customer, saleAmount, console);
            } else if (cardChoice.equals("d")) {
                shop.manageDCTransaction(TransactionType.SALE, customer, saleAmount, console);
            }

            System.out.println();

            console.show("Transaction Log");
            console.show("===============");

            for (Transaction transaction : shop.getTransactionLog()) {
                console.show(transaction.getCustomer().getCustomerName());
                console.show(transaction.getType().toString());
                console.show(transaction.getValue().toString());
                System.out.println();
            }

            console.show("REFUND");
            console.show("======");
            console.show("Please enter refund amount");
            s = console.getInput();
            Double refundAmount = Double.parseDouble(s);

            console.show("Please select card for refund");
            cardChoice = console.selectCardType();
            if (cardChoice.equals("c")) {
                shop.manageCCTransaction(TransactionType.REFUND, customer, refundAmount, console);
            } else if (cardChoice.equals("d")) {
                shop.manageDCTransaction(TransactionType.REFUND, customer, refundAmount, console);
            }
            System.out.println();

        }
    }
}