package com.codeclan.example.javashopexample;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 24/02/2017.
 */

public class TestTransaction {

    Shop shop;
    Customer customer;
    DebitCard debitCard;
    CreditCard creditCard;

    @Before
    public void setup(){
        shop = new Shop("Ikea");
        debitCard = new DebitCard("First Direct", 100.0);
        creditCard = new CreditCard("Nationwide", 1000.00);
        Payable[] cardsHeld = {debitCard, creditCard};
        customer = new Customer("Basil Brush", cardsHeld);
    }

    @Test
    public void testCanDeductFromCreditCard(){
        customer.getPaymentMethods().get(0);
    }

    @Test
    public void testCanIncrementShopBalance(){

    }

//    @Test
//    public void
}
