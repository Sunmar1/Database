import java.lang.reflect.Array;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

public class Main {

    public static void main(String args[]){
       Clinic first=new Clinic("Первая поликлиника","Кремлевская 35");
       Area area_1=new Area("39-ый квартал",first);
       Patient patient_1=new Patient("Фалес Малетский",new GregorianCalendar(1999,0,29),Gender.MALE,area_1);
       Doctor doctor_1=new Doctor("Гераклит Эфесский",new GregorianCalendar(1985,11,11),Gender.MALE,area_1,"Терапевт");
       first.addDoctor(doctor_1);
       first.addArea(area_1);
       first.addPatient(patient_1);
       System.out.println(first.toString());



    }
}
