package com.sda.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankDatabase {

    private Map<BankUser,List<BankAccount>> database;

    public BankDatabase(){
        this.database = new HashMap<>();
    }
    public boolean addBankUser(BankUser bankUser){
        if(database.containsKey(bankUser))
            return false;
        else{
            this.database.put(bankUser,new ArrayList<BankAccount>());
            return true;
        }
    }
    public boolean createAccountFor(BankUser bankUser, String accountname){
        if(!database.containsKey(bankUser)){
            return false;
        }
        else{
            List<BankAccount> bankAccounts = database.get(bankUser);
            BankAccount tmpBankAccount = new BankAccount(accountname);
            if(bankAccounts.contains(tmpBankAccount)){
                return false;
            }
            bankAccounts.add(new BankAccount(accountname));
            return true;

        }
    }

    public List<BankAccount> getAccountOf(BankUser bankUser){
        return database.get(bankUser);
    }

    public int numberOfUsers(){
        return database.size();
    }

    public int numberOfAccount() {
        return database.entrySet()
                .stream()
                .mapToInt(e->e.getValue().size())
                .sum();
    }

    public int getNumberOfAccountsFor(BankUser bankUser) {
        return getAccountOf(bankUser).size();
    }

    public BankAccount getAccountWithId(String arg1) {
        return null;
    }

    public boolean deposit(String bankAccount, int ammount) {
        throw new RuntimeException();
    }
}
