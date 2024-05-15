package com.addressbook.test;

import com.addressbook.app.AddressBook;
import com.addressbook.app.Contact;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
        @DisplayName("Edit Contact Should Successfully Call Contact Setter")
        public void EditContactShouldSuccessfullyCallContactSetter() {
            // Arrange
            AddressBook addressBook = new AddressBook();
            Contact mockContact = mock(Contact.class);
            Mockito.when(mockContact.getPhoneNumber()).thenReturn("07393664832");
            doNothing().when(mockContact).setPhoneNumber("073936664832");
            // Act
            addressBook.addContact(mockContact);
            addressBook.editContact("07393664832", "073936664832");
            // Assert
            verify(mockContact, times(1)).setPhoneNumber("073936664832");
        }

    }
}
