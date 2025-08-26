package models;

import java.time.LocalDate;

public class Patient extends User {
    private String address;
    private LocalDate dateOfBirth;
    private String gender;
    private String bloodGroup;
    private String emergencyContact;
    private String medicalHistory;
    private String allergies;
    private String currentMedications;

    public Patient() {
        super();
        this.setRole("patient");
    }

    public Patient(String username, String password, String email, String firstName, 
                  String lastName, String phoneNumber, String address, 
                  LocalDate dateOfBirth, String gender, String bloodGroup) {
        super(username, password, email, firstName, lastName, phoneNumber, "patient");
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
    }

    // Getters and Setters
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public String getEmergencyContact() { return emergencyContact; }
    public void setEmergencyContact(String emergencyContact) { this.emergencyContact = emergencyContact; }

    public String getMedicalHistory() { return medicalHistory; }
    public void setMedicalHistory(String medicalHistory) { this.medicalHistory = medicalHistory; }

    public String getAllergies() { return allergies; }
    public void setAllergies(String allergies) { this.allergies = allergies; }

    public String getCurrentMedications() { return currentMedications; }
    public void setCurrentMedications(String currentMedications) { this.currentMedications = currentMedications; }

    public int getAge() {
        if (dateOfBirth == null) return 0;
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + getId() +
                ", username='" + getUsername() + '\'' +
                ", fullName='" + getFullName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", age=" + getAge() +
                ", gender='" + gender + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                '}';
    }
}
