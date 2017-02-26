package com.codeclan.example.javashopexample;

import static com.codeclan.example.javashopexample.CardType.CREDIT;

/**
 * Created by user on 24/02/2017.
 */

public class CreditCard implements Payable {

    String provider;
    Double balance;
    Double creditLimit;


    public CreditCard(String provider, Double creditLimit){

        this.provider = provider;
        this.balance = 0.0;
        this.creditLimit = creditLimit;
    }

    public String getProvider() {
        return provider;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void deduct(Double amount){
        this.balance -= amount;
    }

    public boolean willNotExceedLimit(Double amount){
        return this.balance - amount > (this.creditLimit * -1);
    }

    public String reportCompleteTransaction(){
        return "Transaction Successful";
    }

    public String reportUnsuccessfulTransaction(){
        return "Unable to complete transaction";
    }

    public String commitPurchase(Double amount){
        String result = null;
        if(willNotExceedLimit(amount)){
            deduct(amount);
            result = reportCompleteTransaction();
        }
        else{
            result = reportUnsuccessfulTransaction();
        }
        return result;
    }
}
