import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeValidator {

    static Logger logger = LoggerProvider.getLogger();

    public static boolean validateId(String data) {
        String regex = "[0-9]{6}";
        Pattern stringPattern = Pattern.compile(regex);
        Matcher stringMatcher = stringPattern.matcher(data);
        if (!stringMatcher.matches())
            logger.log(Level.WARNING, "Invalid ID " + data);

        return stringMatcher.matches();
    }

    public static boolean validatePrefix(String data) {
        String regex = "[A-Z][a-z]*[\\.]+";
        Pattern stringPattern = Pattern.compile(regex);
        Matcher stringMatcher = stringPattern.matcher(data);
        if (!stringMatcher.matches())
            logger.log(Level.WARNING, "Invalid Prefix " + data);

        return stringMatcher.matches();
    }

    public static boolean validateName(String data) {
        String regex = "^[A-Za-z]+(?:'[A-Za-z]+)*$";
        Pattern stringPattern = Pattern.compile(regex);
        Matcher stringMatcher = stringPattern.matcher(data);
        if (!stringMatcher.matches())
            logger.log(Level.WARNING, "Invalid Name " + data);

        return stringMatcher.matches();
    }

    public static boolean validateMiddleInitial(String data) {
        String regex = "[A-Z]";
        Pattern stringPattern = Pattern.compile(regex);
        Matcher stringMatcher = stringPattern.matcher(data);
        if (!stringMatcher.matches())
            logger.log(Level.WARNING, "Invalid Middle Initial " + data);

        return stringMatcher.matches();
    }

    public static boolean validateGender(String data) {
        String regex = "[MF]";
        Pattern stringPattern = Pattern.compile(regex);
        Matcher stringMatcher = stringPattern.matcher(data);
        if (!stringMatcher.matches())
            logger.log(Level.WARNING, "Invalid Gender " + data);

        return stringMatcher.matches();
    }

    public static boolean validateEmail(String data) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}";
        Pattern stringPattern = Pattern.compile(regex);
        Matcher stringMatcher = stringPattern.matcher(data);
        if (!stringMatcher.matches())
            logger.log(Level.WARNING, "Invalid Email " + data);

        return stringMatcher.matches();
    }

    public static boolean validateDate(String data) {
        String regex = "^(0?[1-9]|1[0-2])/(0?[1-9]|[12][0-9]|3[01])/([0-9]{4})";
        Pattern stringPattern = Pattern.compile(regex);
        Matcher stringMatcher = stringPattern.matcher(data);
        if (!stringMatcher.matches())
            logger.log(Level.WARNING, "Invalid Date " + data);

        return stringMatcher.matches();
    }

    public static boolean validateSalary(String data) {
        String regex = "[1-9][0-9]*";
        Pattern stringPattern = Pattern.compile(regex);
        Matcher stringMatcher = stringPattern.matcher(data);
        if (!stringMatcher.matches())
            logger.log(Level.WARNING, "Invalid Salary " + data);

        return stringMatcher.matches();
    }
}
