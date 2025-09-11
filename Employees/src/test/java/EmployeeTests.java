import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.*;

import java.io.CharConversionException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
        LocalDate date1 = LocalDate.of(1982, 9, 21);
        LocalDate date2 = LocalDate.of(2008, 1, 2);
        String line = "198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,09/21/1982,01/02/2008,69294";

        Employee emp = null;
        try {
            emp = reader.createEmployee(line);
        } catch (CharConversionException e) {
            e.printStackTrace();
        }

        assertEquals(198429, emp.getEmployeeID());
        assertEquals("Mrs.", emp.getNamePrefix());
        assertEquals("Serafina", emp.getFirstName());
        assertEquals('I', emp.getMiddleInitial());
        assertEquals("Bumgarner", emp.getLastName());
        assertEquals('F', emp.getGender());
        assertEquals("serafina.bumgarner@exxonmobil.com", emp.getEmail());
        assertEquals(date1, emp.getDateOfBirth());
        assertEquals(date2, emp.getDateOfJoining());
        assertEquals(69294, emp.getSalary());
    }

    // --------------- Read File Lines

//    @Test
//    void givenCsvFile_readFileLines_ReturnsCorrectLength() {
//        List<String> lines = reader.readFileLines(testFile);
//
//        assertEquals(11, lines.size()); // 1 header + 10 rows
//    }

//    @Test
//    void givenCsvFile_readFileLines_FirstLineIsHeader() {
//        List<String> lines = reader.readFileLines(testFile);
//
//        assertTrue(lines.get(0).startsWith("Emp ID"));
//    }
//
//    @Test
//    void givenCsvFile_readFileLines_LastLineIsCorrect() {
//        List<String> lines = reader.readFileLines(testFile);
//
//        assertTrue(lines.get(10).contains("744723")); //ID of last employee
//        assertTrue(lines.get(10).contains("Bibi"));
//    }

    // --------------- Read Employee Tests

    @Test
    void givenCsvFile_readEmployees_ReturnsCorrectLength() {
        ArrayList<Employee> employees = null;
        try {
            employees = reader.readEmployees(testFile);
        } catch (CharConversionException | IllegalArgumentException e) {
            e.printStackTrace();
        }

        assertEquals(10, employees.size());
    }

    @Test
    void givenCsvFile_readEmployees_FirstEmployeeIsCorrect() {
        ArrayList<Employee> employees = null;
        try {
            employees = reader.readEmployees(testFile);
        } catch (CharConversionException | IllegalArgumentException e) {
            e.printStackTrace();
        }

        Employee first = employees.get(0);

        assertEquals(198429, first.getEmployeeID());
        assertEquals("Serafina", first.getFirstName());
        assertEquals("Bumgarner", first.getLastName());
    }

    @Test
    void givenCsvFile_readEmployees_LastEmployeeIsCorrect() {
        ArrayList<Employee> employees = null;
        try {
            employees = reader.readEmployees(testFile);
        } catch (CharConversionException | IllegalArgumentException e) {
            e.printStackTrace();
        }

        Employee last = employees.get(employees.size() - 1);

        assertEquals(744723, last.getEmployeeID());
        assertEquals("Bibi", last.getFirstName());
        assertEquals("Paddock", last.getLastName());
    }

//    -------------------------------- TASK 2 --------------------------------

    // Salary conversion tests
    @Test
    void givenValidSalaryString_convertSalary_ReturnsInt() {
        int salary = reader.convertStringToInt("69294");
        assertEquals(69294, salary);
    }

    @Test
    void givenInvalidSalaryString_convertSalary_ThrowsException() {
        assertThrows(NumberFormatException.class,
                () -> reader.convertStringToInt("notANumber"));
    }


    // Date Conversion Tests
    @Test
    void givenValidDateString_convertDate_ReturnsLocalDate() {
        LocalDate dob = reader.convertStringToDate("09/21/1982"); // dd/MM/yyyy
        assertEquals(LocalDate.of(1982, 9, 21), dob);
    }

    @Test
    void givenInvalidDateString_convertDate_ThrowsException() {
        assertThrows(RuntimeException.class,
                () -> reader.convertStringToDate("1982-09-21")); // wrong format
    }

    // Gender Conversion tests
    @Test
    void givenValidGenderString_convertGender_ReturnsChar() {
        char gender = 0;
        try {
            gender = reader.convertStringToChar("M");
        } catch (CharConversionException e) {
            e.printStackTrace();
        }
        assertEquals('M', gender);
    }

    @Test
    void givenInvalidGenderString_convertGender_ThrowsException() {
        assertThrows(CharConversionException.class,
                () -> reader.convertStringToChar("XYZ"));
    }

    //Employee creation with parsed data
    @Test
    void givenValidLine_createEmployee_ReturnsEmployeeWithCorrectTypes() {
        String line = "198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,09/21/1982,02/01/2008,69294";

        Employee emp = null;
        try {
            emp = reader.createEmployee(line);
        } catch (CharConversionException e) {
            e.printStackTrace();
        }

        assertEquals(198429, emp.getEmployeeID()); // now int
        assertEquals("Mrs.", emp.getNamePrefix());
        assertEquals("Serafina", emp.getFirstName());
        assertEquals('F', emp.getGender()); // now char
        assertEquals("serafina.bumgarner@exxonmobil.com", emp.getEmail());
        assertEquals(LocalDate.of(1982, 9, 21), emp.getDateOfBirth()); // now LocalDate
        assertEquals(LocalDate.of(2008, 2, 1), emp.getDateOfJoining()); // now LocalDate
        assertEquals(69294, emp.getSalary()); // now int
    }

    @Test
    void givenInvalidLine_createEmployee_ThrowsException() {
        // salary is invalid ("abc")
        String badLine = "198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,9/21/1982,2/1/2008,abc";

        assertThrows(RuntimeException.class,
                () -> reader.createEmployee(badLine));
    }
}
