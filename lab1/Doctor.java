import java.util.Calendar;
import java.util.Date;

public class Doctor extends Person {
    Area area;
    String specialty;

    public Doctor() {
    }

    public Doctor(Area area, String specialty) {
        this.area = area;
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "area=" + area +
                ", specialty='" + specialty + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + new Date(birthDate.getTimeInMillis()) +
                ", gender=" + gender +
                '}';
    }

    public Doctor(String name, Calendar birthDate, Gender gender, Area area, String specialty) {
        super(name, birthDate, gender);
        this.area = area;
        this.specialty = specialty;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }


}
