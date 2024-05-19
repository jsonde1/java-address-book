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


    }
}
