package domain;

import annotation.Column;
import annotation.Entity;
import annotation.ManyToOne;
import annotation.OneToMany;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.Date;
import java.util.List;

@Entity
public class Patient extends Person {
    @Column
    @ManyToOne
    Area area;

    @OneToMany
    List<String> diagnoses;
    @Column
    private Long id;

    public Patient() {
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Patient(Area area, List<String> diagnoses) {
        this.area = area;
        this.diagnoses = diagnoses;
    }

    public String toString() {
        return "DB.domain.Patient{area=" + this.area + ", diagnoses=" + this.diagnoses + ", name='" + this.name + '\'' + ", birthDate=" + new Date()  + '}';
    }

    public Patient(String name, Date birthDate, Area area) {
        super(name, birthDate);
        this.area = area;
    }

    public Patient(String name, Date birthDate,  Area area, List<String> diagnoses) {
        super(name, birthDate);
        this.area = area;
        this.diagnoses = diagnoses;
    }
    @XmlElementWrapper(name = "diagnoses")
    @XmlElement(name = "diagnose")
    public List<String> getDiagnoses() {
        return this.diagnoses;
    }

    public void setDiagnoses(List<String> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public Area getArea() {
        return this.area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void addDiagnose(String diagnose) {
        this.diagnoses.add(diagnose);
    }
}
