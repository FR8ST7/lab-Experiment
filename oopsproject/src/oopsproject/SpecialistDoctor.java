package oopsproject;

public class SpecialistDoctor extends Doctor {
    private String specializationArea;

    public SpecialistDoctor(int doctorId, String name, String specialization, String specializationArea) {
        super(doctorId, name, specialization);
        this.specializationArea = specializationArea;
    }

    public String getSpecializationArea() { return specializationArea; }

    @Override
    public void displayDoctorDetails() {
        super.displayDoctorDetails();
        System.out.println("Specialization Area: " + specializationArea);
    }
}
