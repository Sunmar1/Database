package XML;

public class Load {

    public static void main(String[] args) {

        Clinic clinic = Service.loadBankFromXML();

        System.out.println(clinic);
    }
}
