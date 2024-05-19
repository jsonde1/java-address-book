package com.addressbook.test;

import com.addressbook.app.AddressBook;
import com.addressbook.app.Contact;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AddressBookTest {

    @Nested
    @DisplayName("Address Book Add Tests")
    class AddressBookAddTests {

        @Test
        @DisplayName("Valid Contact Obj Successfully Added To AddressBook")
        public void ValidContactObjSuccessfullyAddedToAddressBook() {
            //Arrange
            AddressBook addressBook = new AddressBook();
            Contact mockContact = mock(Contact.class);
            //Act
            addressBook.addContact(mockContact);
            Contact[] contacts = addressBook.getContactList();
            //Assert
            assertEquals(mockContact,contacts[0]);
        }

        @Test
        @DisplayName(" Valid Contact Obj with existing number is Not Added To AddressBook")
        public void DuplicateNumberValidContactObjisNotAddedToAddressBook() {
            //Arrange
            AddressBook addressBook = new AddressBook();
            Contact mockContact = mock(Contact.class);
            Contact mockContact2 = mock(Contact.class);
            Mockito.when(mockContact.getPhoneNumber()).thenReturn("07462352643");
            Mockito.when(mockContact2.getPhoneNumber()).thenReturn("07462352643");
            //Act
            addressBook.addContact(mockContact);
            addressBook.addContact(mockContact2);
            Contact[] contacts = addressBook.getContactList();
            //Assert
            assertEquals(1,contacts.length);
        }

        @Test
        @DisplayName(" Valid Contact Obj with existing email is Not Added To AddressBook")
        public void DuplicateEmailValidContactObjisNotAddedToAddressBook() {
            //Arrange
            AddressBook addressBook = new AddressBook();
            Contact mockContact = mock(Contact.class);
            Contact mockContact2 = mock(Contact.class);
            Mockito.when(mockContact.getPhoneNumber()).thenReturn("07462352643");
            Mockito.when(mockContact2.getPhoneNumber()).thenReturn("07946352632");
            Mockito.when(mockContact.getEmail()).thenReturn("John@Smith.com");
            Mockito.when(mockContact2.getEmail()).thenReturn("John@Smith.com");
            //Act
            addressBook.addContact(mockContact);
            addressBook.addContact(mockContact2);
            Contact[] contacts = addressBook.getContactList();
            //Assert
            assertEquals(1,contacts.length);
        }
    }

    @Nested
    @DisplayName(("Address Book Search Tests"))
    class AddressBookSearchTests {
        @Test
        @DisplayName("Search By Name Should Successfully Return Matching Contacts")
        public void SearchByNameShouldSuccessfullyReturnMatchingContacts() {
            // Arrange
            AddressBook addressBook = new AddressBook();
            Contact mockContact = mock(Contact.class);
            Contact mockContact2 = mock(Contact.class);
            Mockito.when(mockContact.getName()).thenReturn("Johnny");
            Mockito.when(mockContact2.getName()).thenReturn("Tim");
            Mockito.when(mockContact.getPhoneNumber()).thenReturn("07837283422");
            Mockito.when(mockContact2.getPhoneNumber()).thenReturn("07836241521");
            Mockito.when(mockContact.getEmail()).thenReturn("johnny@job.com");
            Mockito.when(mockContact2.getEmail()).thenReturn("tim@barry.com");
            // Act
            addressBook.addContact(mockContact);
            addressBook.addContact(mockContact2);
            Contact[] contacts = addressBook.searchByName("Tim");
            // Assert
            assertEquals("Tim", contacts[0].getName());
        }

    }

    @Nested
    @DisplayName(("Address Book Delete Tests"))
    class AddressBookDeleteTests {
        @Test
        @DisplayName("DeleteContactShouldSuccessfullyDeleteContact")
        public void DeleteContactShouldSuccessfullyDeleteContact() {
            // Arrange
            AddressBook addressBook = new AddressBook();
            Contact mockContact = mock(Contact.class);
            Contact mockContact2 = mock(Contact.class);
            Mockito.when(mockContact.getPhoneNumber()).thenReturn("07393664832");
            Mockito.when(mockContact2.getPhoneNumber()).thenReturn("07493283642");
            Mockito.when(mockContact.getEmail()).thenReturn("johnny@job.com");
            Mockito.when(mockContact2.getEmail()).thenReturn("tim@barry.com");
            // Act
            addressBook.addContact(mockContact);
            addressBook.addContact(mockContact2);
            addressBook.deleteContact("07393664832");
            // Assert
            Contact[] contacts = addressBook.getContactList();
            assertEquals(1, contacts.length);
        }

    }

    @Nested
    @DisplayName(("Address Book Edit Tests"))
    class AddressBookEditTests {
        //TEST MAY NEED TO BE MODIFIED FOR LOOSER COUPLING
        @Test
        @DisplayName("Edit Contact Should Successfully Call Contact Setter when given valid input")
        public void EditContactShouldSuccessfullyCallContactSetter() {
            // Arrange
            AddressBook addressBook = new AddressBook();
            Contact mockContact = mock(Contact.class);
            String[] input = {"07393664832", "John Doe", "07563888342", "john@apple.com"};
            Mockito.when(mockContact.getPhoneNumber()).thenReturn(input[0]);
            // Act
            addressBook.addContact(mockContact);
            addressBook.editContact(input);
            // Assert
            assertAll(
                    () -> verify(mockContact, times(1)).setName("John Doe"),
                    () -> verify(mockContact, times(1)).setPhoneNumber(eq("07563888342")),
                    () -> verify(mockContact, times(1)).setEmail(eq("john@apple.com"))
            );
        }

    }

    @Nested
    @DisplayName(("Address Book View Tests"))
    class AddressBookViewTests {
        @Test
        @DisplayName("GetAllContacts Should Successfully Return All Contacts")
        public void GetAllContactsShouldSuccessfullyReturnAllContacts() {
            // Arrange
            //Arrange
            AddressBook addressBook = new AddressBook();
            Contact mockContact = mock(Contact.class);
            //Act
            addressBook.addContact(mockContact);
            Contact[] contacts = addressBook.getContactList();
            //Assert
            assertEquals(1,contacts.length);
        }

    }


}
