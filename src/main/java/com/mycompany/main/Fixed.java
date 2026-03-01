/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author kaili
 */

public class Fixed extends Account {
    // variables
    private boolean contractReq = false;
    private final int contractPeriod = 35; 
    private int days;
    
    // constructor
    public Fixed(String name, int accountNumber, double balance, double intrest) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.interest = intrest;
    }
      
    public void checkContract(int current, double updTotal) {
        days = current;
        
        if (days >= contractPeriod) {
            contractReq = true;
            // check if contract has ended 
            if (contractReq == true) {
                // print update 
                System.out.println("You have cashed out: " + total + " $");
                // update balance 
                balance -= updTotal;
                // update total hard coded 
                total = 0;
            }
        } else {
            System.out.println("Sorry, the contract has not ended yet. You will get without intrest " + balance + " $");
        }
        System.out.printf("%n"); // new line 
    }
}
