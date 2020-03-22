package domain;

import annotation.Column;
import annotation.Entity;

@Entity
public class Diagnose {

    @Column
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Diagnose() {
    }
}
