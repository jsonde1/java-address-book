package com.addressbook.test;
import com.addressbook.app.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {
    @Nested
    @DisplayName(("Validator Name Tests"))
    class ValidatorNameTests {
        @Test
        @DisplayName("validName should return true if input is valid")
        public void validNameTrueWhenInputIsValid() {
            //Arrange
            Validator validator = new Validator();
            //Act
            boolean actual = validator.validName("John Doe");
            //Assert
            assertTrue(actual);
        }

        @Test
        @DisplayName("validName should return true if extreme input is valid")
        public void validNameTrueWhenExtremeInputIsValid() {
            //Arrange
            Validator validator = new Validator();
            //Act
            boolean actual = validator.validName("dsfjhfdsgkjijgdkjghdhjtsgntrgufhjgdjhghughduhruhgufnhjfudhfurtg fgiduiorehnuhreuheurhuoireuhhfgtocuifd");
            //Assert
            assertTrue(actual);
        }

        @Test
        @DisplayName("validName should return false if input is not valid")
        public void validNameFalseWhenInputIsInvalid() {
            //Arrange
            Validator validator = new Validator();
            //Act
            boolean actual = validator.validName("Joe-/ Bloggs");
            //Assert
            assertFalse(actual);
        }

        @Test
        @DisplayName("validName should return false if extreme input is not valid")
        public void validNameFalseWhenExtremeInputIsInvalid() {
            //Arrange
            Validator validator = new Validator();
            //Act
            boolean actual = validator.validName("dsfjhfdsgkjijgdkjghdhjtsgntrgufhjgdjhghughduhruhgufnhjfudhfurtg ./ dsfjhfdsgkjijgdkjghdhjtsgntrgufrtfgdgdfhssdhjsduhruhgufnhjfudhfurtg");
            //Assert
            assertFalse(actual);
        }
    }

    @Nested
    @DisplayName(("Validator Phone Number Tests"))
    class ValidatorPhoneNumberTests {
        @Test
        @DisplayName("validPhoneNumber should return true if input is valid")
        public void validPhoneNumberTrueWhenInputIsValid() {
            //Arrange
            Validator validator = new Validator();
            //Act
            boolean actual = validator.validPhoneNumber("07974884593");
            //Assert
            assertTrue(actual);
        }

        @Test
        @DisplayName("validPhoneNumber should return false if input is not valid")
        public void validPhoneNumberFalseWhenInputIsInvalid() {
            //Arrange
            Validator validator = new Validator();
            //Act
            boolean actual = validator.validPhoneNumber("019283947483");
            //Assert
            assertFalse(actual);
        }

        @Test
        @DisplayName("validPhoneNumber should return false if extreme input is not valid")
        public void validPhoneNumberFalseWhenExtremeInputIsInvalid() {
            //Arrange
            Validator validator = new Validator();
            //Act
            boolean actual = validator.validPhoneNumber("dsfjhfdsgkjijgdkjghdhjtsgntrgufhjgdjhghughduhruhgufnhjfudhfurtg ./ dsfjhfdsgkjijgdkjghdhjtsgntrgufrtfgdgdfhssdhjsduhruhgufnhjfudhfurtg");
            //Assert
            assertFalse(actual);
        }
    }

}
