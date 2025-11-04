package com.Int.ust.ui;

import javax.swing.*;
import java.awt.event.*;

public class LoginUi extends JFrame {

    JTextField idField;
    JPasswordField passField;
    JButton loginBtn;

    public LoginUi() {

        // create components
        idField = new JTextField("Enter Admin ID");
        passField = new JPasswordField("AD-001");
        loginBtn = new JButton("Login");

        // add to frame
        add(idField);
        add(passField);
        add(loginBtn);
        setLayout(new java.awt.FlowLayout());
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText();
                String password = new String(passField.getPassword());

                if (id.equals("AD-001") && password.equals("AD-001")) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    new AdminUI(); 
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid ID or Password!");
                }
            }
        });

        // show frame
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginUi();
    }
}
