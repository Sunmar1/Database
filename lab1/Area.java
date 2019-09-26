public class Area {
    String area;
    Clinic clinic;

    public Clinic getClinic() {
        return clinic;
    }

    @Override
    public String toString() {
        return "Area{" +
                "area='" + area + '\'' +
                ", clinic=" + clinic.getName()+
                '}';
    }

    public Area() {
    }

    public Area(String area, Clinic clinic) {
        this.area = area;
        this.clinic = clinic;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public String getArea() {
        return area;
    }

    public Area(String area) {
        this.area = area;
    }

    public void setArea(String area) {
        this.area = area;
    }


}
