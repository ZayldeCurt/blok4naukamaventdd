package com.sda.service;

public class WriterService {
    public String write(String name){
        if(name == null)
        {
            name = "my friend";
        }
        return "Hello, "+name+"!";
    }




}
