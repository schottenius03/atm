/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author kaili
 */
public class Atm implements ActionListener {
    // set up GUI
    private final JFrame frame;
    private final JPanel content, screen, numbers, choice, move;
    private final JLabel message, accNumber, accType, accInterest, accBalance, written;
    private final JButton withdraw, deposit, enquiry, help, cancel, enter;
    
    private double amount; // amount = money to move 
    private String tWritten = "";
    private final JButton buttons[];
    private final String label[] = {
        "7", "8", "9",
        "4", "5", "6",
        "1", "2", "3",
        "CLR", "0", "."
    };
    
    // create accounts 
    Savings sav = new Savings("Savings account", 183747430, 6000, 2.5, 500);
    Cheque che = new Cheque("Cheque account", 937562173, 1000);
    NetSaver net = new NetSaver("NetSaver account", 122365738, 3000, 5.1, 1000);
    Fixed fix = new Fixed("Fixed account", 17364837, 4000, 8);   
    
    // constructor 
    public Atm() {
        // create object frame with name ATM
        frame = new JFrame("ATM");
        // frame size 
        // prevent change of size
        frame.setResizable(true);
        
        // set panels 
        content = new JPanel();
        content.setLayout(new BorderLayout());
        content.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        screen = new JPanel();
        screen.setLayout(new GridLayout(6, 0));
        screen.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        numbers = new JPanel();
        numbers.setLayout(new GridLayout(4, 4));
        numbers.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 5));
        choice = new JPanel();
        choice.setLayout(new GridLayout(4, 0));
        choice.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        move = new JPanel();
        move.setLayout(new GridLayout(1, 2));
        
        // set labels 
        accNumber = new JLabel("Account number: ");
        accType = new JLabel("Account type: ");
        accInterest = new JLabel("Account Interest: ");
        accBalance = new JLabel("Available Balance: ");
        written = new JLabel("Amount: $");
        message = new JLabel();
        
        // set buttons
        buttons = new JButton[12];
        withdraw = new JButton("Withdraw");
        deposit = new JButton("Deposit");
        enquiry = new JButton("Balance Enquiry");
        help = new JButton("Help");
        cancel = new JButton("Cancel");
        enter = new JButton("Enter");
        
        // set button action
        withdraw.addActionListener(this);
        deposit.addActionListener(this);
        enquiry.addActionListener(this);
        help.addActionListener(this);
        cancel.addActionListener(this);
        enter.addActionListener(this);
        
        // add elements to screen panel 
        screen.add(message);
        screen.add(accNumber);
        screen.add(accType);
        screen.add(accInterest);
        screen.add(accBalance);
        screen.add(written);
        
        // add elements to numbers panel with new created button labelling same index from list
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(label[i]);
            // add action to each button 
            buttons[i].addActionListener(this);
            // add to panel 
            numbers.add(buttons[i]);
        }
        
        // add elements to choice panel
        choice.add(withdraw);
        choice.add(deposit);
        choice.add(enquiry);
        choice.add(help);
        
        // add elements to move panel 
        move.add(cancel);
        move.add(enter);
        
        // assign panels to content 
        content.add(screen, BorderLayout.NORTH);
        content.add(numbers, BorderLayout.WEST);
        content.add(choice, BorderLayout.CENTER);
        content.add(move, BorderLayout.SOUTH);
        
        switch (Profile.accountType) {
            case "Savings" -> {
                accNumber.setText(accNumber.getText() + sav.accountNumber);
                accType.setText(accType.getText() + sav.name);
                accInterest.setText(accInterest.getText() + sav.interest + "%");
                accBalance.setText(accBalance.getText() + String.format("%.2f", sav.calculateTotal()));
                break;
            }
            case "Cheque" -> {
                accNumber.setText(accNumber.getText() + che.accountNumber);
                accType.setText(accType.getText() + che.name);
                accInterest.setText(accInterest.getText() + "N/A");
                accBalance.setText(accBalance.getText() + String.format("%.2f", che.calculateTotal()));
                break;
            }
            case "NetSaver" -> {
                accNumber.setText(accNumber.getText() + net.accountNumber);
                accType.setText(accType.getText() + net.name);
                accInterest.setText(accInterest.getText() + net.interest + "%");
                accBalance.setText(accBalance.getText() + String.format("%.2f", net.calculateTotal()));
                break;
            }
            case "Fixed" -> {
                accNumber.setText(accNumber.getText() + fix.accountNumber);
                accType.setText(accType.getText() + fix.name);
                accInterest.setText(accInterest.getText() + fix.interest + "%");
                accBalance.setText(accBalance.getText() + String.format("%.2f", fix.calculateTotal()));
                break;
            }
        }

        // add content panel to frame 
        frame.add(content);
        // adapt frame size after elements
        frame.pack();
        // able to close window 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // make visible and in focus
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        
        // create new object ATM
        new Atm();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // save user's action
        String action = e.getActionCommand();
        
        // reset colour of messages 
        message.setForeground(Color.BLACK);
        accBalance.setForeground(Color.BLACK);
        // reset message label
        message.setText("");
        
        // determine user's action 
        if (action.matches("[1-9]")) { // click number
            // upd to written num
            written.setText(written.getText() + action);
            // add to text string of written 
            tWritten += action;
        } else if (action.matches(".")) { // click comma
            // upd to written num 
            written.setText(written.getText() + action);
            // add to text string of written 
            tWritten += action;
        } else if (action.matches("CLR")) { // click CLR
            // reset written label 
            written.setText("Amount: $");
            // reset text of written 
            tWritten = "";
        } else if (action.matches(withdraw.getText())) { // click withdraw 
            // convert text string of amount to double
            amount = Double.parseDouble(tWritten);
            
            switch (Profile.accountType) {
            case "Savings" -> {
                // check if balance is enough 
            if (amount <= sav.balance) {
                // check if within limit 
                if ((amount + sav.usedLimit) <= sav.limit) {
                    // check if within restrictions 
                    if (amount % 100 == 0 || amount % 50 == 0 || amount % 20 == 0) {
                        // upd usedLimit
                        sav.usedLimit += amount;
                        // upd balance 
                        sav.balance -= amount;
                        // print upd balance 
                        accBalance.setText("Available Balance: " + String.format("%.2f", sav.calculateTotal()));
                    } else {
                        // inform user through message label 
                        message.setText("Transfer failed due to note restrictions.");
                        // highlight colour in green
                        message.setForeground(Color.red);
                    }
                } else {
                    // inform user through message label 
                    message.setText("Transfer failed due to withdrawal limit.");
                    // highlight colour in green
                    message.setForeground(Color.red);
                }
            } else {
                // inform user through message label 
                message.setText("Transfer failed due to not enough funds.");
                // highlight colour in green
                message.setForeground(Color.red);
            }
            break;
            }
            case "Cheque" -> {
                // check if balance is enough 
                if (amount <= che.balance) {
                    if (amount % 100 == 0 || amount % 50 == 0 || amount % 20 == 0) {
                        // upd usedLimit
                        che.usedLimit += amount;
                        // upd balance 
                        che.balance -= amount;
                        // print upd balance 
                        accBalance.setText("Available Balance: " + String.format("%.2f", che.calculateTotal()));
                    } else {
                        // inform user through message label 
                        message.setText("Transfer failed due to note restrictions.");
                        // highlight colour in green
                        message.setForeground(Color.red);
                    }
                } else {
                    // inform user through message label 
                    message.setText("Transfer failed due to not enough funds.");
                    // highlight colour in green
                    message.setForeground(Color.red);
                }  
                break;
            }
            case "NetSaver" -> {
                // check if balance is enough 
                if (amount <= net.balance) {
                    // check if within limit 
                    if ((amount + net.usedLimit) <= net.limit) {
                        // check if within restrictions 
                        if (amount % 100 == 0 || amount % 50 == 0 || amount % 20 == 0) {
                            // upd usedLimit
                            net.usedLimit += amount;
                            // upd balance 
                            net.balance -= amount;
                            // print upd balance 
                            accBalance.setText("Available Balance: " + String.format("%.2f", net.calculateTotal()));
                        } else {
                            // inform user through message label 
                            message.setText("Transfer failed due to note restrictions.");
                            // highlight colour in green
                            message.setForeground(Color.red);
                        }
                    } else {
                        // inform user through message label 
                        message.setText("Transfer failed due to withdrawal limit.");
                        // highlight colour in green
                        message.setForeground(Color.red);
                    }
                } else {
                    // inform user through message label 
                    message.setText("Transfer failed due to not enough funds.");
                    // highlight colour in green
                    message.setForeground(Color.red);
                }
                break;
            }
            case "Fixed" -> {
                // check if balance is enough 
                if (amount <= fix.balance) {
                    // check if within restrictions 
                    if (amount % 100 == 0 || amount % 50 == 0 || amount % 20 == 0) {
                        // upd usedLimit
                        fix.usedLimit += amount;
                        // upd balance 
                        fix.balance -= amount;
                        // print upd balance 
                        accBalance.setText("Available Balance: " + String.format("%.2f", fix.calculateTotal()));
                    } else {
                        // inform user through message label 
                        message.setText("Transfer failed due to note restrictions.");
                        // highlight colour in green
                        message.setForeground(Color.red);
                    }
                } else {
                    // inform user through message label 
                    message.setText("Transfer failed due to not enough funds.");
                    // highlight colour in green
                    message.setForeground(Color.red);
                } 
                break;
            }
            }

        } else if (action.matches(deposit.getText())) { // click deposit 
            // determine account 
            switch (Profile.accountType) {
            case "Savings" -> {
                // call function
                sav.calculateDeposit(tWritten);
                // print new balance 
                accBalance.setText("Available Balance: " + String.format("%.2f", sav.calculateTotal()));
                break;
                }
            case "Cheque" -> {
                // call function
                che.calculateDeposit(tWritten);
                // print new balance 
                accBalance.setText("Available Balance: " + String.format("%.2f", che.calculateTotal())); 
                break;
                }
            case "NetSaver" -> {
                // call function
                net.calculateDeposit(tWritten);
                // print new balance 
                accBalance.setText("Available Balance: " + String.format("%.2f", net.calculateTotal())); 
                break;
                }
            case "Fixed" -> {
                // call function
                fix.calculateDeposit(tWritten);
                // print new balance 
                accBalance.setText("Available Balance: " + String.format("%.2f", fix.calculateTotal()));  
                break;
                }
            }

            // reset values 
            amount = 0; 
            amount = 0;
            written.setText("Amount: $");
            tWritten = "";
        } else if (action.matches(enquiry.getText())) { // click enquiry
            // highlight balance red
            accBalance.setForeground(Color.red);
        } else if (action.matches(help.getText())) { // click help
            // check if account is eligable for setting new withdrawal limit 
            if (Profile.accountType == "Cheque" || Profile.accountType == "Fixed" ) {
                message.setText("This account is not eligable to change withdrawal limit.");
            } else {
                // inform the user through message label 
                message.setText("Please enter the new withdrawal limit and click Enter");
            }
        } else if (action.matches(cancel.getText())) { // click cancel
            // close window 
            //dispose();
            // create new object of profile 
            new Profile();
            // reset values 
            amount = 0; 
            amount = 0;
            written.setText("Amount: $");
            tWritten = "";
        } else if (action.matches(enter.getText())) { // click enter
            // determine account 
            switch (Profile.accountType) {
            case "Savings" -> {
                // call function 
                sav.setDailyWithdrawalLimit(tWritten);
                // inform user through message label 
                message.setText("New withdrawal limit has been set.");
                // highlight colour in green
                message.setForeground(Color.green);
                break;
            }
            case "NetSaver" -> {
                // call function 
                net.setDailyWithdrawalLimit(tWritten);
                // inform user through message label 
                message.setText("New withdrawal limit has been set.");
                // highlight colour in green
                message.setForeground(Color.green);
                break;
            }
            default -> {
                message.setText("This account is not eligable to change withdrawal limit!");
                break;
            }
            }
        }
    }
}
