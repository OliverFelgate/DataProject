import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

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

    public static void employeeListToXMLFile(List<Employee> employees, String path) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        ArrayList<String> xmlList = new ArrayList<>();

        for (Employee emp : employees) {
            String empXml = mapper.writeValueAsString(emp);
            xmlList.add(empXml);
        }

        try {
            Files.write(Paths.get(path), xmlList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> jsonFileToEmployeeList(String path) {
        List<String> file = new ArrayList<>();
        try {
            file = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // TODO
        // Deserialise file into String array
        // Convert array into Employee object
        return null;
    }

    public static List<Employee> xmlFileToEmployeeList(String path) {
        List<String> file = new ArrayList<>();
        try {
            file = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // TODO
        // Deserialise file into String array
        // Convert array into Employee objects
        return null;
    }
}
