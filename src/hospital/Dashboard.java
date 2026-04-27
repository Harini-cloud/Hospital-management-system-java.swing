package hospital;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    public Dashboard() {
        setTitle("Hospital System");
        setSize(650,300);
        setLayout(new FlowLayout());

        JButton addPatient = new JButton("Add Patient");
        JButton addDoctor = new JButton("Add Doctor");
        JButton book = new JButton("Book Appointment");
        JButton view = new JButton("View Queue");
        JButton complete = new JButton("Complete Appointment");

        add(addPatient);
        add(addDoctor);
        add(book);
        add(view);
        add(complete);

        addPatient.addActionListener(e -> new AddPatient());
        addDoctor.addActionListener(e -> new AddDoctor());
        book.addActionListener(e -> new BookAppointment());
        view.addActionListener(e -> new ViewQueue());
        complete.addActionListener(e -> new CompleteAppointment());

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
