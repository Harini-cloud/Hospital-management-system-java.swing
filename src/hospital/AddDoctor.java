package hospital;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddDoctor extends JFrame implements ActionListener {

    JTextField id, name, spec;

    public AddDoctor() {
        setTitle("Add Doctor");
        setLayout(new GridLayout(4,2));
        setSize(300,200);

        id = new JTextField();
        name = new JTextField();
        spec = new JTextField();

        add(new JLabel("ID")); add(id);
        add(new JLabel("Name")); add(name);
        add(new JLabel("Specialization")); add(spec);

        JButton btn = new JButton("Add");
        btn.addActionListener(this);
        add(btn);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try (Connection con = DBConnection.getConnection()) {
            PreparedStatement pst = con.prepareStatement(
                "INSERT INTO doctors VALUES (?, ?, ?)"
            );
            pst.setInt(1, Integer.parseInt(id.getText()));
            pst.setString(2, name.getText());
            pst.setString(3, spec.getText());
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Doctor Added");
            dispose(); new Dashboard();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
