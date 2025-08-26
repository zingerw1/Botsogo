// File: Main.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private static JFrame mainFrame;
    private static CardLayout cardLayout;
    private static JPanel cardPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            mainFrame = new JFrame("Hospital Management System");
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(800, 600);
            
            // Create card layout for switching between panels
            cardLayout = new CardLayout();
            cardPanel = new JPanel(cardLayout);
            
            // Create main panel with welcome message and role selection
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new GridBagLayout());
            mainPanel.setBackground(new Color(240, 248, 255));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);

            // Welcome label
            JLabel welcomeLabel = new JLabel("Welcome to Hospital Management System");
            welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
            welcomeLabel.setForeground(new Color(0, 102, 204));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            mainPanel.add(welcomeLabel, gbc);

            // Role selection label
            JLabel roleLabel = new JLabel("Select your role:");
            roleLabel.setFont(new Font("Arial", Font.PLAIN, 18));
            gbc.gridy = 1;
            mainPanel.add(roleLabel, gbc);

            // Role selection buttons
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(2, 2, 10, 10));
            buttonPanel.setBackground(new Color(240, 248, 255));

            JButton adminBtn = createRoleButton("Admin", new Color(220, 20, 60));
            JButton doctorBtn = createRoleButton("Doctor", new Color(0, 128, 128));
            JButton patientBtn = createRoleButton("Patient", new Color(60, 179, 113));
            JButton userBtn = createRoleButton("User", new Color(138, 43, 226));

            adminBtn.addActionListener(new RoleButtonListener("Admin"));
            doctorBtn.addActionListener(new RoleButtonListener("Doctor"));
            patientBtn.addActionListener(new RoleButtonListener("Patient"));
            userBtn.addActionListener(new RoleButtonListener("User"));

            buttonPanel.add(adminBtn);
            buttonPanel.add(doctorBtn);
            buttonPanel.add(patientBtn);
            buttonPanel.add(userBtn);

            gbc.gridy = 2;
            gbc.gridwidth = 2;
            mainPanel.add(buttonPanel, gbc);

            // Add panels to card layout
            cardPanel.add(mainPanel, "MAIN");
            cardPanel.add(new admin.AdminPanel(), "ADMIN");
            cardPanel.add(new doctor.DoctorPanel(), "DOCTOR");
            cardPanel.add(new patient.PatientPanel(), "PATIENT");
            cardPanel.add(new user.UserPanel(), "USER");

            mainFrame.add(cardPanel, BorderLayout.CENTER);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setVisible(true);
        });
    }

    private static JButton createRoleButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        return button;
    }

    private static class RoleButtonListener implements ActionListener {
        private String role;

        public RoleButtonListener(String role) {
            this.role = role;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // Switch to the corresponding panel based on the role using CardLayout
            switch (role) {
                case "Admin":
                    cardLayout.show(cardPanel, "ADMIN");
                    mainFrame.setTitle("Admin Panel - Hospital Management System");
                    break;
                case "Doctor":
                    cardLayout.show(cardPanel, "DOCTOR");
                    mainFrame.setTitle("Doctor Panel - Hospital Management System");
                    break;
                case "Patient":
                    cardLayout.show(cardPanel, "PATIENT");
                    mainFrame.setTitle("Patient Panel - Hospital Management System");
                    break;
                case "User":
                    cardLayout.show(cardPanel, "USER");
                    mainFrame.setTitle("User Panel - Hospital Management System");
                    break;
            }
        }
    }
}
