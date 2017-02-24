package com.codeclan.example.javashopexample;

/**
 * Created by user on 24/02/2017.
 */

public class Transaction {

    TransactionType type;
    Double value;
    Customer customer;

    public Transaction(TransactionType type, Customer customer, Double value ){
        this.type = type;
        this.value = value;
        this.customer = customer;

    }

    public TransactionType getType() {
        return type;
    }

    public Double getValue() {
        return value;
    }

    public Customer getCustomer() {
        return customer;
    }

}
