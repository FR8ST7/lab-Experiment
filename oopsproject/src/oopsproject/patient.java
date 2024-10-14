package oopsproject;

public class patient {
    private int patientId;
    private String name;
    private String address;
    private String phoneNumber;

    public patient(int patientId, String name, String address, String phoneNumber) {
        this.patientId = patientId;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }

    public void displayPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone: " + phoneNumber);
    }
}
