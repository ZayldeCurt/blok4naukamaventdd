package com.sda.calculator;

public class Calculator {
    public int sum(int a, int b){
        return a+b;
    }
    public int substrack(int a, int b){
        return Math.subtractExact(a,b);
    }
    public int divide(int a, int b){
        return a/b;
    }
    public int multiple(int a,int b){
        return a*b;
    }
}
