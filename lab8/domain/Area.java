package domain;


import annotation.Column;
import annotation.Entity;
import annotation.Id;

@Entity
public class Area {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;


    public Long getId() {
        return id;
    }



    public Area() {
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return   name;
    }

    public String getArea() {

        return this.name;
    }
    public Area(String area) {
        this.name = area;
    }

    public void setArea(String area) {
        this.name = area;
    }

    public void setName(String name) {
        this.name = name;
    }
}