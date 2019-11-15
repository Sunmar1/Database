package DB;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.postgresql.core.SqlCommand;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Load4mDB {

    public static Clinic load() throws IOException {
        Clinic clinic = null;
        String clinicStr = "";
        File file = new File("clinic.json");

        if (file.exists()) {
            clinicStr = new String(Files.readAllBytes(file.toPath()));
        }

        clinic = new Gson().fromJson(clinicStr, Clinic.class);

        return clinic;
    }

    /**
     * Пример чтения из файла массива JSON объектов
     */
    public static List<Doctor> loadDoctorsListB(Connection connection) throws JsonSyntaxException, SQLException {

        String pStr = "";


        PreparedStatement statement =
                connection.prepareStatement("select b from jtest ");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            pStr = resultSet.getString("b");

        }

        statement.close();

        Gson gson = new Gson();

        Doctor[] plst = gson.fromJson(pStr, Doctor[].class);


        statement =
                connection.prepareStatement("select b  as c from jtest ");

        resultSet = statement.executeQuery();

        while (resultSet.next()) {
            pStr = resultSet.getString("c");

        }

        return Arrays.asList(plst);

    }
    public static List<Doctor> loadDoctorsListA(Connection connection) throws JsonSyntaxException, SQLException {

        String pStr = "";


        PreparedStatement statement =
                connection.prepareStatement("select a from jtest ");

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            pStr = resultSet.getString("a");

        }

        statement.close();

        Gson gson = new Gson();

        Doctor[] plst = gson.fromJson(pStr, Doctor[].class);


        statement =
                connection.prepareStatement("select a  as c from jtest ");

        resultSet = statement.executeQuery();

        while (resultSet.next()) {
            pStr = resultSet.getString("c");

        }
        return Arrays.asList(plst);

    }
}
