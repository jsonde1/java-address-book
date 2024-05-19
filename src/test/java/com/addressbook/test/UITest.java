package com.addressbook.test;

import com.addressbook.app.Contact;
import com.addressbook.app.UI;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UITest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Nested
    @DisplayName("UIConstructorTests")
    class UIConstructorTests {

        @DisplayName("Check that UI class cannot be instantiated")
        public void UIClassCannotBeInstantiated() {
            //Arrange

            // Act
            //I ui = new UI();
            //Assert
            //assertThrows(ui);
        }


    }

    @Nested
    class UIPrintTests {

        @Test
        @DisplayName("Check that MainMenu prints correct text")
        public void MainMenuPrintsCorrectText() {
            //Arrange
            // Act
            UI.mainMenu();
            //Assert
            assertEquals("""
                    Welcome to your AddressBook!\s
                     Please type in the number of the option you would like to access! \

                     1.Add a Contact\s
                     2.Search for Contact\s
                     3.Delete Contact\s
                     4.Update Contact\s
                     5.Show All Contacts\s
                     6.Exit""", outContent.toString().trim());
        }

        @Test
        @DisplayName("Check that PrintLine prints the correct text")
        public void PrintLinePrintsCorrectText() {
            //Arrange
            // Act
            UI.printLine("hello hi");
            //Assert
            assertEquals("hello hi", outContent.toString().trim());
        }

        @Test
        @DisplayName("Check that DeleteContact prints the correct text")
        public void DeleteContactPrintsCorrectText() {
            //Arrange
            String input = "07546746370";
            Scanner sc = new Scanner(new ByteArrayInputStream(input.getBytes()));
            // Act
            UI.deleteContactUI(sc);
            //Assert
            assertEquals("Please enter the number of the contact you would like to delete", outContent.toString().trim());
        }

        @Test
        @DisplayName("Check that printContacts prints the correct text")
        public void printContactsPrintsCorrectText() {
            //Arrange
            Contact mockContact = mock(Contact.class);
            Contact[] contacts = {mockContact};
            when(mockContact.getName()).thenReturn("John Doe");
            when(mockContact.getPhoneNumber()).thenReturn("07987463527");
            when(mockContact.getEmail()).thenReturn("john.doe@gmail.com");
            // Act
            UI.printContacts(contacts);
            //Assert
            assertEquals("""
                    Name: John Doe\

                    Phone Number: 07987463527\

                    Email: john.doe@gmail.com""", outContent.toString().trim());
        }

        @Test
        @DisplayName("Check that addContactUI prints the correct text")
        public void addContactUIPrintsCorrectText() {
            //Arrange
            Scanner sc = Mockito.mock(Scanner.class);
            Mockito.when(sc.nextLine()).thenReturn("John Doe").thenReturn("07987463527").thenReturn("john@doe.com");
            //String[] input = {"John Doe", "07987463527", "john@doe.com"};
            //Scanner sc = new Scanner(new ByteArrayInputStream(input));
            // Act
            UI.addContactUI(sc);
            //Assert
            //trim removes whitespace
            //replace removes line breaks(due to differences in line breaks between OSes)
            assertEquals("""
                    Please enter the name of the contact you would like to add
                    Please enter the phone number of the contact you would like to add
                    Please enter the email of the contact you would like to add""", outContent.toString().trim().replace("\r",""));
        }

        @Test
        @DisplayName("Check that editContactUI prints the correct text")
        public void editContactUIPrintsCorrectText() {
            //Arrange
            Scanner sc = Mockito.mock(Scanner.class);
            Mockito.when(sc.nextLine()).thenReturn("07964759384").thenReturn("John Doe")
                    .thenReturn("07987463527").thenReturn("john@doe.com");
            // Act
            UI.editContactUI(sc);
            //Assert
            assertEquals("""
                    Please enter the saved number of the contact you would like to edit
                    Please enter the new name for the contactor press enter to leave it unchanged.
                    Please enter the new phone number for the contactor press enter to leave it unchanged.
                    Please enter the new email for the contactor press enter to leave it unchanged.""", outContent.toString().trim().replace("\r",""));
        }


    }

    @Nested
    @DisplayName("UI Return Tests")
    class UIReturnTests {
        @Test
        @DisplayName("Check that addContactUI returns user input")
        public void addContactUIReturnsUserInput() {
            //Arrange
            String[] input = {"John Doe", "07987463527", "john@doe.com"};
            Scanner sc = Mockito.mock(Scanner.class);
            Mockito.when(sc.nextLine()).thenReturn(input[0]).thenReturn(input[1]).thenReturn(input[2]);
            // Act
            String[] output = UI.addContactUI(sc);
            //Assert
            assertAll(
                    () -> assertEquals(input[0], output[0]),
                    () -> assertEquals(input[1], output[1]),
                    () -> assertEquals(input[2], output[2])
            );
        }

        @Test
        @DisplayName("Check that deleteContactUI returns user input")
        public void deleteContactUIReturnsUserInput() {
            //Arrange
            Scanner sc = Mockito.mock(Scanner.class);
            Mockito.when(sc.nextLine()).thenReturn("07583746374");
            // Act
            String output = UI.deleteContactUI(sc);
            //Assert
            assertEquals("07583746374",output);

        }


    }
}
