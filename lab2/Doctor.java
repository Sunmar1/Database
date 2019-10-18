import java.util.Calendar;
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

    public String toString() {
        return "Doctor{area=" + this.area + ", specialty='" + this.specialty + '\'' + ", name='" + this.name + '\'' + ", birthDate=" + birthDate + ", gender=" + this.gender + '}';
    }

    public Doctor(String name, Date birthDate, Gender gender, Area area, String specialty) {
        super(name, birthDate, gender);
        this.area = area;
        this.specialty = specialty;
    }

    public Area getArea() {
        return this.area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getSpecialty() {
        return this.specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
