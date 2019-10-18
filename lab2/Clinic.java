import java.util.ArrayList;

public class Clinic {
    String name;
    String address;
    ArrayList<Area> areas = new ArrayList();
    ArrayList<Doctor> doctors = new ArrayList();
    protected ArrayList<Patient> patients = new ArrayList();

    public Clinic(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Clinic() {
    }

    void addDoctor(Doctor doctor) {
        this.doctors.add(doctor);
    }

    void addPatient(Patient patient) {
        this.patients.add(patient);
    }

    public void setAreas(ArrayList<Area> areas) {
        this.areas = areas;
    }

    public ArrayList<Doctor> getDoctors() {
        return this.doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    protected ArrayList<Patient> getPatients() {
        return this.patients;
    }

    protected void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setArea(ArrayList<Area> areas) {
        this.areas = areas;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public ArrayList<Area> getAreas() {
        return this.areas;
    }

    public void addArea(Area area) {
        this.areas.add(area);
    }

    public String toString() {
        return "Clinic{name='" + this.name + '\'' + ", address='" + this.address + '\'' + ", areas=" + this.areas + ", doctors=" + this.doctors + '}';
    }
}
