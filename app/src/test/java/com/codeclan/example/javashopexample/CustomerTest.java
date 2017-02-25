package com.codeclan.example.javashopexample;

import org.junit.Before;
import org.junit.Test;

import static com.codeclan.example.javashopexample.CardType.CREDIT;
import static com.codeclan.example.javashopexample.CardType.DEBIT;
import static com.codeclan.example.javashopexample.TransactionType.SALE;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
        // initialise cards
        debitCard = new DebitCard("First Direct", 100.0);
        creditCard = new CreditCard("Nationwide", 1000.00);

        //initialise customer
        customer = new Customer("Lev Yashin");
        customer.addPaymentMethod(CREDIT, creditCard);
        customer.addPaymentMethod(DEBIT, debitCard);

        //initialise shop
        shop = new Shop("Univermag");

        shop.addItemToInventory("Bread", 20.0);
        shop.addItemToInventory("Milk", 40.0);
        shop.addItemToInventory("Eggs", 10.0);
    }

    @Test
    public void testCanAddCard(){
        customer.addPaymentMethod(DEBIT, debitCard);
        assertEquals(2, customer.getPaymentMethods().size());
    }

    @Test
    public void testCanAccessCreditCard(){
        assertEquals(1000.00, customer.getCreditCard().getCreditLimit(), 0.01);
    }

    @Test
    public void testBeginPurchaseReturnsPrice(){
        assertEquals(20.0, customer.beginPurchase(shop, "Bread"));
    }

//    @Test
//    public void testCustomerCanInitiateTransaction(){
//        Transaction sale = customer.beginTransaction("Bread", shop);
//        assertEquals(SALE, sale.getType());
//    }



}
