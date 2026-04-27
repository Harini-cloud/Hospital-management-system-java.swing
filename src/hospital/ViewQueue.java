package hospital;

import javax.swing.*;
import java.sql.*;

public class ViewQueue extends JFrame {

    JTextArea area;

    public ViewQueue() {
        setTitle("Queue");
        setSize(500,300);

        area = new JTextArea();
        add(new JScrollPane(area));

        load();
        setVisible(true);
    }

    void load() {
        try (Connection con = DBConnection.getConnection()) {

            ResultSet rs = con.createStatement().executeQuery(
                "SELECT * FROM appointments ORDER BY token_no"
            );

            while (rs.next()) {
                area.append(
                    "Token: " + rs.getInt("token_no") +
                    " | Patient: " + rs.getInt("patient_id") +
                    " | Doctor: " + rs.getInt("doctor_id") +
                    " | Status: " + rs.getString("status") + "\n"
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
