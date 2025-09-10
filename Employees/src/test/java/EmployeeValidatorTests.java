import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeValidatorTests {

    //ID Tests

    @Test
    void givenValidId_ReturnsTrue() {
        assertTrue(EmployeeValidator.validateId("198429"));
    }

    @Test
    void givenInvalidId_ReturnsFalse() {
        assertFalse(EmployeeValidator.validateId("19A429")); // contains a letter
        assertFalse(EmployeeValidator.validateId(""));       // empty
        assertFalse(EmployeeValidator.validateId(null));     // null
    }

    //Name Validation

    @Test
    void givenValidName_ReturnsTrue() {
        assertTrue(EmployeeValidator.validateName("Serafina"));
        assertTrue(EmployeeValidator.validateName("O'Connor")); // allow apostrophe
    }

    @Test
    void givenInvalidName_ReturnsFalse() {
        assertFalse(EmployeeValidator.validateName(""));      // empty
        assertFalse(EmployeeValidator.validateName("1234"));  // numbers
        assertFalse(EmployeeValidator.validateName("@Name")); // invalid char
    }

    //Middle initial Validation

    @Test
    void givenValidMiddleInitial_ReturnsTrue() {
        assertTrue(EmployeeValidator.validateMiddleInitial("A"));
        assertTrue(EmployeeValidator.validateMiddleInitial("Z"));
    }

    @Test
    void givenInvalidMiddleInitial_ReturnsFalse() {
        assertFalse(EmployeeValidator.validateMiddleInitial(""));     // empty
        assertFalse(EmployeeValidator.validateMiddleInitial("AB"));   // more than one character
        assertFalse(EmployeeValidator.validateMiddleInitial("a"));    // lowercase
        assertFalse(EmployeeValidator.validateMiddleInitial("1"));    // digit
        assertFalse(EmployeeValidator.validateMiddleInitial("@"));    // special char
        assertFalse(EmployeeValidator.validateMiddleInitial(null));   // null
    }


    //Gender Validation

    @Test
    void givenValidGender_ReturnsTrue() {
        assertTrue(EmployeeValidator.validateGender("M"));
        assertTrue(EmployeeValidator.validateGender("F"));
    }

    @Test
    void givenInvalidGender_ReturnsFalse() {
        assertFalse(EmployeeValidator.validateGender("X"));
        assertFalse(EmployeeValidator.validateGender(""));
    }

    //Email Validation

    @Test
    void givenValidEmail_ReturnsTrue() {
        assertTrue(EmployeeValidator.validateEmail("serafina.bumgarner@exxonmobil.com"));
        assertTrue(EmployeeValidator.validateEmail("test.user123@yahoo.co.uk"));
    }

    @Test
    void givenInvalidEmail_ReturnsFalse() {
        assertFalse(EmployeeValidator.validateEmail("not-an-email"));
        assertFalse(EmployeeValidator.validateEmail("missingatsign.com"));
        assertFalse(EmployeeValidator.validateEmail("user@.com"));
    }

    //Date Validation

    @Test
    void givenValidDate_ReturnsTrue() {
        assertTrue(EmployeeValidator.validateDate("9/21/1982"));   // mm/dd/yyyy
        assertTrue(EmployeeValidator.validateDate("12/1/2008"));   // single digit day
    }

    @Test
    void givenInvalidDate_ReturnsFalse() {
        assertFalse(EmployeeValidator.validateDate("31/02/2000")); // invalid day/month
        assertFalse(EmployeeValidator.validateDate("1982/09/21")); // wrong format
        assertFalse(EmployeeValidator.validateDate(""));           // empty
    }

    //Salary Validation

    @Test
    void givenValidSalary_ReturnsTrue() {
        assertTrue(EmployeeValidator.validateSalary("69294"));
        assertTrue(EmployeeValidator.validateSalary("200000"));
    }

    @Test
    void givenInvalidSalary_ReturnsFalse() {
        assertFalse(EmployeeValidator.validateSalary("-1000"));   // negative
        assertFalse(EmployeeValidator.validateSalary("abc"));     // not a number
        assertFalse(EmployeeValidator.validateSalary(""));        // empty
    }
}
