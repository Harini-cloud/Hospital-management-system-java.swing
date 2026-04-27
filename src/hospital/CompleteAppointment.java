package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class CompleteAppointment extends JFrame implements ActionListener {

    JTextField token;

    public CompleteAppointment() {
        setTitle("Complete Appointment");
        setLayout(new GridLayout(2,2));
        setSize(300,150);

        token = new JTextField();
        add(new JLabel("Token No")); add(token);

        JButton btn = new JButton("Complete");
        btn.addActionListener(this);
        add(btn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement pst = con.prepareStatement(
                "UPDATE appointments SET status='Completed' WHERE token_no=?"
            );

            pst.setInt(1, Integer.parseInt(token.getText()));
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Appointment Completed");
            dispose(); new Dashboard();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
