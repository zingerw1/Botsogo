package admin;

import javax.swing.*;
import java.awt.*;
import services.UserService;
import services.DoctorService;
import services.PatientService;
import services.AppointmentService;

public class AdminPanel extends JPanel {
    private UserService userService;
    private DoctorService doctorService;
    private PatientService patientService;
    private AppointmentService appointmentService;

    public AdminPanel() {
        this.userService = new UserService();
        this.doctorService = new DoctorService();
        this.patientService = new PatientService();
        this.appointmentService = new AppointmentService();
        
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 248, 255));

        // Create tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Arial", Font.BOLD, 14));

        // Dashboard Tab
        tabbedPane.addTab("Dashboard", createDashboardPanel());

        // Users Tab
        tabbedPane.addTab("Users", createUsersPanel());

        // Doctors Tab
        tabbedPane.addTab("Doctors", createDoctorsPanel());

        // Patients Tab
        tabbedPane.addTab("Patients", createPatientsPanel());

        // Appointments Tab
        tabbedPane.addTab("Appointments", createAppointmentsPanel());

        add(tabbedPane, BorderLayout.CENTER);
    }

    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(240, 248, 255));

        // Statistics cards
        panel.add(createStatCard("Total Users", String.valueOf(userService.getUserCount()), Color.BLUE));
        panel.add(createStatCard("Total Doctors", String.valueOf(doctorService.getDoctorCount()), Color.GREEN));
        panel.add(createStatCard("Total Patients", String.valueOf(patientService.getPatientCount()), Color.ORANGE));
        panel.add(createStatCard("Total Appointments", String.valueOf(appointmentService.getAppointmentCount()), Color.RED));

        return panel;
    }

    private JPanel createStatCard(String title, String value, Color color) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(color, 2),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        JLabel titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(color);

        JLabel valueLabel = new JLabel(value, SwingConstants.CENTER);
        valueLabel.setFont(new Font("Arial", Font.BOLD, 24));
        valueLabel.setForeground(color);

        card.add(titleLabel, BorderLayout.NORTH);
        card.add(valueLabel, BorderLayout.CENTER);

        return card;
    }

    private JPanel createUsersPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("User Management", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(0, 102, 204));

        panel.add(titleLabel, BorderLayout.NORTH);
        // TODO: Add user management components
        panel.add(new JLabel("User management features coming soon...", SwingConstants.CENTER), BorderLayout.CENTER);

        return panel;
    }

    private JPanel createDoctorsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("Doctor Management", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(0, 102, 204));

        panel.add(titleLabel, BorderLayout.NORTH);
        // TODO: Add doctor management components
        panel.add(new JLabel("Doctor management features coming soon...", SwingConstants.CENTER), BorderLayout.CENTER);

        return panel;
    }

    private JPanel createPatientsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("Patient Management", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(0, 102, 204));

        panel.add(titleLabel, BorderLayout.NORTH);
        // TODO: Add patient management components
        panel.add(new JLabel("Patient management features coming soon...", SwingConstants.CENTER), BorderLayout.CENTER);

        return panel;
    }

    private JPanel createAppointmentsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("Appointment Management", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(0, 102, 204));

        panel.add(titleLabel, BorderLayout.NORTH);
        // TODO: Add appointment management components
        panel.add(new JLabel("Appointment management features coming soon...", SwingConstants.CENTER), BorderLayout.CENTER);

        return panel;
    }
}
