package com.sda.service.bookstore;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class BookstoreSteps {
    private Book book;
    private Bookstore bookstore;
    private int result;


    @Given("^I initialize bookstore$")
    public void iInitializeoBokstore(){
        this.bookstore  =new Bookstore();
    }


    @And("^I pass create book$")
    public void iPassCreateBook(){
        this.book = new Book("Tytuł",123,"Jakiś","coś");
    }

    @When("^I add book to bookstore$")
    public void iAddBookToBookstore(){
        bookstore.add(book);
        result = bookstore.getBooks().size();
    }

    @Then("^Book ist present in bookstore$")
    public void bookIstPresentInBookstore(){
        Assert.assertEquals(1,result);
    }

    @And("^I change title$")
    public void iChangeTitle(){
        //bookstore.getBooks().get(0).setTitle("nowy tytuł");
        bookstore.upadateBook(book,"nowy tytuł");
    }

    @Then("^Title is changed$")
    public void titleIsChanged() {
        Assert.assertEquals("nowy tytuł",bookstore.getBooks().get(0).getTitle());
    }
}
