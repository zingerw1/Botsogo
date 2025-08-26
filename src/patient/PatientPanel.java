package patient;

import javax.swing.*;
import java.awt.*;
import services.AppointmentService;
import services.DoctorService;

public class PatientPanel extends JPanel {
    private AppointmentService appointmentService;
    private DoctorService doctorService;

    public PatientPanel() {
        this.appointmentService = new AppointmentService();
        this.doctorService = new DoctorService();
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("Patient Panel", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 102, 204));

        add(titleLabel, BorderLayout.NORTH);

        // Create tabbed pane for patient functionalities
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 14));

        // Book Appointment Tab
        tabbedPane.addTab("Book Appointment", createBookAppointmentPanel());

        // My Appointments Tab
        tabbedPane.addTab("My Appointments", createMyAppointmentsPanel());

        // Profile Tab
        tabbedPane.addTab("Profile", createProfilePanel());

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

    private JPanel createBookAppointmentPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("Book New Appointment", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 102, 204));

        panel.add(titleLabel, BorderLayout.NORTH);
        // TODO: Add appointment booking form
        panel.add(new JLabel("Appointment booking form coming soon...", SwingConstants.CENTER), BorderLayout.CENTER);

        return panel;
    }

    private JPanel createMyAppointmentsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("My Appointments", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 102, 204));

        panel.add(titleLabel, BorderLayout.NORTH);
        // TODO: Add appointments list
        panel.add(new JLabel("Appointments list coming soon...", SwingConstants.CENTER), BorderLayout.CENTER);

        return panel;
    }

    private JPanel createProfilePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("My Profile", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(new Color(0, 102, 204));

        panel.add(titleLabel, BorderLayout.NORTH);
        // TODO: Add profile management form
        panel.add(new JLabel("Profile management form coming soon...", SwingConstants.CENTER), BorderLayout.CENTER);

        return panel;
    }
}
