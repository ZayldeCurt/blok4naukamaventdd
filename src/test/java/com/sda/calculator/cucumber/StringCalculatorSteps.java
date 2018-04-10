package com.sda.calculator.cucumber;

import com.sda.calculator.StringCalculator;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class StringCalculatorSteps {
    private String value;
    private StringCalculator calc;
    private int result;

    @Given("^I initialize stringCalculator$")
    public void i_initialize_stringCalculator(){
        this.calc=new StringCalculator();
    }
    @Given("^I pass single number value$")
    public void I_pass_single_number_value(){
        this.value = "5";
    }

    @When("^I trigger calculate function$")
    public void I_trigger_calculate_functio(){
       this.result = calc.calc(value);
    }


    @And("^I pass null value$")
    public void i_pass_null_value(){
        this.value = null;
    }

    @Then("^I get (\\d+) as a result$")
    public void i_get_as_a_esult(int arg0){
        Assert.assertEquals(arg0,result);
    }

    @And("^I pass blank value$")
    public void i_pass_blank_value(){
        this.value = "";
    }


    @And("^I pass two (.*) value$")
    public void iPassTwoValue(String arg) {
        this.value = arg;
    }

    @And("^I pass multiple (.*) value$")
    public void iPassMultipleValue(String arg) {
        this.value = arg;
    }
}
