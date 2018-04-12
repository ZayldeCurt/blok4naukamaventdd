package com.sda.bank;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.mockito.Mockito;

public class BankSteps {
    private Bank bank;
    private BankUser bankUser;
    private boolean usertInsertResult;
    private BankAccount bankAccount;
    private boolean accountInssertResult;
    private boolean depositInsertResult;
    private BankDatabase bankDatabase = new BankDatabase();

    @Given("^I mock bank database for this case$")
    public void iMockBankDatabaseForThisCase() {
        this.bankDatabase = Mockito.mock(BankDatabase.class);
        Mockito.when(bankDatabase.addBankUser(Mockito.any())).then(e -> true);
        Mockito.when(bankDatabase.createAccountFor(Mockito.any(),Mockito.anyString())).then(e->true);
        Mockito.when(bankDatabase.getAccountWithId(Mockito.anyString())).then(e->BankAccount.instanceOf(null,1000));
        Mockito.when(bankDatabase.deposit(Mockito.any(),Mockito.anyInt())).then(e->true);
    }

    @Given("^I initialize bank$")
    public void iInitializeBank(){
        this.bank = new Bank(bankDatabase);
    }


    @And("^I create user name is (.*) and user pesel is (.*)")
    public void iCreateUserNameIsNameAndUserPeselIsPesel(String arg0, String pesel) {
        bankUser = new BankUser(arg0,pesel);
    }

    @When("^I add user$")
    public void iAddUser() {
        usertInsertResult=bank.addBankUser(new BankUser(bankUser.getName(),bankUser.getPesel()));
    }




    @And("^I create account with id (.*)$")
    public void iAddToUserAccountWithId(String arg0) {
        bankAccount = new BankAccount(arg0);
    }
    @And("^I add account for user$")
    public void iAddForUserAccount() {
        accountInssertResult = bank.createAccountFor(bankUser, bankAccount.getId());
    }
    @And("^I deposit (.*) to account with id (.*)$")
    public void iDepositToAccountWithId(int arg0, String arg1) {
        depositInsertResult=bank.deposit(arg1,arg0);
    }

    @Then("^Account is not present in bank$")
    public void accounIsNotPresentInBank() {
        Assert.assertEquals(0,bank.numberOfAccount());
        Assert.assertFalse(accountInssertResult);
    }
    @Then("^User is(.*) present in bank$")
    public void userIsPresentInBank(String arg) {
        if(!arg.equals(" not")){
            Assert.assertTrue(usertInsertResult);
            Assert.assertEquals(1,bank.numberOfUsers());
        }
        else{
            Assert.assertFalse(usertInsertResult);
            Assert.assertNotEquals(2,bank.numberOfUsers());
        }
    }

    @Then("^Account is present in bank$")
    public void accounIsPresentInBank() {
        Assert.assertEquals(1,bank.numberOfAccount());
        Assert.assertTrue(accountInssertResult);
    }


    @Then("^User has only '(\\d+)' account in bank$")
    public void userHasOnlyAccountInBank(int arg0) {
        Assert.assertEquals(arg0,bank.getNumberOfAccountsFor(bankUser));
        Assert.assertFalse(accountInssertResult);
    }


    @Then("^Account with id (.*) has amount of (.*)$")
    public void accountWithIdHasAmountOf(String arg0, int arg1) {
        Assert.assertTrue(depositInsertResult);
        Assert.assertEquals(arg1,bank.getAccountWithId(arg0).getAmount());

    }


}
