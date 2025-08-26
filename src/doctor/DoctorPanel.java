package doctor;

import javax.swing.*;
import java.awt.*;
import services.AppointmentService;

public class DoctorPanel extends JPanel {
    private AppointmentService appointmentService;

    public DoctorPanel() {
        this.appointmentService = new AppointmentService();
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("Doctor Panel", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 102, 204));

        add(titleLabel, BorderLayout.NORTH);

        // Create tabbed pane for doctor functionalities
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 14));

        // Appointments Tab
        tabbedPane.addTab("My Appointments", createAppointmentsPanel());

        // Patient Records Tab
        tabbedPane.addTab("Patient Records", createPatientRecordsPanel());

        // Schedule Tab
        tabbedPane.addTab("My Schedule", createSchedulePanel());

        add(tabbedPane, BorderLayout.CENTER);

        // Back button to return to main menu
        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(new Color(220, 20, 60));
        backButton.setForeground(Color.WHITE);
        backButton.setFocusPainted(false);
        backButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        backButton.addActionListener(e -> {
            // Get the main frame and switch back to main menu
            JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            CardLayout cardLayout = (CardLayout) ((JPanel) mainFrame.getContentPane().getComponent(0)).getLayout();
            cardLayout.show(mainFrame.getContentPane(), "MAIN");
            mainFrame.setTitle("Hospital Management System");
        });
        add(backButton, BorderLayout.SOUTH);
    }

    private JPanel createAppointmentsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("My Appointments", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 102, 204));

        panel.add(titleLabel, BorderLayout.NORTH);
        // TODO: Add appointments management
        panel.add(new JLabel("Appointments management coming soon...", SwingConstants.CENTER), BorderLayout.CENTER);

        return panel;
    }

    private JPanel createPatientRecordsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("Patient Records", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 102, 204));

        panel.add(titleLabel, BorderLayout.NORTH);
        // TODO: Add patient records management
        panel.add(new JLabel("Patient records management coming soon...", SwingConstants.CENTER), BorderLayout.CENTER);

        return panel;
    }

    private JPanel createSchedulePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("My Schedule", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 102, 204));

        panel.add(titleLabel, BorderLayout.NORTH);
        // TODO: Add schedule management
        panel.add(new JLabel("Schedule management coming soon...", SwingConstants.CENTER), BorderLayout.CENTER);

        return panel;
    }
}
