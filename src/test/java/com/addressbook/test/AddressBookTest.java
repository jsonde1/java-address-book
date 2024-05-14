package com.addressbook.test;

import com.addressbook.app.AddressBook;
import com.addressbook.app.Contact;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class AddressBookTest {

    @Nested
    @DisplayName("AddressBookAddTests")
    class AddressBookAddTests {

        @Test
        public void ValidContactObjSuccessfullyAddedToAddressBook() {
            //Arrange
            AddressBook addressBook = new AddressBook();
            //Act
            Contact mockContact = mock(Contact.class);
            addressBook.addContact(mockContact);
            ArrayList<Contact> contacts = addressBook.getContactList();
            //Assert
            assertEquals(1,contacts.size());
        }
    }
}
