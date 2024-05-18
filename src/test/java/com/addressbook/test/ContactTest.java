package com.addressbook.test;

import com.addressbook.app.Contact;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class ContactTest {
    @Nested
    @DisplayName("ContactConstructorTests")
    class ContactConstructorTests {

        @Test
        @DisplayName(" Contact Obj with Valid Parameters Successfully Created")
        public void ValidContactSucessfullyCreated() {
            //Arrange
            //Act
            Contact contact = new Contact("John AppleSeed", "07636453823", "john@apple.com");
            //Assert
            assertTrue(contact instanceof Contact);
        }


        @Test
        @DisplayName(" Contact Obj with Extreme Valid Parameters Successfully Created")
        public void ContactObjwithExtremeValidParametersSuccessfullyCreated() {
            //Arrange
            //Act
            Contact contact = new Contact("fdjijdihrtdhuirewhugewayt6rewfeug74rfghfrwhiorejoijf8jrijhiorugrhrejugihuirhdehre8fguhiufhuhuruiruhu", "07999999999", "fdjijdihrtdhuirewhugewayt6rewfeug74rfghfrwhiorejoijf8jrijhiorugrhrejugi@erwuiyhreyryuroiutyuiyfuiiugyuirrgf.com");
            //Assert
            assertTrue(contact instanceof Contact);
        }


    }

    @Nested
    @DisplayName("ContactGetterTests")
    class ContactGetterTests {

        @Test
        @DisplayName("getName Successfully Returns name")
        public void getNameSSuccessfullyReturnsName() {
            //Arrange
            //Act
            Contact contact = new Contact("John", "07636453823", "john@apple.com");
            //Assert
            assertEquals("John", contact.getName());
        }


        @Test
        @DisplayName("getPhoneNumber Successfully Returns phoneNumber")
        public void getPhoneNumberSuccessfullyReturnsPhoneNumber() {
            //Arrange
            //Act
            Contact contact = new Contact("John", "07636453823", "john@apple.com");
            //Assert
            assertEquals("07636453823", contact.getPhoneNumber());
        }

        @Test
        @DisplayName("getEmail Successfully Returns email")
        public void getEmailSuccessfullyReturnsEmail() {
            //Arrange
            //Act
            Contact contact = new Contact("John", "07636453823", "john@apple.com");
            //Assert
            assertEquals("john@apple.com", contact.getEmail());
        }


    }

    @Nested
    @DisplayName("ContactSetterTests")
    class ContactSetterTests {

        @Test
        @DisplayName("setName Successfully changes name")
        public void setNameSuccessfullyChangesName() {
            //Arrange
            //Act
            Contact contact = new Contact("John", "07636453823", "john@apple.com");
            contact.setName("Jimmy");
            //Assert
            assertEquals("Jimmy", contact.getName());
        }

        @Test
        @DisplayName("setPhoneNumber Successfully changes phoneNumber")
        public void setPhoneNumberSuccessfullyChangesPhoneNumber() {
            //Arrange
            //Act
            Contact contact = new Contact("John", "07636453823", "john@apple.com");
            contact.setPhoneNumber("07937635527");
            //Assert
            assertEquals("07937635527", contact.getPhoneNumber());
        }

        @Test
        @DisplayName("setEmail Successfully changes email")
        public void setEmailSuccessfullyChangesEmail() {
            //Arrange
            //Act
            Contact contact = new Contact("John", "07636453823", "john@apple.com");
            contact.setEmail("johnappleseed@gmail.com");
            //Assert
            assertEquals("johnappleseed@gmail.com", contact.getEmail());
        }


    }

}
