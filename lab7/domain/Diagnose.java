package domain;

import annotation.Column;
import annotation.Entity;
import annotation.Id;

@Entity
public class Diagnose {
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
