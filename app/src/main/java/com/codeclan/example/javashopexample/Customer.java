package com.codeclan.example.javashopexample;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import static com.codeclan.example.javashopexample.CardType.CREDIT;
import static com.codeclan.example.javashopexample.TransactionType.SALE;

/**
 * Created by user on 24/02/2017.
 */

public class Customer {

    private String customerName;
    private ArrayList<Payable> paymentMethods;

    public Customer(String customerName, Payable[] cardsHeld){
        this.customerName = customerName;

        paymentMethods = new ArrayList<Payable>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public ArrayList<Payable> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(ArrayList<Payable> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public Payable getCreditCard(){
        for(Payable card : paymentMethods){
            if(card.getType.equals(CREDIT){
                Payable result = card;
            }
        }
    }

//    public Transaction beginTransaction(String item, Shop shop){
//        return new Transaction(SALE, this, shop.getPrice(item));
//    }



}
