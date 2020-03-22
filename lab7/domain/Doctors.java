package domain;

import annotation.Column;
import annotation.Entity;
import annotation.Id;
import annotation.ManyToOne;

import javax.xml.bind.annotation.XmlElement;
import java.util.Date;

@Entity
public class Doctors extends Person {

    @Column
    @ManyToOne
    Area area;
    @Column
    String specialty;
    @Id
    private Long id;

    public Doctors() {
    }

    public Doctors(Area area, String specialty) {
        this.area = area;
        this.specialty = specialty;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }
    public String toString() {
        return "DB.domain.Doctors{area=" + this.area + ", specialty='" + this.specialty + '\'' + ", name='" + this.name + '\'' + ", birthDate=" + birthDate + '}';
    }

    public Doctors(String name, Date birthDate,  Area area, String specialty) {
        super(name, birthDate);
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


    @XmlElement(name = "specialty")
    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
