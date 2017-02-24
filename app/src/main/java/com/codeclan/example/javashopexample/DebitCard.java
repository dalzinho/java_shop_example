package com.codeclan.example.javashopexample;

/**
 * Created by user on 24/02/2017.
 */

public class DebitCard implements Payable {

    String provider;
    Double balance;

    public DebitCard(String provider, Double balance){
        this.provider = provider;
        this.balance = balance;
    }
}
