# Hospital Management System

A comprehensive Java Swing-based hospital management system with role-based access and modern GUI interface.

## Features

### Role-Based Access

- **Admin Panel**: Manage users, doctors, patients, and appointments
- **Doctor Panel**: View appointments, patient records, and manage schedule
- **Patient Panel**: Book appointments and manage personal profile
- **User Panel**: General user functionalities

### Core Functionalities

- User authentication and role management
- Patient profile creation and management
- Doctor specialization and schedule management
- Appointment booking with conflict detection
- Real-time statistics and dashboard

## Project Structure

```
src/
├── models/           # Data models
│   ├── User.java
│   ├── Patient.java
│   ├── Doctor.java
│   └── Appointment.java
├── services/         # Business logic
│   ├── UserService.java
│   ├── PatientService.java
│   ├── DoctorService.java
│   └── AppointmentService.java
├── admin/            # Admin panel GUI
│   └── AdminPanel.java
├── doctor/           # Doctor panel GUI
│   └── DoctorPanel.java
├── patient/          # Patient panel GUI
│   └── PatientPanel.java
├── user/             # User panel GUI
│   └── UserPanel.java
└── Main.java         # Main application entry point
```

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (recommended: IntelliJ IDEA, Eclipse, or VS Code)

### Compilation

```bash
javac -cp . Main.java
```

### Running the Application

```bash
java -cp . Main
```

## Usage

1. Launch the application
2. Select your role from the main screen:
   - **Admin**: Full system access and management
   - **Doctor**: Medical professional interface
   - **Patient**: Patient services and appointment booking
   - **User**: General user features

## Sample Data

The application includes sample data for testing:

- Admin user: admin/admin123
- Sample doctors with different specializations
- Sample patients and appointments

## Technical Details

- **GUI Framework**: Java Swing
- **Architecture**: MVC (Model-View-Controller) pattern
- **Data Storage**: In-memory data structures (can be extended to database)
- **Package Structure**: Modular design with clear separation of concerns

## Future Enhancements

- Database integration (MySQL/PostgreSQL)
- User authentication system
- Email notifications
- Reporting and analytics
- Mobile app integration
- Payment processing

## License

This project is for educational purposes.
