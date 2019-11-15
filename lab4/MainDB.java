package DB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainDB {
    public static void main(String[] args) {

        try {

            Class.forName("org.postgresql.Driver");

            Connection connection =
                    DriverManager.getConnection("jdbc:postgresql://localhost:5432/DB","postgres","admin");
            Long beg;
            Long end;

            Load4mDB.loadDoctorsListB(connection);
            Load4mDB.loadDoctorsListB(connection);
            Load4mDB.loadDoctorsListB(connection);
            Load4mDB.loadDoctorsListB(connection);
             beg=System.nanoTime();
            Load4mDB.loadDoctorsListB(connection);
             end= System.nanoTime();
            System.out.println("Load TIME B="+(end-beg));
       Load4mDB.loadDoctorsListA(connection);Load4mDB.loadDoctorsListA(connection);Load4mDB.loadDoctorsListA(connection);Load4mDB.loadDoctorsListA(connection);Load4mDB.loadDoctorsListA(connection);
            beg=System.nanoTime();
            Load4mDB.loadDoctorsListA(connection);
             end= System.nanoTime();
            System.out.println("Load TIME A="+(end-beg));

            Serv.search(connection);
            Serv.sortByName(connection);
            Doctor doctor=new Doctor("Name",new Date(),Gender.MALE,new Area("12"),"ортодонт");
            ArrayList<Doctor> doc=new ArrayList<>();
            doc.add(doctor);
           Save.save(doc,connection);

            connection.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
