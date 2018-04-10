package com.sda.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {


    private StringCalculator stringCalculator;

    @Before
    public void init(){
        this.stringCalculator = new StringCalculator();
    }
    @Test
    public void testCalc(){
        //given
        String numbers = "2 : 3";

        //when
        int result = stringCalculator.calc(numbers);

        //then
        Assert.assertEquals(5,result);
    }
}
