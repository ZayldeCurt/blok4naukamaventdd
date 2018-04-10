package com.sda.calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.IntStream;

public class StringCalculator {
    public int calc(String numbers){
        if(StringUtils.isBlank(numbers)){
            return 0;
        }
        int result=0;
        String[] tabN = numbers.split("\\p{Punct}");
        for(String element:tabN){
            result+=Integer.valueOf(StringUtils.deleteWhitespace(element));
        }


        return result;
    }
}
