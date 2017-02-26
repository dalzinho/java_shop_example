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


    public String selectCardType(){
//        scanner = new Scanner(System.in);
        show("(C)redit Card");
        show("(D)ebit Card");
        return getInput();
    }

    public void cardChoice(String string){

    }

    public void mainMenu(){
        show("New (S)ale");
        show("New (R)efund");
        show("(T)ransaction log");
        show("Shop (B)alance");
        mainMenuInput(getInput());

    }

    public String getInput(){
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public void saleMenu(){
        show("Please enter sale amount");
        String input = scanner.nextLine();
    }

    public void refundMenu(){
        show("hola compinche");
    }

    public void transactionLog(){
        show("hola compinche");
    }

    public void shopBalance(){
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
            case "b": shopBalance();
                break;
            default: show("enter a valid key");
                break;
        }
    }

}
