package user;

import javax.swing.*;
import java.awt.*;
import services.UserService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPanel extends JPanel {
    private UserService userService;

    public UserPanel() {
        this.userService = new UserService();
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        setBackground(new Color(240, 248, 255));

        JLabel titleLabel = new JLabel("User Panel", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 102, 204));

        add(titleLabel, BorderLayout.NORTH);

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

        // Add user functionalities (e.g., profile management, appointment booking)
        JTextArea textArea = new JTextArea("User functionalities coming soon...");
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setEditable(false);
        add(textArea, BorderLayout.CENTER);
    }
}
