package XML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Service {


    public static void saveClinicData(Clinic clinic) {

        try {
            JAXBContext context = JAXBContext.newInstance(Clinic.class);
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // маршаллинг объекта в файл
            marshaller.marshal(clinic, new File("clinic.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }



    public static Clinic loadBankFromXML() {

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Clinic.class);
            Unmarshaller un = jaxbContext.createUnmarshaller();

            return (Clinic) un.unmarshal(new File("clinic.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static Patient findPatientByName(List<Patient> patients, String searchName) {
        Patient result = null;

        for (Patient patient : patients) {
            if(patient.getName().equals(searchName)) {
                result = patient;
            }
        }

        return result;
    }
    public static Patient findPatientByArea(List<Patient> patients, String searchArea) {
        Patient result = null;

        for (Patient patient : patients) {
            if (patient.getArea().toString().equals(searchArea)) {
                result = patient;
            }
        }

        return result;
    }

    public static Patient findPatientByGender(List<Patient> patients, String searchGender) {
        Patient result = null;

        for (Patient patient : patients) {

            if (patient.getGender().toString().equals(searchGender)) {
                result = patient;
            }
        }

        return result;
    }
    public static Patient findPatientByBirthdate(List<Patient> patients, String searchBirthdate) {
        Patient result = null;

        for (Patient patient : patients) {
            if (patient.getBirthDate().toString().equals(searchBirthdate)) {
                result = patient;
            }
        }

        return result;
    }
    public static Doctor findDoctorByName(List<Doctor> doctors, String searchName) {
        Doctor result = null;

        for (Doctor doctor : doctors) {
            if (doctor.getName().equals(searchName)) {
                result = doctor;
            }
        }

        return result;
    }
    public static Doctor findDoctorByArea(List<Doctor> doctors, String searchArea) {
        Doctor result = null;

        for (Doctor doctor : doctors) {
            if (doctor.getArea().toString().equals(searchArea)) {
                result = doctor;
            }
        }

        return result;
    }
    public static Doctor findDoctorBySpecialty(List<Doctor> doctors, String searchSpecialty) {
        Doctor result = null;

        for (Doctor doctor : doctors) {
            if (doctor.getSpecialty().equals(searchSpecialty)) {
                result = doctor;
            }
        }

        return result;
    }
    public static Doctor findDoctorByGender(List<Doctor> doctors, String searchGender) {
        Doctor result = null;

        for (Doctor doctor : doctors) {
            System.out.println(doctor.getGender());
            if (doctor.getGender().toString().equals(searchGender)) {
                result = doctor;
            }
        }

        return result;
    }
    public static Doctor findDoctorByBirthdate(List<Doctor> doctors, String searchBirthdate) {
        Doctor result = null;

        for (Doctor doctor : doctors) {
            if (doctor.getBirthDate().toString().equals(searchBirthdate)) {
                result = doctor;
            }
        }

        return result;
    }

    public static  ArrayList<Doctor> sortByArea(List<Doctor> doctors, String searchArea){
        ArrayList<Doctor> result= new ArrayList<>(Collections.nCopies(doctors.size(), null));
        int k=0;
        for (Doctor doctor : doctors) {
            if (doctor.getArea().toString().equals(searchArea)) {
                result.add(doctors.size() - k,doctor);
                k++;
            }else
                result.add(doctor);

        }
        ArrayList<Doctor> res=new ArrayList<>();
        for (int i=0;i<result.size();i++){
            try {
                if(!result.get(i).equals(null))
                    res.add(result.get(i));
            }
            catch (NullPointerException e){

            }

        }

        return res;
    }

    public static  ArrayList<Doctor> sortByAge(List<Doctor> doctors, long age){
        ArrayList<Doctor> result= new ArrayList<>(Collections.nCopies(doctors.size(), null));
        int k=0;
        int c=0;

        for (Doctor doctor : doctors) {
            if (doctor.getBirthDate().getYear()<new Date().getYear()-age) {
                result.add(doctors.size() - k,doctor);
                k++;
            }else {
                result.add(doctor);
                c++;
            }

        }
        ArrayList<Doctor> res=new ArrayList<>();
        for (int i=0;i<result.size();i++){
            try {
                if(!result.get(i).equals(null))
                    res.add(result.get(i));
            }
            catch (NullPointerException e){

            }

        }

        return res;
    }

    public static  ArrayList<Doctor> sortBySpecialty(List<Doctor> doctors, String searchSpecialty){
        ArrayList<Doctor> result= new ArrayList<>(Collections.nCopies(doctors.size(), null));
        int k=0;
        int c=0;

        for (Doctor doctor : doctors) {
            if (doctor.getSpecialty().equals(searchSpecialty)) {
                result.add(doctors.size() - k,doctor);
                k++;
            }else {
                result.add(doctor);
                c++;
            }

        }
        ArrayList<Doctor> res=new ArrayList<>();
        for (int i=0;i<result.size();i++){
            try {
                if(!result.get(i).equals(null))
                    res.add(result.get(i));
            }
            catch (NullPointerException e){

            }

        }

        return res;
    }
    public static  ArrayList<Doctor> sortByGender(List<Doctor> doctors, Gender gender){
        ArrayList<Doctor> result= new ArrayList<>(Collections.nCopies(doctors.size(), null));
        int k=0;
        int c=0;

        for (Doctor doctor : doctors) {
            if (doctor.getGender().equals(gender)) {
                result.add(doctors.size() - k,doctor);
                k++;
            }else {
                result.add(doctor);
                c++;
            }

        }
        ArrayList<Doctor> res=new ArrayList<>();
        for (int i=0;i<result.size();i++){
            try {
                if(!result.get(i).equals(null))
                    res.add(result.get(i));
            }
            catch (NullPointerException e){

            }

        }

        return res;
    }
}
