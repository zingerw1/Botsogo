package user;

import javax.swing.*;
import java.awt.*;
import services.UserService;

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

        // TODO: Add user functionalities (e.g., profile management, appointment booking)
        JTextArea textArea = new JTextArea("User functionalities coming soon...");
        textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        textArea.setEditable(false);
        add(textArea, BorderLayout.CENTER);
    }
}
