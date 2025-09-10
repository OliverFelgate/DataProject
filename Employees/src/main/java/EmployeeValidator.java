import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeValidator {

    public static boolean validateId(String data) {
        String regex = "[0-9]{5}";
        Pattern stringPattern = Pattern.compile(regex);
        Matcher stringMatcher = stringPattern.matcher(data);
        return stringMatcher.matches();
    }

    public static boolean validatePrefix(String data) {
        String regex = "[A-Z][a-z]*[\\.]+";
        Pattern stringPattern = Pattern.compile(regex);
        Matcher stringMatcher = stringPattern.matcher(data);
        return stringMatcher.matches();
    }

    public static boolean validateFirstName(String data) {
        String regex = "[A-Z][a-z]*";
        Pattern stringPattern = Pattern.compile(regex);
        Matcher stringMatcher = stringPattern.matcher(data);
        return stringMatcher.matches();
    }

    public static boolean validateMiddleInitial(String data) {
        String regex = "[A-Z]";
        Pattern stringPattern = Pattern.compile(regex);
        Matcher stringMatcher = stringPattern.matcher(data);
        return stringMatcher.matches();
    }

    public static boolean validateLastName(String data) {
        String regex = "[A-Z][a-z]*";
        Pattern stringPattern = Pattern.compile(regex);
        Matcher stringMatcher = stringPattern.matcher(data);
        return stringMatcher.matches();
    }

    public static boolean validateGender(String data) {
        String regex = "[MF]";
        Pattern stringPattern = Pattern.compile(regex);
        Matcher stringMatcher = stringPattern.matcher(data);
        return stringMatcher.matches();
    }

    public static boolean validateEmail(String data) {
        String regex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}";
        Pattern stringPattern = Pattern.compile(regex);
        Matcher stringMatcher = stringPattern.matcher(data);
        return stringMatcher.matches();
    }

    public static boolean validateDob(String data) {
        String regex = "[1-9]{1,2}/[1-9]{1,2}/[1-9]{4}";
        Pattern stringPattern = Pattern.compile(regex);
        Matcher stringMatcher = stringPattern.matcher(data);
        return stringMatcher.matches();
    }

    public static boolean validateDateOfJoining(String data) {
        String regex = "[1-9]{1,2}/[1-9]{1,2}/[1-9]{4}";
        Pattern stringPattern = Pattern.compile(regex);
        Matcher stringMatcher = stringPattern.matcher(data);
        return stringMatcher.matches();
    }

    public static boolean validateSalary(String data) {
        String regex = "[1-9]{4,}";
        Pattern stringPattern = Pattern.compile(regex);
        Matcher stringMatcher = stringPattern.matcher(data);
        return stringMatcher.matches();
    }




}
