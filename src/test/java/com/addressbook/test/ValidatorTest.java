package com.addressbook.test;
import com.addressbook.app.UI;
import com.addressbook.app.Validator;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

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
        @DisplayName("validName should throw exception if input is not valid")
        public void validNameThrowsWhenInputIsInvalid() {
            //Arrange
            Validator validator = new Validator();
            //Act
            //Assert
            assertThrows(IllegalStateException.class,
                    ()-> validator.validName("Joe-/ Bloggs"));

        }

        @Test
        @DisplayName("validName should throw exception if input is empty")
        public void validNameThrowsWhenInputIsEmpty() {
            //Arrange
            Validator validator = new Validator();
            //Act
            //Assert
            assertThrows(IllegalStateException.class,
                    ()-> validator.validName(" "));
        }

        @Test
        @DisplayName("validName should throw exception if extreme input is not valid")
        public void validNameThrowsWhenExtremeInputIsInvalid() {
            //Arrange
            Validator validator = new Validator();
            //Act
            //Assert
            assertThrows(IllegalStateException.class,
                    ()->validator.validName("dsfjhfdsgkjijgdkjghdhjtsgntrgufhjgdjhghughduhruhgufnhjfudhfurtg ./ dsfjhfdsgkjijgdkjghdhjtsgntrgufrtfgdgdfhssdhjsduhruhgufnhjfudhfurtg"));
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
        @DisplayName("validPhoneNumber should throw if number is not UK standard")
        public void validPhoneNumberThrowsWhenInputIsNotUKStandard() {
            //Arrange
            Validator validator = new Validator();
            //Act
            //Assert
            assertThrows(IllegalStateException.class,
                    ()-> validator.validPhoneNumber("019283947483"));
        }

        @Test
        @DisplayName("validPhoneNumber throws if extreme input is not valid")
        public void validPhoneNumberFalseWhenExtremeInputIsInvalid() {
            //Arrange
            Validator validator = new Validator();
            //Act
            //Assert
            assertThrows(IllegalStateException.class,
                    ()-> validator.validPhoneNumber("dsfjhfdsgkjijgdkjghdhjtsgntrgufhjgdjhghughduhruhgufnhjfudhfurtg ./ dsfjhfdsgkjijgdkjghdhjtsgntrgufrtfgdgdfhssdhjsduhruhgufnhjfudhfurtg"));
        }

        @Test
        @DisplayName("validPhoneNumber should throw if number is empty")
        public void validPhoneNumberThrowsWhenInputIsEmpty() {
            //Arrange
            Validator validator = new Validator();
            //Act
            //Assert
            assertThrows(IllegalStateException.class,
                    ()-> validator.validPhoneNumber(" "));
        }
    }

    @Nested
    @DisplayName(("Validator Email Tests"))
    class ValidatorEmailTests {
        @Test
        @DisplayName("validEmail should return true if input is valid")
        public void validEmailTrueWhenInputIsValid() {
            //Arrange
            Validator validator = new Validator();
            //Act
            boolean actual = validator.validEmail("johnny12@gmail.com");
            //Assert
            assertTrue(actual);
        }

        @Test
        @DisplayName("validEmail should return true if extreme input is valid")
        public void validEmailTrueWhenExtremeInputIsValid() {
            //Arrange
            Validator validator = new Validator();
            //Act
            boolean actual = validator.validEmail("dhdsuhijfgdshgghgfhggfjhnkgfdghhgdghjghjhhggjduhs@domaidsfgdfhgdhfuidgifsuddfgjifdijiofgsdofgidjfdgfdn.com");
            //Assert
            assertTrue(actual);
        }

        @Test
        @DisplayName("validEmail should throw if input is not conforming to RFC-5322")
        public void validEmailThrowsWhenInputIsInvalid() {
            //Arrange
            Validator validator = new Validator();
            //Act
            //Assert
            assertThrows(IllegalStateException.class,
                    ()-> validator.validEmail("dfgighooifg@fdsijidfs.`com.com"));
        }

        @Test
        @DisplayName("validEmail should throw if extreme input is not valid")
        public void validEmailThrowsWhenExtremeInputIsInvalid() {
            //Arrange
            Validator validator = new Validator();
            //Act
            //Assert
            assertThrows(IllegalStateException.class,
                    ()-> validator.validEmail("dsfjhfdsgkjijg`dkjghdhj`tsgntrgufhjgdjhghughduhruhgufnhjfudhfurtg./`@d`sfjhfdsgkjijgdkjghdhjtsgntrgufrtfgdgdfhssdhjsduhruhgufnhjfudhfurtg.com"));
        }

        @Test
        @DisplayName("validEmail should throw if input is empty")
        public void validEmailThrowsWhenInputIsEmpty() {
            //Arrange
            Validator validator = new Validator();
            //Act
            //Assert
            assertThrows(IllegalStateException.class,
                    ()-> validator.validEmail(""));
        }
    }
    @Nested
    @DisplayName(("Validator checkEmpty Tests"))
    class ValidatorCheckEmptyTests {
        @Test
        @DisplayName("returns all false if all inputs are not empty")
        public void allFalseWhenAllInputsAreNotEmpty() {
            //Arrange
            Validator validator = new Validator();
            //Act
            boolean[] actual = validator.checksEmpty("John Doe", "07937473723", "john@doe.com");
            //Assert
            assertAll(
                    () -> assertFalse(actual[0]),
                    () -> assertFalse(actual[1]),
                    () -> assertFalse(actual[2])
            );
        }

        @Test
        @DisplayName("Returns two false if two inputs are not empty")
        public void TwoTrueWhenTwoInputsAreNotEmpty() {
            //Arrange
            Validator validator = new Validator();
            //Act
            boolean[] actual = validator.checksEmpty("John Doe", "07937473723", "");
            //Assert
            assertAll(
                    () -> assertFalse(actual[0]),
                    () -> assertFalse(actual[1]),
                    () -> assertTrue(actual[2])
            );
        }

        @Test
        @DisplayName("Returns one true if 1 input is not empty")
        public void OneTrueWhenOneInputIsNotEmpty() {
            //Arrange
            Validator validator = new Validator();
            //Act
            boolean[] actual = validator.checksEmpty("", "07937473723", "");
            //Assert
            assertAll(
                    () -> assertTrue(actual[0]),
                    () -> assertFalse(actual[1]),
                    () -> assertTrue(actual[2])
            );
        }

        @Test
        @DisplayName("Throws exception if all inputs are empty")
        public void falseWhenInputsAreEmpty() {
            //Arrange
            Validator validator = new Validator();
            //Act
            //Assert
            assertThrows(IllegalStateException.class,
                    ()-> validator.checksEmpty("", "", ""));
        }
    }
}
