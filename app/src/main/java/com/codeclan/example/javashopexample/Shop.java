package com.codeclan.example.javashopexample;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 24/02/2017.
 */

public class Shop {

    private String shopName;
    private ArrayList<Transaction> transactions;
    private HashMap inventory;
    private String item;
    private Double price;

    public Shop(String shopName){
        this.shopName = shopName;
        this.transactions = new ArrayList<Transaction>();
        this.inventory = new HashMap();
    }

    public void addItemToInventory(String addItem, Double addPrice){
        inventory.put(addItem, addPrice);
    }

    public HashMap getInventory() {
        return inventory;
    }

    public Double getPrice(String searchKey){
        return (Double) inventory.get(searchKey);
    }
}
