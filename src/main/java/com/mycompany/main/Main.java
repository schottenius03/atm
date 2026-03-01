/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author kaili
 */
public class Main extends JFrame implements ActionListener {
    // setup 
    private final JPanel p;
    private final JLabel lUsername, lPassword, message;
    // text boxes
    private final JTextField tUsername; 
    private final JPasswordField tPassword;
    // button 
    private final JButton login;
    // saved user 
    private final String username = "Sven";
    private final String password = "Password123";
    // user input 
    private String iUsername, iPassword;

    // constructor 
    public Main() {
        // setup frame 
        setTitle("ATM");
        setSize(300, 200);
        setResizable(false);

        // panel to make a nice border 
        p = new JPanel();
        p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        p.setLayout(new GridLayout(6, 0));

        // labels 
        lUsername = new JLabel("Username: ");
        lPassword = new JLabel("Password: ");
        message = new JLabel();
        message.setForeground(Color.RED);

        // text boxes
        tUsername = new JTextField();
        tPassword = new JPasswordField();

        // button 
        login = new JButton("Login");
        login.addActionListener(this);

        // add elements to the panel 
        p.add(message);
        p.add(lUsername);
        p.add(tUsername);
        p.add(lPassword);
        p.add(tPassword);
        p.add(login);

        // add panel to the frame 
        add(p);

        // setup frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // save usernames input 
            iUsername = tUsername.getText();
            iPassword = tPassword.getText();

            // check if username and password is correct 
            if (iUsername.equals(username) && iPassword.equals(password)) {
                // close window 
                dispose();
                // create new object profile
                new Profile();
            } else {
                message.setText("Wrong username or password, try again");
            }
        } catch(Exception f) {
            message.setText("Error, something went wrong, please try again.");
        }
    }
}
