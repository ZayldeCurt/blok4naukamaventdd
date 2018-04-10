package com.sda.calculator;

public class StringCalculator {
    public int calc(String numbers){
        String[] tabN = numbers.split(" : ");

        int a = Integer.valueOf(tabN[0]);
        int b = Integer.valueOf(tabN[1]);


        return a+b;
    }
}
