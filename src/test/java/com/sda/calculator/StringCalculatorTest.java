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

        Assert.assertEquals(5,stringCalculator.calc( "2:3"));
        Assert.assertEquals(11,stringCalculator.calc( "5:6"));
        Assert.assertEquals(5,stringCalculator.calc( "2;3"));
        Assert.assertEquals(5,stringCalculator.calc( "2,3"));
    }

    @Test
    public void testNullNumber(){
        //given
        String number = null;

        //when
        int result = stringCalculator.calc(number);

        //then
        Assert.assertEquals(0,result);
    }

    @Test
    public void testBlankNumber(){
        //given
        String number = "";

        //when
        int result = stringCalculator.calc(number);

        //then
        Assert.assertEquals(0,result);
    }

    @Test
    public void testMultiNumber(){
        //given
        String number = "2:3:4";

        //when
        int result = stringCalculator.calc(number);

        //then
        Assert.assertEquals(9,result);
    }

    @Test
    public void testSpaceNumber(){
        //given
        String number = "2 :: 3 : 4";

        //when
        int result = stringCalculator.calc(number);

        //then
        Assert.assertEquals(9,result);
    }

    @Test
    public void testOneNumber(){
        //given
        String number = "2";

        //when
        int result = stringCalculator.calc(number);

        //then
        Assert.assertEquals(2,result);
    }




}
