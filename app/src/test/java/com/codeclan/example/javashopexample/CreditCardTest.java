package com.codeclan.example.javashopexample;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 24/02/2017.
 */

public class CreditCardTest {

    CreditCard creditCard;

    @Before
    public void setUp(){
        creditCard = new CreditCard("American Express", 1000.00);
    }

    @Test
    public void testCanDeductFromBalance(){
        creditCard.deduct(100.00);
        assertEquals(-100.00, creditCard.getBalance());
    }

    @Test
    public void testCanNotExceedLimit(){
        creditCard.deduct(999.00);
        assertEquals(false, creditCard.willNotExceedLimit(2.0));
        assertEquals("Unable to complete transaction", creditCard.commitPurchase(2.0));
    }


}


