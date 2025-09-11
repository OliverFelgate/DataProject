import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.CharConversionException;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        String testFile = "src/main/resources/employees_short.csv";
        EmployeeCsvReader reader = new EmployeeCsvReader();
        ArrayList<Employee> employees = new ArrayList<>();
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
//            System.out.println(FileSerialiser.xmlFileToEmployeeList("src/main/resources/employees.xml"));
            FileSerialiser.xmlFileToEmployeeList("src/main/resources/employees.xml");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // Prefix
        EmployeeLambdaExpressions.filterByTitle(employees, "Mrs.");
        System.out.println("Employees after removing a prefixgti");
        employees.forEach(System.out::println);
        System.out.println(employees.size());

        // ID
        EmployeeLambdaExpressions.sortByID(employees);
        System.out.println("Employees after sorting");
        employees.forEach(System.out::println);

        // Gender
        EmployeeLambdaExpressions.filterByGender(employees);
        System.out.println("Employees after removing males:");
        employees.forEach(System.out::println);

        // Salary
        EmployeeLambdaExpressions.filterBySalary(employees);
        System.out.println("Employees after removing salaries under 100,000:");
        employees.forEach(System.out::println);

        // Email
        EmployeeLambdaExpressions.filterByEmail(employees);
        System.out.println("Employees after removing Gmail, Yahoo, and Hotmail users:");
        employees.forEach(System.out::println);
    }
}
