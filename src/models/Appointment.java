package models;

import java.time.LocalDateTime;

public class Appointment {
    private int id;
    private int patientId;
    private int doctorId;
    private LocalDateTime appointmentDateTime;
    private String status; // "scheduled", "completed", "cancelled", "no-show"
    private String reasonForVisit;
    private String notes;
    private double fee;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Appointment() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = "scheduled";
    }

    public Appointment(int patientId, int doctorId, LocalDateTime appointmentDateTime, 
                      String reasonForVisit, double fee) {
        this();
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDateTime = appointmentDateTime;
        this.reasonForVisit = reasonForVisit;
        this.fee = fee;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPatientId() { return patientId; }
    public void setPatientId(int patientId) { this.patientId = patientId; }

    public int getDoctorId() { return doctorId; }
    public void setDoctorId(int doctorId) { this.doctorId = doctorId; }

    public LocalDateTime getAppointmentDateTime() { return appointmentDateTime; }
    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) { 
        this.appointmentDateTime = appointmentDateTime; 
        this.updatedAt = LocalDateTime.now();
    }

    public String getStatus() { return status; }
    public void setStatus(String status) { 
        this.status = status; 
        this.updatedAt = LocalDateTime.now();
    }

    public String getReasonForVisit() { return reasonForVisit; }
    public void setReasonForVisit(String reasonForVisit) { 
        this.reasonForVisit = reasonForVisit; 
        this.updatedAt = LocalDateTime.now();
    }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { 
        this.notes = notes; 
        this.updatedAt = LocalDateTime.now();
    }

    public double getFee() { return fee; }
    public void setFee(double fee) { 
        this.fee = fee; 
        this.updatedAt = LocalDateTime.now();
    }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

    public boolean isUpcoming() {
        return appointmentDateTime.isAfter(LocalDateTime.now()) && 
               (status.equals("scheduled") || status.equals("confirmed"));
    }

    public boolean isCompleted() {
        return status.equals("completed");
    }

    public boolean isCancelled() {
        return status.equals("cancelled");
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", appointmentDateTime=" + appointmentDateTime +
                ", status='" + status + '\'' +
                ", reasonForVisit='" + reasonForVisit + '\'' +
                ", fee=" + fee +
                '}';
    }
}
