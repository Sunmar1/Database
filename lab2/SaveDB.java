import com.google.gson.Gson;

import java.io.*;
import java.util.List;

public class SaveDB {

    public static void saveDoctorList(List<Doctor> doctors) throws IOException {

        if (doctors != null && doctors.size() > 0) {
            Gson gson = new Gson();

            String personsAsJson = gson.toJson(doctors);
            System.out.println(personsAsJson);

            BufferedWriter bw=new BufferedWriter(new FileWriter(new File("persons.json")));
            bw.write(personsAsJson);
            bw.close();

        }
    }
}
