import services.UserService;
import services.DoctorService;
import services.PatientService;
import services.AppointmentService;

public class TestApplication {
    public static void main(String[] args) {
        System.out.println("Testing Hospital Management System Components...");
        
        // Test User Service
        UserService userService = new UserService();
        System.out.println("Total Users: " + userService.getUserCount());
        System.out.println("Admin Users: " + userService.getUserCountByRole("admin"));
        System.out.println("Doctor Users: " + userService.getUserCountByRole("doctor"));
        System.out.println("Patient Users: " + userService.getUserCountByRole("patient"));
        
        // Test Doctor Service
        DoctorService doctorService = new DoctorService();
        System.out.println("Total Doctors: " + doctorService.getDoctorCount());
        System.out.println("Specializations: " + doctorService.getAllSpecializations());
        
        // Test Patient Service
        PatientService patientService = new PatientService();
        System.out.println("Total Patients: " + patientService.getPatientCount());
        
        // Test Appointment Service
        AppointmentService appointmentService = new AppointmentService();
        System.out.println("Total Appointments: " + appointmentService.getAppointmentCount());
        System.out.println("Upcoming Appointments: " + appointmentService.getUpcomingAppointments().size());
        System.out.println("Completed Appointments: " + appointmentService.getCompletedAppointments().size());
        
        System.out.println("All components initialized successfully!");
        System.out.println("Application is ready to run. Use 'java Main' to start the GUI application.");
    }
}
