/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author kaili
 */
public abstract class Account {
    // attributes
    protected String name;
    protected int accountNumber;
    protected double balance, interest, amount, limit = 0, total, usedLimit = 0; // total is balance including interest where applicable  
    
    // name setter and getter  
    public void setName(String newName) {
        name = newName;
    }
    public String getName() {
        return name;
    }
    // account number setter and getter
    public void setAccountNumber(int newAccountNumber) {
        accountNumber = newAccountNumber;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    // balance number setter and getter
    public void setBalance(double newBalance) {
        balance = newBalance;
    }
    public double getBalance() {
        return balance;
    }
    // interest number setter and getter
    public void setInterest(double newInterest) {
        interest = newInterest;
    }
    public double getInterest() {
        return interest;
    }
    // limit setter and getter
    public void setLimit(double newLimit) {
        limit = newLimit;
    }
    public double getLimit() {
        return limit;
    }
    // total setter and getter
    public void setTotal(double newTotal) {
        total = newTotal;
        // calculate total balance inc interest
        total = balance * interest;
    }
    public double getTotal() {
        return total;
    }
    // total setter and getter
    public void setUsedLimit(double newUsedLimit) {
        total = newUsedLimit;
        // calculate total balance inc interest
        total = balance * interest;
    }
    public double getUsedLimit() {
        return usedLimit;
    }
    
    // methods 
    public void printStatistics() {
        System.out.println("STATISTICS");
        System.out.println("Account name: " + name);
        System.out.println("Account number: " + accountNumber);
        System.out.println("Balance: " + String.format("%.2f", balance) + " $");
        System.out.printf("%n"); // new line 
    }
    
    public void printStatisticsInterest() {
        System.out.println("STATISTICS");
        System.out.println("Account name: " + name);
        System.out.println("Account number: " + accountNumber);
        System.out.println("Balance: " + String.format("%.2f", (balance * (interest / 100 + 1))) + " $");
        System.out.printf("%n"); // new line 
    }
    
    public double calculateTotal() {
        // calculate total balance inc interest
        total = balance * (interest / 100 + 1);
        return total;
    }
    
    public void calculateDeposit(String tWritten) {
        // convert text string of amount to double
        amount = Double.parseDouble(tWritten);
        
        // upd balance 
        balance += amount;
    }
    
    public void setDailyWithdrawalLimit(String tWritten) {
        // convert text string of amount to double
        amount = Double.parseDouble(tWritten);
        
        // call function to upd limit
        setLimit(amount);
    }
}





// ADD calculateInterest()
// ADD setDailyWithdrawalLimit()