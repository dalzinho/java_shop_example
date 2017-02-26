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

    public String getInput(){
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }
}
