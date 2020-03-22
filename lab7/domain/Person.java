package domain;

import annotation.Column;
import annotation.Entity;

import java.util.Date;


public abstract class Person {
    @Column
    String name;
    @Column
    Date birthDate;


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
