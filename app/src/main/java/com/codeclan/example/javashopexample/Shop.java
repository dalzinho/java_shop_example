package com.codeclan.example.javashopexample;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 24/02/2017.
 */

public class Shop {

    //instance variables
    private String shopName;
    private Double shopBalance;
    private ArrayList<Customer> customers;
    private ArrayList<Transaction> transactionLog;
    private HashMap inventory;
    private String item;
    private Double price;

    //constructor
    public Shop(String shopName){
        this.shopName = shopName;
        this.shopBalance = 1000.00;
        this.transactionLog = new ArrayList<Transaction>();
        this.inventory = new HashMap();
    }

    // methods
   public void addToBalance(Double amount){
       this.shopBalance += amount;
   }

    //getters

    public String getShopName() {
        return shopName;
    }

    public Double getBalance() {
        return shopBalance;
    }

    public ArrayList<Transaction> getTransactionLog() {
        return transactionLog;
    }

    //inventory methods
    public void addItemToInventory(String addItem, Double addPrice){
        inventory.put(addItem, addPrice);
    }

    public HashMap getInventory() {
        return inventory;
    }

    public Double getPrice(String searchKey){
        return (Double) inventory.get(searchKey);
    }



    public void manageTransaction(TransactionType type, Customer customer, Double value, Console console) {
        Transaction transaction = new Transaction(type, customer, value);
        CreditCard paymentCard = customer.getCreditCard();
        transaction.enact(paymentCard, this, console);
        transactionLog.add(transaction);

    }
}
