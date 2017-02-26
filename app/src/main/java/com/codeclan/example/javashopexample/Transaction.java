package com.codeclan.example.javashopexample;

import java.util.ArrayList;

/**
 * Created by user on 24/02/2017.
 */

public class Transaction {

    //instance variable
    TransactionType type;
    Double value;
    Customer customer;
    ArrayList<String> transactionEvents;

    //constructor
    public Transaction(TransactionType type, Customer customer, Double value ){
        this.type = type;
        this.value = value;
        this.customer = customer;
        transactionEvents = new ArrayList<String>();

    }

    //getters
    public TransactionType getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<String> getTransactionEvents() {
        return transactionEvents;
    }

    public void adjustCreditCardBalance(DebitCard card){
        if(this.type.equals(TransactionType.REFUND)){
            transactionEvents.add(card.commitPurchase(this.value * -1));
            transactionEvents.add("New card Balance: £" + card.getBalance());

        }
        else {
            transactionEvents.add(card.commitPurchase(this.value));
            transactionEvents.add("New card Balance: £" + card.getBalance());
        }
    }

    public void adjustDebitCardBalance(DebitCard card){
        if(this.type.equals(TransactionType.REFUND)){
            transactionEvents.add(card.commitPurchase(this.value * -1));
            transactionEvents.add("New card Balance: £" + card.getBalance());

        }
        else {
            transactionEvents.add(card.commitPurchase(this.value));
            transactionEvents.add("New card Balance: £" + card.getBalance());
        }
    }

    public void adjustShopBalance(Shop shop) {
        if (this.type.equals(TransactionType.REFUND)) {
            shop.addToBalance(this.value * -1);
        } else {
            shop.addToBalance(this.value);
        }

    }

    public void displayAllLogContents(Console console){
        for(String event : transactionEvents){
            console.show(event);
        }
    }

    public void enact(CreditCard creditcard, Shop shop, Console console){
        adjustCreditCardBalance(creditcard);
        adjustShopBalance(shop);
        displayAllLogContents(console);
        
    }

}
