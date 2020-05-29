package ru.icmit.oodb.lab10.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
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
    List<Diagnose> diagnoses=new ArrayList<>();
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

    public Patient(Area area, List<Diagnose> diagnoses) {
        this.area = area;
        this.diagnoses = diagnoses;
    }



    public Patient(String name, Date birthDate, Area area) {
        super(name, birthDate);
        this.area = area;
    }

    public Patient(String name, Date birthDate,  Area area, List<Diagnose> diagnoses) {
        super(name, birthDate);
        this.area = area;
        this.diagnoses = diagnoses;
    }
    @XmlElementWrapper(name = "diagnoses")
    @XmlElement(name = "diagnose")
    public List<Diagnose> getDiagnoses() {
        return this.diagnoses;
    }

    public void setDiagnoses(List<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }

    public Area getArea() {
        return this.area;
    }

    public void setArea(Area area) {
        this.area = area;
    }



}
