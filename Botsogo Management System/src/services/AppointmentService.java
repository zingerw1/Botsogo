package services;

import models.Appointment;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    private List<Appointment> appointments;
    private int nextId;

    public AppointmentService() {
        this.appointments = new ArrayList<>();
        this.nextId = 1;
        initializeSampleData();
    }

    private void initializeSampleData() {
        // Add sample appointments
        Appointment appointment1 = new Appointment(3, 1, 
            LocalDateTime.of(2024, 1, 15, 10, 0), 
            "Routine checkup", 150.0);
        appointment1.setId(nextId++);
        appointments.add(appointment1);

        Appointment appointment2 = new Appointment(3, 2, 
            LocalDateTime.of(2024, 1, 16, 14, 30), 
            "Child vaccination", 120.0);
        appointment2.setId(nextId++);
        appointments.add(appointment2);
    }

    public Appointment createAppointment(int patientId, int doctorId, 
                                        LocalDateTime appointmentDateTime, 
                                        String reasonForVisit, double fee) {
        // Check for scheduling conflicts
        if (hasSchedulingConflict(doctorId, appointmentDateTime)) {
            throw new IllegalArgumentException("Doctor is not available at this time");
        }

        Appointment appointment = new Appointment(patientId, doctorId, appointmentDateTime, 
                                                 reasonForVisit, fee);
        appointment.setId(nextId++);
        appointments.add(appointment);
        return appointment;
    }

    public boolean hasSchedulingConflict(int doctorId, LocalDateTime appointmentDateTime) {
        return appointments.stream()
                          .filter(app -> app.getDoctorId() == doctorId)
                          .filter(app -> app.getStatus().equals("scheduled") || 
                                        app.getStatus().equals("confirmed"))
                          .anyMatch(app -> {
                              LocalDateTime existingTime = app.getAppointmentDateTime();
                              return existingTime.isEqual(appointmentDateTime) ||
                                     (existingTime.isBefore(appointmentDateTime.plusHours(1)) && 
                                      existingTime.isAfter(appointmentDateTime.minusHours(1)));
                          });
    }

    public Appointment getAppointmentById(int id) {
        return appointments.stream()
                          .filter(app -> app.getId() == id)
                          .findFirst()
                          .orElse(null);
    }

    public List<Appointment> getAllAppointments() {
        return new ArrayList<>(appointments);
    }

    public List<Appointment> getAppointmentsByPatientId(int patientId) {
        return appointments.stream()
                          .filter(app -> app.getPatientId() == patientId)
                          .toList();
    }

    public List<Appointment> getAppointmentsByDoctorId(int doctorId) {
        return appointments.stream()
                          .filter(app -> app.getDoctorId() == doctorId)
                          .toList();
    }

    public List<Appointment> getUpcomingAppointments() {
        return appointments.stream()
                          .filter(Appointment::isUpcoming)
                          .toList();
    }

    public List<Appointment> getCompletedAppointments() {
        return appointments.stream()
                          .filter(Appointment::isCompleted)
                          .toList();
    }

    public List<Appointment> getAppointmentsByStatus(String status) {
        return appointments.stream()
                          .filter(app -> app.getStatus().equalsIgnoreCase(status))
                          .toList();
    }

    public boolean updateAppointment(Appointment updatedAppointment) {
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i).getId() == updatedAppointment.getId()) {
                appointments.set(i, updatedAppointment);
                return true;
            }
        }
        return false;
    }

    public boolean cancelAppointment(int id) {
        Appointment appointment = getAppointmentById(id);
        if (appointment != null && appointment.isUpcoming()) {
            appointment.setStatus("cancelled");
            return true;
        }
        return false;
    }

    public boolean completeAppointment(int id) {
        Appointment appointment = getAppointmentById(id);
        if (appointment != null && appointment.isUpcoming()) {
            appointment.setStatus("completed");
            return true;
        }
        return false;
    }

    public boolean deleteAppointment(int id) {
        return appointments.removeIf(app -> app.getId() == id);
    }

    public int getAppointmentCount() {
        return appointments.size();
    }

    public int getAppointmentCountByStatus(String status) {
        return (int) appointments.stream()
                               .filter(app -> app.getStatus().equalsIgnoreCase(status))
                               .count();
    }

    public double getTotalRevenue() {
        return appointments.stream()
                          .filter(app -> app.isCompleted())
                          .mapToDouble(Appointment::getFee)
                          .sum();
    }
}
