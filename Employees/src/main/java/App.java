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
    }
}
