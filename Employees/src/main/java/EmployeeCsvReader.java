import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCsvReader { ;

    public Employee createEmployee(String line) {
        var splitLine = line.split(",");
        return new Employee(
                splitLine[0].trim(),
                splitLine[1].trim(),
                splitLine[2].trim(),
                splitLine[3].trim(),
                splitLine[4].trim(),
                splitLine[5].trim(),
                splitLine[6].trim(),
                splitLine[7].trim(),
                splitLine[8].trim(),
                splitLine[9].trim()
        );
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

    public ArrayList<Employee> readEmployees(String fileName) {
        List<String> lines = readFileLines(fileName);
        ArrayList<Employee> employees = new ArrayList<>(lines.size());
        for(String line: lines)
            employees.add(createEmployee(line));

        return employees;
    }
}
