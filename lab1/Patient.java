import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Patient extends  Person {
    Area area;
    protected  List<String> diagnoses;

    public  Patient(){

    }
    protected Patient(Area area, List<String> diagnoses) {
        this.area = area;
        this.diagnoses = diagnoses;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "area=" + area +
                ", diagnoses=" + diagnoses +
                ", name='" + name + '\'' +
                ", birthDate=" + new Date(birthDate.getTimeInMillis()) +
                ", gender=" + gender +
                '}';
    }

    public Patient(String name, Calendar birthDate, Gender gender, Area area) {
        super(name, birthDate, gender);
        this.area = area;
    }

    public Patient(String name, Calendar birthDate, Gender gender, Area area, List<String> diagnoses) {
        super(name, birthDate, gender);
        this.area = area;
        this.diagnoses = diagnoses;
    }



    public List<String> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(List<String> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
    public void addDiagnose(String diagnose){
        diagnoses.add(diagnose);
    }


}
