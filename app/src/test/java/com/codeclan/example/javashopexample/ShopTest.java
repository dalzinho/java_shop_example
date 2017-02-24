package com.codeclan.example.javashopexample;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 24/02/2017.
 */

public class ShopTest {

    private DebitCard debitCard;
    private CreditCard creditCard;
    private Payable[] cardsHeld;
    private Customer customer;
    private Shop shop;

    @Before
    public void setup(){
        debitCard = new DebitCard("First Direct", 100.0);
        creditCard = new CreditCard("Nationwide", 1000.00);
        Payable[] cardsHeld = {debitCard, creditCard};
        customer = new Customer("Lev Yashin", cardsHeld);
        shop = new Shop("Univermag");
        shop.addItemToInventory("Kvas", 20.0);
        shop.addItemToInventory("Pivo", 40.0);
        shop.addItemToInventory("Kefir", 10.0);
    }

    @Test
    public void testCanAddItems(){
        assertEquals(3, shop.getInventory().size());
    }

    @Test
    public void testCanReturnValueFromSearchKey(){
        assertEquals(20.0, shop.getPrice("Kvas"), 0.01);
    }
}

