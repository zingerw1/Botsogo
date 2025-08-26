package services;

import models.User;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    private List<User> users;
    private int nextId;

    public UserService() {
        this.users = new ArrayList<>();
        this.nextId = 1;
        initializeSampleData();
    }

    private void initializeSampleData() {
        // Add sample admin user
        User admin = new User("admin", "admin123", "admin@hospital.com", 
                            "System", "Administrator", "123-456-7890", "admin");
        admin.setId(nextId++);
        users.add(admin);

        // Add sample doctor
        User doctor = new User("drjohn", "doctor123", "drjohn@hospital.com", 
                             "John", "Smith", "555-1234", "doctor");
        doctor.setId(nextId++);
        users.add(doctor);

        // Add sample patient
        User patient = new User("patient1", "patient123", "patient1@email.com", 
                              "Alice", "Johnson", "555-5678", "patient");
        patient.setId(nextId++);
        users.add(patient);
    }

    public User createUser(String username, String password, String email, 
                          String firstName, String lastName, String phoneNumber, String role) {
        if (getUserByUsername(username) != null) {
            throw new IllegalArgumentException("Username already exists");
        }

        if (getUserByEmail(email) != null) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = new User(username, password, email, firstName, lastName, phoneNumber, role);
        user.setId(nextId++);
        users.add(user);
        return user;
    }

    public User getUserById(int id) {
        return users.stream()
                   .filter(user -> user.getId() == id)
                   .findFirst()
                   .orElse(null);
    }

    public User getUserByUsername(String username) {
        return users.stream()
                   .filter(user -> user.getUsername().equalsIgnoreCase(username))
                   .findFirst()
                   .orElse(null);
    }

    public User getUserByEmail(String email) {
        return users.stream()
                   .filter(user -> user.getEmail().equalsIgnoreCase(email))
                   .findFirst()
                   .orElse(null);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public List<User> getUsersByRole(String role) {
        return users.stream()
                   .filter(user -> user.getRole().equalsIgnoreCase(role))
                   .toList();
    }

    public boolean updateUser(User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == updatedUser.getId()) {
                users.set(i, updatedUser);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(int id) {
        return users.removeIf(user -> user.getId() == id);
    }

    public boolean authenticate(String username, String password) {
        User user = getUserByUsername(username);
        return user != null && user.getPassword().equals(password) && user.isActive();
    }

    public int getUserCount() {
        return users.size();
    }

    public int getUserCountByRole(String role) {
        return (int) users.stream()
                         .filter(user -> user.getRole().equalsIgnoreCase(role))
                         .count();
    }
}
