import java.io.CharConversionException;
import java.util.ArrayList;

public class EmployeeLambdaExpressions {

    public static void main(String[] args) throws CharConversionException {
        String fileName = "src/main/resources/employees_short.csv";

        //Read employees from file
        EmployeeCsvReader reader = new EmployeeCsvReader();
        ArrayList<Employee> employees = reader.readEmployees(fileName);

        // -------- GENDER --------

        //Remove all employees with gender 'M'
        employees.removeIf(emp -> emp != null && emp.getGender() == 'M');

        //Print remaining employees
        System.out.println("Employees after removing males:");
        employees.forEach(System.out::println);

        // -------- SALARY --------

        //Remove all employees with salary less than 100,000
        employees.removeIf(emp -> emp != null && emp.getSalary() < 100000);

        System.out.println("Employees after removing salaries under 100,000:");
        employees.forEach(System.out::println);

        // -------- EMAILS --------

        //Remove all employees with gmail, yahoo, or hotmail emails
        employees.removeIf(emp ->
                emp != null &&
                        (emp.getEmail().toLowerCase().contains("gmail.com")
                                || emp.getEmail().toLowerCase().contains("yahoo.co.uk")
                                || emp.getEmail().toLowerCase().contains("hotmail.com"))
        );

        System.out.println("Employees after removing Gmail, Yahoo, and Hotmail users:");
        employees.forEach(System.out::println);
    }
}