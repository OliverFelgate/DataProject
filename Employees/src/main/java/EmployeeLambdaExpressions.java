import java.util.List;
import java.util.Objects;

public class EmployeeLambdaExpressions {

    // -------- Prefix --------
    // Remove all employees not with prefix
    public static List<Employee> filterByTitle(List<Employee> employees, String prefix) {
        employees.removeIf(e -> !Objects.equals(e.getNamePrefix(), prefix));
        return employees;
    }
    // -------- Sort ID --------
    // Sort Employees by ID
    public static List<Employee> sortByID(List<Employee> employees) {
        employees.sort((e1, e2) -> Integer.compare(e1.getEmployeeID(), e2.getEmployeeID()));
        return employees;
    }

    // -------- GENDER --------
    //Remove all employees with gender 'M'
    public static List<Employee> filterByGender(List<Employee> employees) {
        employees.removeIf(emp -> emp != null && emp.getGender() == 'M');
        return employees;
    }

    // -------- SALARY --------
    //Remove all employees with salary less than 100,000
    public static List<Employee> filterBySalary(List<Employee> employees) {
        employees.removeIf(emp -> emp != null && emp.getSalary() < 100000);
        return employees;
    }

    // -------- EMAILS --------
    //Remove all employees with gmail, yahoo, or hotmail emails
    public static List<Employee> filterByEmail(List<Employee> employees) {
        employees.removeIf(emp ->
                emp != null &&
                        (emp.getEmail().toLowerCase().contains("gmail.com")
                                || emp.getEmail().toLowerCase().contains("yahoo.co.uk")
                                || emp.getEmail().toLowerCase().contains("hotmail.com"))
        );
        return employees;
    }
}
