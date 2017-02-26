package com.codeclan.example.javashopexample;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by user on 25/02/2017.
 */

public class Console {

    ArrayList<String> recentEvents;
    Scanner scanner;


    public void show(String string){
        System.out.println(string);
    }

    public void mainMenu(){
        show("(S)ale");
        show("(R)efund");
        show("(T)ransaction log");
    }

    public String getInput(){
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public void saleMenu(){
        show("Please enter sale amount");
    }

    public void refundMenu(){
        show("hola compinche");
    }

    public void transactionLog(){
        show("hola compinche");
    }

    public void mainMenuInput(String input){
        switch(input){
            case "s": saleMenu();
                break;
            case "r": refundMenu();
                break;
            case "t": transactionLog();
                break;
            default: show("enter a valid key");
                break;
        }
    }
    
}
