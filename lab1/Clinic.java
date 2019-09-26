import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Clinic {
     String name;
     String address;
     ArrayList<Area> areas= new ArrayList<>();
     ArrayList<Doctor> doctors=new ArrayList<>();
     protected ArrayList<Patient> patients=new ArrayList<>();

    public Clinic(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Clinic() {

    }

   void  addDoctor(Doctor doctor){
       doctors.add(doctor);
   }
    void  addPatient(Patient patient){
        patients.add(patient);
    }

    public void setAreas(ArrayList<Area> areas) {
        this.areas = areas;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    protected ArrayList<Patient> getPatients() {
        return patients;
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
        return name;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Area> getAreas() {
        return areas;
    }

    public void addArea(Area area){
        areas.add(area);

    }

    @Override
    public String toString() {
        return "Clinic{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", areas=" + areas +
                ", doctors=" + doctors +

                '}';
    }
}
