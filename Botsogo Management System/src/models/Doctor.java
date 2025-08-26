package models;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends User {
    private String specialization;
    private String licenseNumber;
    private String qualifications;
    private int yearsOfExperience;
    private String department;
    private List<String> availableDays;
    private String workingHours;
    private double consultationFee;
    private List<String> languagesSpoken;

    public Doctor() {
        super();
        this.setRole("doctor");
        this.availableDays = new ArrayList<>();
        this.languagesSpoken = new ArrayList<>();
    }

    public Doctor(String username, String password, String email, String firstName, 
                 String lastName, String phoneNumber, String specialization, 
                 String licenseNumber, String qualifications, int yearsOfExperience) {
        super(username, password, email, firstName, lastName, phoneNumber, "doctor");
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
        this.qualifications = qualifications;
        this.yearsOfExperience = yearsOfExperience;
        this.availableDays = new ArrayList<>();
        this.languagesSpoken = new ArrayList<>();
    }

    // Getters and Setters
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }

    public String getQualifications() { return qualifications; }
    public void setQualifications(String qualifications) { this.qualifications = qualifications; }

    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public List<String> getAvailableDays() { return availableDays; }
    public void setAvailableDays(List<String> availableDays) { this.availableDays = availableDays; }
    public void addAvailableDay(String day) { this.availableDays.add(day); }

    public String getWorkingHours() { return workingHours; }
    public void setWorkingHours(String workingHours) { this.workingHours = workingHours; }

    public double getConsultationFee() { return consultationFee; }
    public void setConsultationFee(double consultationFee) { this.consultationFee = consultationFee; }

    public List<String> getLanguagesSpoken() { return languagesSpoken; }
    public void setLanguagesSpoken(List<String> languagesSpoken) { this.languagesSpoken = languagesSpoken; }
    public void addLanguage(String language) { this.languagesSpoken.add(language); }

    public String getAvailableDaysAsString() {
        return String.join(", ", availableDays);
    }

    public String getLanguagesAsString() {
        return String.join(", ", languagesSpoken);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + getId() +
                ", fullName='" + getFullName() + '\'' +
                ", specialization='" + specialization + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", yearsOfExperience=" + yearsOfExperience +
                ", department='" + department + '\'' +
                '}';
    }
}
