package DB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
@XmlRootElement(name = "clinic")
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

    @XmlElementWrapper(name = "doctors")
    @XmlElement(name = "doctor")
    public ArrayList<Doctor> getDoctors() {
        return this.doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    @XmlElementWrapper(name = "patients")
    @XmlElement(name = "patient")
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

    @XmlElementWrapper(name = "areas")
    @XmlElement(name = "area")
    public ArrayList<Area> getAreas() {
        return this.areas;
    }

    public void addArea(Area area) {
        this.areas.add(area);
    }

    @Override
    public String toString() {
        return "Clinic{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", areas=" + areas +
                ", doctors=" + doctors +
                ", patients=" + patients +
                '}';
    }
}
