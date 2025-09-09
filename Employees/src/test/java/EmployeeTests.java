import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeTests {
    private EmployeeCsvReader reader;
    private String testFile = "src/main/resources/employees_short.csv"; // adjust path if needed

    @BeforeEach
    void setup() {
        reader = new EmployeeCsvReader();
    }

    // -------------- Employee Test

    @Test
    void givenLineOfCsv_createEmployee_ReturnsCorrectEmployee() {
        String line = "198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,9/21/1982,2/1/2008,69294";

        Employee emp = reader.createEmployee(line);

        assertEquals("198429", emp.getEmployeeID());
        assertEquals("Mrs.", emp.getNamePrefix());
        assertEquals("Serafina", emp.getFirstName());
        assertEquals("I", emp.getMiddleInitial());
        assertEquals("Bumgarner", emp.getLastName());
        assertEquals("F", emp.getGender());
        assertEquals("serafina.bumgarner@exxonmobil.com", emp.getEmail());
        assertEquals("9/21/1982", emp.getDateOfBirth());
        assertEquals("2/1/2008", emp.getDateOfJoining());
        assertEquals("69294", emp.getSalary());
    }

    // --------------- Read File Lines

    @Test
    void givenCsvFile_readFileLines_ReturnsCorrectLength() {
        List<String> lines = reader.readFileLines(testFile);

        assertEquals(11, lines.size()); // 1 header + 10 rows
    }

    @Test
    void givenCsvFile_readFileLines_FirstLineIsHeader() {
        List<String> lines = reader.readFileLines(testFile);

        assertTrue(lines.get(0).startsWith("Employee ID"));
    }

    @Test
    void givenCsvFile_readFileLines_LastLineIsCorrect() {
        List<String> lines = reader.readFileLines(testFile);

        assertTrue(lines.get(10).contains("744723")); //ID of last employee
        assertTrue(lines.get(10).contains("Bibi"));
    }

    // --------------- Read Employee Tests

    @Test
    void givenCsvFile_readEmployees_ReturnsCorrectLength() {
        ArrayList<Employee> employees = reader.readEmployees(testFile);

        assertEquals(10, employees.size());
    }

    @Test
    void givenCsvFile_readEmployees_FirstEmployeeIsCorrect() {
        ArrayList<Employee> employees = reader.readEmployees(testFile);

        Employee first = employees.get(0);

        assertEquals("198429", first.getEmployeeID());
        assertEquals("Serafina", first.getFirstName());
        assertEquals("Bumgarner", first.getLastName());
    }

    @Test
    void givenCsvFile_readEmployees_LastEmployeeIsCorrect() {
        ArrayList<Employee> employees = reader.readEmployees(testFile);

        Employee last = employees.get(employees.size() - 1);

        assertEquals("744723", last.getEmployeeID());
        assertEquals("Bibi", last.getFirstName());
        assertEquals("Paddock", last.getLastName());
    }

}
