package DB;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class Load4mFile {
    public static Clinic load() throws IOException {
        Clinic clinic1 = null;
        String clinicStr = "";
        File file = new File("bank.json");

        if (file.exists()) {
            clinicStr = new String(Files.readAllBytes(file.toPath()));
        }

        clinic1 = new Gson().fromJson(clinicStr, Clinic.class);

        return clinic1;
    }

    /**
     * Пример чтения из файла массива JSON объектов
     */
    public static List<Doctor> loadPersonList() throws IOException, JsonSyntaxException {
        String pStr = "";
        File file = new File("doctors.json");

        if (file.exists()) {
            pStr = new String(Files.readAllBytes(file.toPath()));
        } else {
            System.out.println("File doctors.json not found!");
        }

        Gson gson = new Gson();

        Doctor[] plst = gson.fromJson(pStr, Doctor[].class);

        return Arrays.asList(plst);
    }
}
