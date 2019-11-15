package DB;

import com.google.gson.Gson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class Save {
    public static void save(List<Doctor> doctors, Connection connection) throws SQLException {

        if (doctors != null && doctors.size() > 0) {
            Gson gson=new Gson();
            String personAsJson=gson.toJson(doctors);

            Long beg=System.nanoTime();
            PreparedStatement statement = connection.
                    prepareStatement("insert into jtest (a) values ( cast( ? as json))");
            statement.setString(1, personAsJson);
            statement.executeUpdate();
            Long end=System.nanoTime();
            System.out.println("SAVE TIME A="+(end-beg));
            statement.close();

            beg=System.nanoTime();
            statement = connection.
                    prepareStatement("insert into jtest (b) values ( cast( ? as json) )");
            statement.setString(1, personAsJson);
            statement.executeUpdate();
            end=System.nanoTime();
            System.out.println("SAVE TIME B="+(end-beg));

        }
    }

}
