package com.codeclan.example.javashopexample;

import org.junit.Before;
import org.junit.Test;

import static com.codeclan.example.javashopexample.TransactionType.REFUND;
import static com.codeclan.example.javashopexample.TransactionType.SALE;
import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 24/02/2017.
 */

public class TestTransaction {

    Shop shop;
    Customer customer;
    DebitCard debitCard;
    CreditCard creditCard;
    Transaction sale;
    Transaction refund;

    @Before
    public void setup(){
        shop = new Shop("Ikea");
        debitCard = new DebitCard("First Direct", 100.0);
        creditCard = new CreditCard("Nationwide", 1000.00);
        Payable[] cardsHeld = {debitCard, creditCard};
        customer = new Customer("Basil Brush");
        sale = new Transaction(SALE, customer, 200.00);
        refund = new Transaction(REFUND, customer, 200.00);
    }

    @Test
    public void testCanDeductFromCreditCardBalance(){
        sale.adjustCreditCardBalance(creditCard);
        assertEquals(-200, creditCard.getBalance(), 0.01);
    }

    @Test
    public void testCanIncrementShopBalance(){
        sale.adjustShopBalance(shop);
        assertEquals(1200, shop.getBalance(), 0.01);
    }

    @Test
    public void testControlSaleDoesAsItShould(){
        sale.enact(creditCard, shop);
        assertEquals(-200, creditCard.getBalance(), 0.01);
        assertEquals(1200, shop.getBalance(), 0.01);
    }

    @Test
    public void testRefundIncrementsCardBalance(){
        refund.adjustCreditCardBalance(creditCard);
        assertEquals(200, creditCard.getBalance(), 0.01);
    }

    @Test
    public void testRefundDeductsShopBalance(){
        refund.adjustShopBalance(shop);
        assertEquals(800, shop.getBalance(), 0.01);
    }

//    @Test
//    public void
}
