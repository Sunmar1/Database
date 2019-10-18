import com.google.gson.InstanceCreator;

import javax.print.Doc;
import javax.print.attribute.standard.Copies;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Service {

    public static Doctor findPersonByName(List<Doctor> doctors, String searchName) {
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
