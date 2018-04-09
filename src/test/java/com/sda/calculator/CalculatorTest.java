package com.sda.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

    private Calculator calculator;

    @Before
    public void init(){
        calculator = new Calculator();
    }


    @Test
    public void testAdd(){
//        //given
//        Calculator calculator = new Calculator();
//        już nie potrzebne bo mamy before i init

        //when
        int sum= calculator.sum(3,5);

        //then
        Assert.assertEquals("Result add is not 8",8,sum);
    }
    @Test
    public void testMulti(){
        //when
        int multiple = calculator.multiple(3,5);

        //then
        Assert.assertEquals("Result multi is not 15",15,multiple);
    }
    @Test
    public void testDivide(){

        Assert.assertEquals("Result divi is not 2",2,calculator.divide(10,5));
        Assert.assertEquals("Result divi is not 3",3,calculator.divide(15,5));
        Assert.assertEquals("Result divi is not 4",4,calculator.divide(20,5));
    }
    @Test
    public void testSUB(){

        //when
        int substract = calculator.substrack(3,5);

        //then
        Assert.assertEquals("Result sub is not -2",-2,substract);
    }

}
