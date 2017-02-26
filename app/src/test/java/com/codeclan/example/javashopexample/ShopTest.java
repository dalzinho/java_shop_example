package com.codeclan.example.javashopexample;

import org.junit.Before;
import org.junit.Test;

import static com.codeclan.example.javashopexample.TransactionType.SALE;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

/**
 * Created by user on 24/02/2017.
 */

public class ShopTest {

    private DebitCard debitCard;
    private CreditCard creditCard;
    private Customer customer;
    private Shop shop;
    private Console console;

    @Before
    public void setup(){
        debitCard = new DebitCard("First Direct", 1000.0);
        creditCard = new CreditCard("Nationwide", 1000.00);
        customer = new Customer("Lev Yashin");
        customer.addPaymentMethod(CardType.CREDIT, creditCard);
        customer.addPaymentMethod(CardType.DEBIT, debitCard);
        shop = new Shop("Univermag");
        shop.addItemToInventory("Kvas", 20.0);
        shop.addItemToInventory("Pivo", 40.0);
        shop.addItemToInventory("Kefir", 10.0);
        console = new Console();
    }

    @Test
    public void testCanAddItems(){
        assertEquals(3, shop.getInventory().size());
    }

    @Test
    public void testCanReturnValueFromSearchKey(){
        assertEquals(20.0, shop.getPrice("Kvas"), 0.01);
    }

    @Test
    public void testCanLogTransactionsInTransactionsLog(){
        shop.manageCCTransaction(TransactionType.SALE, customer, 120., console);
        shop.manageCCTransaction(TransactionType.REFUND, customer, 80., console);
        assertEquals(2, shop.getTransactionLog().size());
        assertEquals(-40, creditCard.getBalance(), 0.01);
        assertEquals(1040, shop.getBalance(), 0.01);
    }

    @Test
    public void testDebitTransactionsWorkToo(){
        shop.manageDCTransaction(TransactionType.SALE, customer, 100., console);
        assertEquals(900., customer.getDebitCard().getBalance());
    }
}

