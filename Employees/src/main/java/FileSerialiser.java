import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileSerialiser {

    public static void employeeListToJsonFile(List<Employee> employees, String path) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<String> jsonList = new ArrayList<>();

        for (Employee emp : employees) {
            String empJson = mapper.writeValueAsString(emp);
            jsonList.add(empJson);
        }

        try {
            Files.write(Paths.get(path), jsonList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
