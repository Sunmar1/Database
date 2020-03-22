package domain;

import annotation.Column;
import annotation.Entity;
import annotation.Id;
import annotation.OneToMany;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.ArrayList;

@Entity
public class Clinic {
    @Column
    String name;
    @Column
    String address;
    @Column
    @OneToMany
    ArrayList<Area> areas = new ArrayList();
    @Column
    @OneToMany
    ArrayList<Doctors> doctors = new ArrayList();
    @Column
    @OneToMany
    protected ArrayList<Patient> patients = new ArrayList();

    @Id
    private Long id;

    public Clinic(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Clinic() {
    }
    public void setId(Long id) {
        this.id = id;
    }

    void addDoctor(Doctors doctor) {
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
    public ArrayList<Doctors> getDoctors() {
        return this.doctors;
    }

    public void setDoctors(ArrayList<Doctors> doctors) {
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
