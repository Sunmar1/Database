package domain;

import annotation.Entity;
import annotation.*;

import javax.xml.bind.annotation.XmlElement;

import javax.xml.bind.annotation.XmlElementWrapper;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Patient extends Person {

    @ManyToOne
    Area area;

    @OneToMany
    List<Diagnoses> diagnoses=new ArrayList<>();
    @Id
    private Long id;

    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient(Area area, List<Diagnoses> diagnoses) {
        this.area = area;
        this.diagnoses = diagnoses;
    }



    public Patient(String name, Date birthDate, Area area) {
        super(name, birthDate);
        this.area = area;
    }

    public Patient(String name, Date birthDate,  Area area, List<Diagnoses> diagnoses) {
        super(name, birthDate);
        this.area = area;
        this.diagnoses = diagnoses;
    }
    @XmlElementWrapper(name = "diagnoses")
    @XmlElement(name = "diagnose")
    public List<Diagnoses> getDiagnoses() {
        return this.diagnoses;
    }

    public void setDiagnoses(List<Diagnoses> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public Area getArea() {
        return this.area;
    }

    public void setArea(Area area) {
        this.area = area;
    }


}
