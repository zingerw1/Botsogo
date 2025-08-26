package services;

import models.Doctor;
import java.util.ArrayList;
import java.util.List;

public class DoctorService {
    private List<Doctor> doctors;
    private int nextId;

    public DoctorService() {
        this.doctors = new ArrayList<>();
        this.nextId = 1;
        initializeSampleData();
    }

    private void initializeSampleData() {
        // Add sample doctors
        Doctor doctor1 = new Doctor("drjohn", "doctor123", "drjohn@hospital.com", 
                                  "John", "Smith", "555-1234", 
                                  "Cardiology", "MD12345", "MBBS, MD Cardiology", 10);
        doctor1.setId(nextId++);
        doctor1.setDepartment("Cardiology");
        doctor1.setConsultationFee(150.0);
        doctor1.addAvailableDay("Monday");
        doctor1.addAvailableDay("Wednesday");
        doctor1.addAvailableDay("Friday");
        doctor1.setWorkingHours("9:00 AM - 5:00 PM");
        doctor1.addLanguage("English");
        doctor1.addLanguage("Spanish");
        doctors.add(doctor1);

        Doctor doctor2 = new Doctor("drsarah", "doctor123", "drsarah@hospital.com", 
                                   "Sarah", "Johnson", "555-5678", 
                                   "Pediatrics", "MD67890", "MBBS, MD Pediatrics", 8);
        doctor2.setId(nextId++);
        doctor2.setDepartment("Pediatrics");
        doctor2.setConsultationFee(120.0);
        doctor2.addAvailableDay("Tuesday");
        doctor2.addAvailableDay("Thursday");
        doctor2.addAvailableDay("Saturday");
        doctor2.setWorkingHours("10:00 AM - 4:00 PM");
        doctor2.addLanguage("English");
        doctor2.addLanguage("French");
        doctors.add(doctor2);
    }

    public Doctor createDoctor(String username, String password, String email, 
                              String firstName, String lastName, String phoneNumber, 
                              String specialization, String licenseNumber, 
                              String qualifications, int yearsOfExperience) {
        Doctor doctor = new Doctor(username, password, email, firstName, lastName, 
                                  phoneNumber, specialization, licenseNumber, 
                                  qualifications, yearsOfExperience);
        doctor.setId(nextId++);
        doctors.add(doctor);
        return doctor;
    }

    public Doctor getDoctorById(int id) {
        return doctors.stream()
                     .filter(doctor -> doctor.getId() == id)
                     .findFirst()
                     .orElse(null);
    }

    public List<Doctor> getAllDoctors() {
        return new ArrayList<>(doctors);
    }

    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        return doctors.stream()
                     .filter(doctor -> doctor.getSpecialization().equalsIgnoreCase(specialization))
                     .toList();
    }

    public List<Doctor> getDoctorsByDepartment(String department) {
        return doctors.stream()
                     .filter(doctor -> doctor.getDepartment().equalsIgnoreCase(department))
                     .toList();
    }

    public boolean updateDoctor(Doctor updatedDoctor) {
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getId() == updatedDoctor.getId()) {
                doctors.set(i, updatedDoctor);
                return true;
            }
        }
        return false;
    }

    public boolean deleteDoctor(int id) {
        return doctors.removeIf(doctor -> doctor.getId() == id);
    }

    public int getDoctorCount() {
        return doctors.size();
    }

    public List<String> getAllSpecializations() {
        return doctors.stream()
                     .map(Doctor::getSpecialization)
                     .distinct()
                     .toList();
    }

    public List<String> getAllDepartments() {
        return doctors.stream()
                     .map(Doctor::getDepartment)
                     .distinct()
                     .toList();
    }
}
