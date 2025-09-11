import java.io.CharConversionException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeLambdaExpressions {

    public static void main(String[] args) throws CharConversionException {
        String fileName = "src/main/resources/employees_short.csv";

        //Read employees from file
        EmployeeCsvReader reader = new EmployeeCsvReader();
        ArrayList<Employee> employees = reader.readEmployees(fileName);

//        // -------- GENDER --------
//
//        //Remove all employees with gender 'M'
//        employees.removeIf(emp -> emp != null && emp.getGender() == 'M');
//
//        //Print remaining employees
//        System.out.println("Employees after removing males:");
//        employees.forEach(System.out::println);

        // -------- SALARY --------

        //Remove all employees with salary less than 100,000
        employees.removeIf(emp -> emp != null && emp.getSalary() < 100000);

        System.out.println("Employees after removing salaries under 100,000:");
        employees.forEach(System.out::println);
    }
}