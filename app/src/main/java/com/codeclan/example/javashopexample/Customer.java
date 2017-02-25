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
    private HashMap paymentMethods;

    public Customer(String customerName){
        this.customerName = customerName;
        paymentMethods = new HashMap<CardType, Payable>();

//        for(Payable card : cardsHeld){
//            paymentMethods.add(card);
//        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void addPaymentMethod(CardType type, Payable card){
        paymentMethods.put(type, card);
    }

    public HashMap getPaymentMethods() {
        return paymentMethods;
    }

    public CreditCard getCreditCard(){

        CreditCard result = (CreditCard) this.paymentMethods.get(CREDIT);
        return result;
    }

    public double beginPurchase(Shop shop, String item){
        return shop.getPrice(item);
    }



// public CAST PAYABLE TO CARD TYPE!


}
