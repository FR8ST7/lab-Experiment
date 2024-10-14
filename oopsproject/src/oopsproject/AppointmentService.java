package oopsproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class AppointmentService implements MedicalServices {
    private List<Appointment> appointments = new ArrayList<>();

    @Override
    public void scheduleAppointment(patient patient, Doctor doctor) {
        Date appointmentDate = new Date();  // Example: Current date/time
        Appointment appointment = new Appointment(patient, doctor, appointmentDate);
        appointments.add(appointment);
        System.out.println("Appointment scheduled successfully!");
    }

    @Override
    public void generatePrescription(patient patient) {
        System.out.println("Prescription for patient " + patient.getName() + ": Paracetamol 500mg");
    }

    public void displayAllAppointments() {
        for (Appointment appointment : appointments) {
            appointment.displayAppointmentDetails();
        }
    }
}
