package oopsproject;

import java.util.Date;

public class Appointment {
    private patient patient;
    private Doctor doctor;
    private Date appointmentDate;

    public Appointment(patient patient, Doctor doctor, Date appointmentDate) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
    }

    public void displayAppointmentDetails() {
        System.out.println("Appointment Details:");
        System.out.println("Patient: " + patient.getName());
        System.out.println("Doctor: " + doctor.getName());
        System.out.println("Date: " + appointmentDate);
    }
}
