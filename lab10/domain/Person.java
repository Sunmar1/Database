package ru.icmit.oodb.lab10.domain;

import sun.util.calendar.BaseCalendar;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.sql.Date;
import java.util.ArrayList;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Person {
    @Column
    String name;
    @Column
    Date birthDate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person() {
    }

    public Person(String name, Date birthDate ) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }


}
