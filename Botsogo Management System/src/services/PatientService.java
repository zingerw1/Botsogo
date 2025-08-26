package services;

import models.Patient;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientService {
    private List<Patient> patients;
    private int nextId;

    public PatientService() {
        this.patients = new ArrayList<>();
        this.nextId = 1;
    }

    public Patient createPatient(String username, String password, String email, 
                                 String firstName, String lastName, String phoneNumber, 
                                 String address, LocalDate dateOfBirth, String gender, 
                                 String bloodGroup) {
        Patient patient = new Patient(username, password, email, firstName, lastName, 
                                       phoneNumber, address, dateOfBirth, gender, bloodGroup);
        patient.setId(nextId++);
        patients.add(patient);
        return patient;
    }

    public Patient getPatientById(int id) {
        return patients.stream()
                       .filter(patient -> patient.getId() == id)
                       .findFirst()
                       .orElse(null);
    }

    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients);
    }

    public boolean updatePatient(Patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getId() == updatedPatient.getId()) {
                patients.set(i, updatedPatient);
                return true;
            }
        }
        return false;
    }

    public boolean deletePatient(int id) {
        return patients.removeIf(patient -> patient.getId() == id);
    }

    public int getPatientCount() {
        return patients.size();
    }
}
