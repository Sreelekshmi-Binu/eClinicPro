package com.Int.ust.ui;

import javax.swing.*;
import java.awt.event.*;
import java.util.Date;
import com.Int.ust.bean.DoctorBean;
import com.Int.ust.service.Administrator;
import com.Int.ust.service.AdminServiceImpl;

public class AdminUI extends JFrame {

    // Input fields
    JTextField idField, nameField, dobField, dojField, genderField, qualField, specField, expField;
    JTextField streetField, locField, cityField, stateField, pinField, contactField, emailField;
    JButton addDoctorBtn;
    Administrator admin;

    public AdminUI() {

        admin = new AdminServiceImpl();

        // labels and fields
        add(new JLabel("Doctor ID:"));
        idField = new JTextField(10);
        add(idField);

        add(new JLabel("Name:"));
        nameField = new JTextField(10);
        add(nameField);

        add(new JLabel("Date of Birth (yyyy-mm-dd):"));
        dobField = new JTextField(10);
        add(dobField);

        add(new JLabel("Date of Joining (yyyy-mm-dd):"));
        dojField = new JTextField(10);
        add(dojField);

        add(new JLabel("Gender:"));
        genderField = new JTextField(5);
        add(genderField);

        add(new JLabel("Qualification:"));
        qualField = new JTextField(10);
        add(qualField);

        add(new JLabel("Specialization:"));
        specField = new JTextField(10);
        add(specField);

        add(new JLabel("Years of Experience:"));
        expField = new JTextField(5);
        add(expField);

        add(new JLabel("Street:"));
        streetField = new JTextField(10);
        add(streetField);

        add(new JLabel("Location:"));
        locField = new JTextField(10);
        add(locField);

        add(new JLabel("City:"));
        cityField = new JTextField(10);
        add(cityField);

        add(new JLabel("State:"));
        stateField = new JTextField(10);
        add(stateField);

        add(new JLabel("Pincode:"));
        pinField = new JTextField(10);
        add(pinField);

        add(new JLabel("Contact No:"));
        contactField = new JTextField(10);
        add(contactField);

        add(new JLabel("Email:"));
        emailField = new JTextField(10);
        add(emailField);

        // button
        addDoctorBtn = new JButton("Add Doctor");
        addDoctorBtn.setPreferredSize(new java.awt.Dimension(150, 40));
        add(addDoctorBtn);

        // layout
        setLayout(new java.awt.FlowLayout());
        setVisible(true);

        // button click logic
        addDoctorBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    // collect input
                    String id = idField.getText();
                    String name = nameField.getText();
                    String gender = genderField.getText();
                    String qual = qualField.getText();
                    String spec = specField.getText();
                    int exp = Integer.parseInt(expField.getText());
                    String street = streetField.getText();
                    String loc = locField.getText();
                    String city = cityField.getText();
                    String state = stateField.getText();
                    String pin = pinField.getText();
                    String contact = contactField.getText();
                    String email = emailField.getText();

                    // for now, not parsing date from text (use current date)
                    DoctorBean doc = new DoctorBean(
                            id, name, new Date(), new Date(),
                            gender, qual, spec, exp,
                            street, loc, city, state, pin, contact, email
                    );

                    String msg = admin.addDoctor(doc);
                    JOptionPane.showMessageDialog(null, msg);

                    // show list of all doctors in console
                    for (DoctorBean d : admin.viewAllDoctors()) {
                        System.out.println(
                            d.getDoctorID() + " | " +
                            d.getDoctorName() + " | " +
                            d.getSpecialization() + " | " +
                            d.getCity()
                        );
                    }

                    // clear fields
                    idField.setText(""); nameField.setText(""); dobField.setText(""); dojField.setText("");
                    genderField.setText(""); qualField.setText(""); specField.setText(""); expField.setText("");
                    streetField.setText(""); locField.setText(""); cityField.setText(""); stateField.setText("");
                    pinField.setText(""); contactField.setText(""); emailField.setText("");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Please check your inputs!");
                }
            }
        });
    }

    public static void main(String[] args) {
        new AdminUI();
    }
}
