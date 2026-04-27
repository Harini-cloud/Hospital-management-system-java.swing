package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;

public class BookAppointment extends JFrame implements ActionListener {

    JTextField patientId, doctorId;

    public BookAppointment() {
        setTitle("Book Appointment");
        setLayout(new GridLayout(3,2));
        setSize(300,150);

        patientId = new JTextField();
        doctorId = new JTextField();

        add(new JLabel("Patient ID")); add(patientId);
        add(new JLabel("Doctor ID")); add(doctorId);

        JButton btn = new JButton("Book");
        btn.addActionListener(this);
        add(btn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try (Connection con = DBConnection.getConnection()) {

            // generate token (queue position)
            ResultSet rs = con.createStatement().executeQuery(
                "SELECT MAX(token_no) FROM appointments"
            );
            int token = 1;
            if (rs.next() && rs.getInt(1) != 0) {
                token = rs.getInt(1) + 1;
            }

            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO appointments (patient_id, doctor_id, appointment_date, token_no, status) VALUES (?, ?, ?, ?, 'Waiting')"
            );

            pst.setInt(1, Integer.parseInt(patientId.getText()));
            pst.setInt(2, Integer.parseInt(doctorId.getText()));
            pst.setDate(3, Date.valueOf(LocalDate.now()));
            pst.setInt(4, token);
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Appointment Booked. Token: " + token);
            dispose(); new Dashboard();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
