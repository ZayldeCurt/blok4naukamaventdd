package com.sda.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bank {

    private BankDatabase bankDatabase;

    public Bank(BankDatabase bankDatabase){
        this.bankDatabase = bankDatabase;
    }

    public boolean deposit(String bankAccount,int ammount){

        return bankDatabase.deposit(bankAccount,ammount);
    }
    public boolean addBankUser(BankUser bankUser){
        return bankDatabase.addBankUser(bankUser);
    }
    public boolean createAccountFor(BankUser bankUser, String accountname){
        return bankDatabase.createAccountFor( bankUser,  accountname);
    }

    public List<BankAccount> getAccountOf(BankUser bankUser){
        return bankDatabase.getAccountOf(bankUser);
    }

    public int numberOfUsers(){
        return bankDatabase.numberOfUsers();
    }

    public int numberOfAccount() {
        return bankDatabase.numberOfAccount();
    }

    public int getNumberOfAccountsFor(BankUser bankUser) {
        return bankDatabase.getNumberOfAccountsFor(bankUser);
    }

    public BankAccount getAccountWithId(String arg1) {
        return bankDatabase.getAccountWithId(arg1);
    }
}
