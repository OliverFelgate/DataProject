import java.io.CharConversionException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeCsvReader { ;
    private static final Logger logger = LoggerProvider.getLogger();
    private final List<String> invalidLines = new ArrayList<>();

    public EmployeeCsvReader() {
        logger.setLevel(Level.CONFIG);
    }

    public List<String> getInvalidLines() {
        return invalidLines;
    }

    public Employee createEmployee(String line) throws CharConversionException {
        var splitLine = line.split(",");
        if (validateLine(splitLine)) {
            return new Employee(
                    convertStringToInt(splitLine[0].trim()),
                    splitLine[1].trim(),
                    splitLine[2].trim(),
                    convertStringToChar(splitLine[3].trim()),
                    splitLine[4].trim(),
                    convertStringToChar(splitLine[5].trim()),
                    splitLine[6].trim(),
                    convertStringToDate(splitLine[7].trim()),
                    convertStringToDate(splitLine[8].trim()),
                    convertStringToInt(splitLine[9].trim())
            );
        } else {
            invalidLines.add(line);
            logger.log(Level.WARNING, "Line contains invalid data: " + line);
//            throw new IllegalArgumentException();
            return null;
        }
    }


    public List<String> readFileLines(String filePath) {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public ArrayList<Employee> readEmployees(String fileName) throws CharConversionException {
        List<String> lines = readFileLines(fileName);
        ArrayList<Employee> employees = new ArrayList<>(lines.size());
        for(String line: lines)
            employees.add(createEmployee(line));

        return employees;
    }

    public LocalDate convertStringToDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        return LocalDate.parse(dateString, formatter);
    }

    public int convertStringToInt(String intString) {
        return Integer.parseInt(intString);
    }

    public char convertStringToChar(String charString) throws CharConversionException {
        if (charString.length()!= 1)
            throw new CharConversionException();
        return charString.charAt(0);
    }

    private boolean validateLine(String[] line) {
        return EmployeeValidator.validateId(line[0]) &&
                EmployeeValidator.validatePrefix(line[1]) &&
                EmployeeValidator.validateName(line[2]) &&
                EmployeeValidator.validateMiddleInitial(line[3]) &&
                EmployeeValidator.validateName(line[4]) &&
                EmployeeValidator.validateGender(line[5]) &&
                EmployeeValidator.validateEmail(line[6]) &&
                EmployeeValidator.validateDate(line[7]) &&
                EmployeeValidator.validateDate(line[8]) &&
                EmployeeValidator.validateSalary(line[9]);
    }
}
