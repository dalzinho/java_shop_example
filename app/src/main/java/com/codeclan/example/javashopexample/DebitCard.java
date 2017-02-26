package com.codeclan.example.javashopexample;

/**
 * Created by user on 24/02/2017.
 */

public class DebitCard implements Payable {

    String provider;
    Double balance;

    //constructor
    public DebitCard(String provider, Double balance){
        this.provider = provider;
        this.balance = balance;
    }

    //getters

    public String getProvider() {
        return provider;
    }

    public Double getBalance() {
        return balance;
    }

    //mair methods
    public void deduct(Double amount){
        this.balance -= amount;
    }

    public boolean willNotExceedLimit(Double amount){
        return this.balance - amount > 0;
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
