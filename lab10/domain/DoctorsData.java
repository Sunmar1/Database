package ru.icmit.oodb.lab10.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DoctorsData {
    @Id
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

//    create view DoctorsData as
//    select c.id, p.name from doctors c join person p on c.id=p.id;