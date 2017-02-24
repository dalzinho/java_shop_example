package com.codeclan.example.javashopexample;

import org.junit.Before;
import org.junit.Test;

import static com.codeclan.example.javashopexample.TransactionType.SALE;
import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 24/02/2017.
 */

public class CustomerTest {

    Customer customer;
    DebitCard debitCard;
    CreditCard creditCard;
    Shop shop;

    @Before
    public void before(){
        debitCard = new DebitCard("First Direct", 100.0);
        creditCard = new CreditCard("Nationwide", 1000.00);
        Payable[] cardsHeld = {debitCard, creditCard};
        customer = new Customer("Lev Yashin", cardsHeld);
        shop = new Shop("Univermag");
        shop.addItemToInventory("Bread", 20.0);
        shop.addItemToInventory("Milk", 40.0);
        shop.addItemToInventory("Eggs", 10.0);
    }

    @Test
    public void customerHasTwoCards(){
        assertEquals(2, customer.getPaymentMethods().size());
    }

    @Test
    public void testCanGetCreditCard(){
        assertEquals(1000, customer.getCreditCard().getCreditLimit());
    }

//    @Test
//    public void testCustomerCanInitiateTransaction(){
//        Transaction transaction = customer.beginTransaction("Bread", shop);
//        assertEquals(SALE, transaction.getType());
//    }



}
