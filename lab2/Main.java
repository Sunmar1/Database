import com.google.gson.Gson;

import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {


        List<Doctor> doctors = LoadDB.loadPersonList();


     /*  Doctor docs = Service.findDoctorBySpecialty(doctors, "11");

        if (docs != null) {
            docs.setArea(new Area("12"));
            docs.setSpecialty("12");
        }
        SaveDB.saveDoctorList(doctors);


        ArrayList<Doctor> docs= Service.sortByArea(doctors,"12");
        docs.forEach(System.out::println
        );

        ArrayList<Doctor> docs= Service.sortByAge(doctors,0);
        docs.forEach(System.out::println
        );

        ArrayList<Doctor> docs= Service.sortBySpecialty(doctors,"132");
        docs.forEach(System.out::println
        );
        */

        ArrayList<Doctor> docs= Service.sortByGender(doctors,Gender.MALE);
        docs.forEach(System.out::println        );


    }

    }

