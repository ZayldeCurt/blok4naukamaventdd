package com.sda.calculator;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StringCalculator {
    public int calc(String numbers){
        if(StringUtils.isBlank(numbers)){
            return 0;
        }
        int result=0;
        String[] tabN = StringUtils.deleteWhitespace(numbers).split("\\p{Punct}+");

        return Arrays.stream(tabN).mapToInt(e->Integer.valueOf(e)).sum();
    }
}
