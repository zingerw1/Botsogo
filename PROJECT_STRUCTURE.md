# Hospital Management System - Project Structure

## Complete File Structure

```
Java_WeatherApp/
├── Main.java                 # Main application entry point
├── TestApplication.java      # Component testing utility
├── README.md                 # Project documentation
├── PROJECT_STRUCTURE.md      # This file
└── src/
    ├── models/               # Data model classes
    │   ├── User.java         # Base user model with common attributes
    │   ├── Patient.java      # Patient model extending User
    │   ├── Doctor.java       # Doctor model extending User
    │   └── Appointment.java  # Appointment model
    ├── services/             # Business logic services
    │   ├── UserService.java      # User management service
    │   ├── PatientService.java   # Patient management service
    │   ├── DoctorService.java    # Doctor management service
    │   └── AppointmentService.java # Appointment management service
    ├── admin/                # Admin panel GUI
    │   └── AdminPanel.java   # Admin dashboard and management interface
    ├── doctor/               # Doctor panel GUI
    │   └── DoctorPanel.java  # Doctor's appointment and patient management
    ├── patient/              # Patient panel GUI
    │   └── PatientPanel.java # Patient appointment booking and profile
    └── user/                 # General user panel GUI
        └── UserPanel.java    # General user interface
```

## Key Features Implemented

### 1. Data Models

- **User**: Base class with common attributes (id, username, password, email, role, etc.)
- **Patient**: Extends User with medical-specific attributes (address, dateOfBirth, medical history)
- **Doctor**: Extends User with professional attributes (specialization, license, experience)
- **Appointment**: Manages scheduling with conflict detection and status tracking

### 2. Service Layer

- **UserService**: User CRUD operations, authentication, role-based filtering
- **PatientService**: Patient-specific management
- **DoctorService**: Doctor management with specialization and department support
- **AppointmentService**: Appointment booking with scheduling conflict detection

### 3. GUI Panels

- **AdminPanel**: Tabbed interface with dashboard, user/doctor/patient/appointment management
- **DoctorPanel**: Tabbed interface for appointments, patient records, and schedule
- **PatientPanel**: Tabbed interface for booking appointments and profile management
- **UserPanel**: General user interface

### 4. Sample Data

- Pre-loaded sample users (admin, doctors, patients)
- Sample appointments for testing
- Realistic medical data structure

## Technical Architecture

- **MVC Pattern**: Clear separation between models, services, and GUI
- **Java Swing**: Modern GUI framework with responsive design
- **In-Memory Storage**: Ready for database integration
- **Package Structure**: Modular design for maintainability

## How to Run

1. Compile: `javac -cp . Main.java`
2. Run: `java -cp . Main`
3. Test Components: `javac -cp . TestApplication.java && java -cp . TestApplication`

## Next Steps for Enhancement

- Database integration (JDBC/ORM)
- User authentication system
- Email notifications
- Advanced reporting
- Mobile app integration
- Payment processing system
