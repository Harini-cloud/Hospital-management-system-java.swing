package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddPatient extends JFrame implements ActionListener {

    JTextField id, name, age, contact;

    public AddPatient() {
        setTitle("Add Patient");
        setLayout(new GridLayout(5,2));
        setSize(300,250);

        id = new JTextField();
        name = new JTextField();
        age = new JTextField();
        contact = new JTextField();

        add(new JLabel("ID")); add(id);
        add(new JLabel("Name")); add(name);
        add(new JLabel("Age")); add(age);
        add(new JLabel("Contact")); add(contact);

        JButton btn = new JButton("Add");
        btn.addActionListener(this);
        add(btn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO patients VALUES (?, ?, ?, ?)"
            );
            pst.setInt(1, Integer.parseInt(id.getText()));
            pst.setString(2, name.getText());
            pst.setInt(3, Integer.parseInt(age.getText()));
            pst.setString(4, contact.getText());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Patient Added");
            dispose(); new Dashboard();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
