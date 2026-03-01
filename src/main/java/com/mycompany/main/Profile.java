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
public class Profile extends JFrame implements ActionListener {
     // setup 
    private final JPanel p;
    private final JLabel choose;
    private final JButton bSavings, bCheque, bNetSaver, bFixed, bExit;

    // variables - public so atm file can access
    public static String accountType;
    
    // name setter and getter  
    public void setAccountType(String newAccountType) {
        accountType = newAccountType;
    }
    public String getAccountType() {
        return accountType;
    }

    // constructor 
    public Profile() {
        // setup 
        setTitle("ATM");
        setResizable(false);

        // panel 
        p = new JPanel();
        p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        p.setLayout(new GridLayout(6, 0));

        // labels 
        choose = new JLabel("Choose an account: ");

        // create buttons  
        bSavings = new JButton("Savings");
        bCheque = new JButton("Cheque");
        bNetSaver = new JButton("NetSaver"); 
        bFixed = new JButton("Fixed"); 
        bExit = new JButton("Exit");

        // add action to buttons 
        bSavings.addActionListener(this);
        bCheque.addActionListener(this);
        bNetSaver.addActionListener(this);
        bFixed.addActionListener(this);
        bExit.addActionListener(this);

        // add elements to panel 
        p.add(choose);
        p.add(bSavings);
        p.add(bCheque);
        p.add(bNetSaver);
        p.add(bFixed);
        p.add(bExit);

        // add panel to frame 
        add(p);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new Profile();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // store action read
        String action = e.getActionCommand();
        
        // determine choice based on user's action with label from button
        if (action.matches(bSavings.getText()) || action.matches(bCheque.getText()) || action.matches(bNetSaver.getText()) || action.matches(bFixed.getText())) {
            // set accountType to the label of the button 
            setAccountType(action);
            // close window 
            dispose();
            // create new object of atm 
            new Atm();
        } else if (action.matches(bExit.getText())) { // exit button
            // close window 
            dispose();
            // create new object of main 
            new Main();
        }
    }
}
