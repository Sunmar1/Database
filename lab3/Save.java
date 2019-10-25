package XML;

import java.util.Collections;
import java.util.Date;

public class Save {
    public static void main(String[] args) {


        Clinic clinic = new Clinic("1-ая поликлиника","Бондаренко");

        Area area1=new Area("12");
        clinic.addArea(area1);

        Patient patient1 = new Patient("Иван",new Date(),Gender.MALE,area1);
        Doctor doctor1 = new Doctor("Василий",new Date(),Gender.MALE,area1,"ортопед");
        Doctor doctor2 = new Doctor("Мария",new Date(),Gender.FEMALE,area1,"хирург");
        Doctor doctor3 = new Doctor("Анастасия",new Date(),Gender.FEMALE,area1,"терапевт");
        Doctor doctor4 = new Doctor("Елена",new Date(),Gender.FEMALE,area1,"хирург");
        Doctor doctor5 = new Doctor("Марк",new Date(),Gender.MALE,area1,"окулист");

        clinic.addDoctor(doctor1);
        clinic.addDoctor(doctor2);
        clinic.addDoctor(doctor3);
        clinic.addDoctor(doctor4);
        clinic.addDoctor(doctor5);
        clinic.addPatient(patient1);

        Service.saveClinicData(clinic);
    }
}
