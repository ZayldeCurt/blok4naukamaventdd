package com.sda.service;

import org.apache.commons.lang3.StringUtils;

public class WriterService {
    public String write(String name){

        return prefix(name)+content(name)+suffix(name);
    }

    private boolean isCapitalizedName(String name){
        return StringUtils.isNotEmpty(name) && name.toUpperCase().equals(name);
    }

    private String prefix(String name) {
        return isCapitalizedName(name) ? "HELLO, " : "Hello, ";
    }

    private String content(String name) {
        return StringUtils.isEmpty(name) ? "my friend":name;
    }

    private String suffix(String name) {
        return isCapitalizedName(name) ? "!":".";
    }


}
