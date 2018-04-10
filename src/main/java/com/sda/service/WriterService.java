package com.sda.service;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WriterService {
    public String write(String name){

        return prefix(name)+content(name)+suffix(name);
    }

    private boolean isCapitalizedName(String name){
        return StringUtils.isNotBlank(name) && name.toUpperCase().equals(name);
    }

    private String prefix(String name) {
        return isCapitalizedName(name) ? "HELLO, " : "Hello, ";
    }

    private String content(String name) {
        String[] names;
        if(StringUtils.isBlank(name)){
            return "my friend";
        }
        else{
            names = StringUtils.split(StringUtils.remove(name," "),",");
            StringBuilder builder=new StringBuilder();
            builder.append(names[0]);
            if(names.length>1){
                IntStream.range(1, names.length)
                        .forEach(i -> {
                            builder.append(i==names.length-1 ? (!isCapitalizedName(name) ? " and " : " AND ") : ", ")
                                   .append(names[i]);//.toString();
                        });
            }
            return builder.toString();
        }
    }

    private String suffix(String name) {
        return isCapitalizedName(name) ? "!":".";
    }


}
