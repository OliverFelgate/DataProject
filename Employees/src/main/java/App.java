import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.CharConversionException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        String testFile = "src/main/resources/employees(in).csv";
        EmployeeCsvReader reader = new EmployeeCsvReader();
        ArrayList<Employee> employees = null;
        try {
            employees = reader.readEmployees(testFile);
        } catch (CharConversionException | IllegalArgumentException e) {
            e.printStackTrace();
        }
//        System.out.println(employees);
        System.out.println(reader.getInvalidLines().size());

        try {
            assert employees != null;
//            FileSerialiser.employeeListToJsonFile(employees, "src/main/resources/employees.json");
            FileSerialiser.employeeListToXMLFile(employees, "src/main/resources/employees.xml");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        try {
//            System.out.println(FileSerialiser.jsonFileToEmployeeList("src/main/resources/employees.json"));
            System.out.println(FileSerialiser.xmlFileToEmployeeList("src/main/resources/employees.xml"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
