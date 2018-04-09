package com.sda.service;

import org.apache.commons.lang3.StringUtils;

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
            StringBuilder tmp=new StringBuilder();
            tmp.append(names[0]);
            if(names.length>1){
                for (int i = 1; i < names.length-1; i++) {
                    tmp.append(", ");
                    tmp.append(names[i]);
                }
                tmp.append(" and ");
                tmp.append(names[names.length-1]);

            }
            return tmp.toString();
        }
    }

    private String suffix(String name) {
        return isCapitalizedName(name) ? "!":".";
    }


}
