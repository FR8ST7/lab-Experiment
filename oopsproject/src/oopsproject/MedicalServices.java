package oopsproject;

public interface MedicalServices {
    void scheduleAppointment(patient patient, Doctor doctor);
    void generatePrescription(patient patient);
}

