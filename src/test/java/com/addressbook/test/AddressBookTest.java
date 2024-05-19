package com.addressbook.test;

import com.addressbook.app.AddressBook;
import com.addressbook.app.Contact;
import com.addressbook.app.Validator;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AddressBookTest {
    Validator mockValidator = mock(Validator.class);

    void setMockValidatorTrue() {
        Mockito.when(mockValidator.validName(any())).thenReturn(true);
        Mockito.when(mockValidator.validPhoneNumber(any())).thenReturn(true);
        Mockito.when(mockValidator.validEmail(any())).thenReturn(true);
        Mockito.when(mockValidator.checksEmpty(any(),any(),any())).thenReturn(new boolean[]{true, true, true});
    }

    void setMockValidatorException() {
        Mockito.when(mockValidator.validName(any())).thenThrow(new IllegalStateException());
        Mockito.when(mockValidator.validPhoneNumber(any())).thenThrow(new IllegalStateException());
        Mockito.when(mockValidator.validEmail(any())).thenThrow(new IllegalStateException());
        Mockito.when(mockValidator.checksEmpty(any(),any(),any())).thenThrow(new IllegalStateException());;
    }

    void getMockDetails(Contact mockContact, String name, String phone, String email) {
        Mockito.when(mockContact.getName()).thenReturn(name);
        Mockito.when(mockContact.getPhoneNumber()).thenReturn(phone);
        Mockito.when(mockContact.getEmail()).thenReturn(email);
    }

    @BeforeEach void setUp() {
        setMockValidatorTrue();
    }

    @Nested
    @DisplayName("Address Book Add Tests")
    class AddressBookAddTests {

        @Test
        @DisplayName("Valid Contact Obj Successfully Added To AddressBook")
        public void ValidContactObjSuccessfullyAddedToAddressBook() {
            //Arrange
            AddressBook addressBook = new AddressBook(mockValidator);
            Contact mockContact = mock(Contact.class);
            //Act
            addressBook.addContact(mockContact);
            Contact[] contacts = addressBook.getContactList();
            //Assert
            assertEquals(mockContact,contacts[0]);
        }

        @Test
        @DisplayName(" Valid Contact Obj with existing number is Not Added To AddressBook")
        public void DuplicateNumberValidContactObjIsNotAddedToAddressBook() {
            //Arrange
            AddressBook addressBook = new AddressBook(mockValidator);
            Contact mockContact = mock(Contact.class);
            Contact mockContact2 = mock(Contact.class);
            Mockito.when(mockContact.getPhoneNumber()).thenReturn("07462352643");
            Mockito.when(mockContact2.getPhoneNumber()).thenReturn("07462352643");
            setMockValidatorTrue();
            //Act
            addressBook.addContact(mockContact);
            addressBook.addContact(mockContact2);
            Contact[] contacts = addressBook.getContactList();
            //Assert
            assertEquals(1,contacts.length);
        }

        @Test
        @DisplayName(" Contact Obj with existing email is Not Added To AddressBook")
        public void DuplicateEmailValidContactObjIsNotAddedToAddressBook() {
            //Arrange
            AddressBook addressBook = new AddressBook(mockValidator);
            Contact mockContact = mock(Contact.class);
            Contact mockContact2 = mock(Contact.class);
            getMockDetails(mockContact, null,"07462352643","John@Smith.com");
            getMockDetails(mockContact2, null,"07946352632","John@Smith.com");
            setMockValidatorTrue();
            //Act
            addressBook.addContact(mockContact);
            addressBook.addContact(mockContact2);
            Contact[] contacts = addressBook.getContactList();
            //Assert
            assertEquals(1,contacts.length);
        }

        @Test
        @DisplayName("Contact Obj should not be added when validator throws exception")
        public void ContactObjShouldNotBeAddedWhenValidatorThrowsException() {
            //Arrange
            AddressBook addressBook = new AddressBook(mockValidator);
            Contact mockContact = mock(Contact.class);
            Contact mockContact2 = mock(Contact.class);
            getMockDetails(mockContact, null,"07462352643","John@Smith.com");
            setMockValidatorException();

            try {
                //Act
                addressBook.addContact(mockContact);
            }
            catch (Exception ignored) {
            }
            finally {
                //Assert
                Contact[] contacts = addressBook.getContactList();
                assertEquals(0,contacts.length);
            }

        }

    }

    @Nested
    @DisplayName(("Address Book Search Tests"))
    class AddressBookSearchTests {
        @Test
        @DisplayName("Search By Name Should Successfully Return Matching Contacts")
        public void SearchByNameShouldSuccessfullyReturnMatchingContacts() {
            // Arrange
            Validator validator = mockValidator;
            AddressBook addressBook = new AddressBook(validator);
            Contact mockContact = mock(Contact.class);
            Contact mockContact2 = mock(Contact.class);
            getMockDetails(mockContact, "Johnny Darius","07837283422","johnny@job.com");
            getMockDetails(mockContact2, "Tim Cook","07836241521","tim@barry.com");
            // Act
            addressBook.addContact(mockContact);
            addressBook.addContact(mockContact2);
            Contact[] contacts = addressBook.searchByName("Tim");
            // Assert
            assertEquals("Tim Cook", contacts[0].getName());
        }

        @Test
        @DisplayName("Search By Name Should Successfully Return Matching Contacts with extreme parameters")
        public void SearchByNameShouldSuccessfullyReturnMatchingContactsWithExtremeParameters() {
            // Arrange
            Validator validator = mockValidator;
            AddressBook addressBook = new AddressBook(validator);
            Contact mockContact = mock(Contact.class);
            Contact mockContact2 = mock(Contact.class);
            getMockDetails(mockContact, "Johnny Darius","07837283422","johnny@job.com");
            getMockDetails(mockContact2, "Rhoshandiatellyneshiaunneveshenkfdijldsfji Rhoshandiatellyneshiaunneveshenksdffjdsaklfds","07836241521","tim@barry.com");
            // Act
            addressBook.addContact(mockContact);
            addressBook.addContact(mockContact2);
            Contact[] contacts = addressBook.searchByName("Rhos");
            // Assert
            assertEquals("Rhoshandiatellyneshiaunneveshenkfdijldsfji Rhoshandiatellyneshiaunneveshenksdffjdsaklfds", contacts[0].getName());
        }

        @Test
        @DisplayName("Search By Name Should Return empty if no Matching Contacts")
        public void SearchByNameShouldReturnEmptyIfNoContactsFound() {
            // Arrange
            Validator validator = mockValidator;
            AddressBook addressBook = new AddressBook(validator);
            Contact mockContact = mock(Contact.class);
            Contact mockContact2 = mock(Contact.class);
            getMockDetails(mockContact, "Johnny Darius","07837283422","johnny@job.com");
            getMockDetails(mockContact2, "Tim Cook","07836241521","tim@barry.com");
            // Act
            addressBook.addContact(mockContact);
            addressBook.addContact(mockContact2);
            Contact[] contacts = addressBook.searchByName("Rio");
            // Assert
            assertTrue(contacts.length == 0);
        }

    }

    @Nested
    @DisplayName(("Address Book Delete Tests"))
    class AddressBookDeleteTests {
        @Test
        @DisplayName("Delete Contact Should Successfully Delete Contact when given existing Number")
        public void DeleteContactShouldSuccessfullyDeleteContactWhenGivenExistingNumber() {
            // Arrange
            AddressBook addressBook = new AddressBook(mockValidator);
            Contact mockContact = mock(Contact.class);
            Contact mockContact2 = mock(Contact.class);
            getMockDetails(mockContact,null,"07837283422","johnny@job.com");
            getMockDetails(mockContact2,null,"07493283642","tim@barry.com");
            // Act
            addressBook.addContact(mockContact);
            addressBook.addContact(mockContact2);
            addressBook.deleteContact("07493283642");
            // Assert
            Contact[] contacts = addressBook.getContactList();
            assertEquals(1, contacts.length);
        }

        @Test
        @DisplayName("Delete Contact Should not Delete Contact when given number not in contact list")
        public void DeleteContactShouldNotDeleteContactWhenGivenNumberNotInContactList() {
            // Arrange
            AddressBook addressBook = new AddressBook(mockValidator);
            Contact mockContact = mock(Contact.class);
            getMockDetails(mockContact,null,"07837283422","johnny@job.com");
            // Act
            addressBook.addContact(mockContact);
            addressBook.deleteContact("078375446765");
            // Assert
            Contact[] contacts = addressBook.getContactList();
            assertEquals(1, contacts.length);
        }

        @Test
        @DisplayName("Delete All Contact Should Successfully Delete Contacts when confirmed by user")
        public void DeleteALlContactShouldSuccessfullyDeleteContacts() {
            // Arrange
            AddressBook addressBook = new AddressBook(mockValidator);
            Contact mockContact = mock(Contact.class);
            Contact mockContact2 = mock(Contact.class);
            getMockDetails(mockContact,null,"07837283422","johnny@job.com");
            // Act
            addressBook.addContact(mockContact);
            addressBook.deleteAllContact(true);
            // Assert
            Contact[] contacts = addressBook.getContactList();
            assertEquals(0, contacts.length);
        }

        @Test
        @DisplayName("Delete All Contact Should Successfully Run when no contacts are in address Book")
        public void DeleteALlContactShouldSuccessfullyRunWhenNoContacts() {
            // Arrange
            AddressBook addressBook = new AddressBook(mockValidator);
            // Act
            addressBook.deleteAllContact(true);
            // Assert
            Contact[] contacts = addressBook.getContactList();
            assertEquals(0, contacts.length);
        }

        @Test
        @DisplayName("Delete All Contact Should Not Delete Contacts when not confirmed by user")
        public void DeleteALlContactShouldNotDeleteContacts() {
            // Arrange
            AddressBook addressBook = new AddressBook(mockValidator);
            Contact mockContact = mock(Contact.class);
            getMockDetails(mockContact,null,"07837283422","johnny@job.com");
            // Act
            addressBook.addContact(mockContact);
            addressBook.deleteAllContact(false);
            // Assert
            Contact[] contacts = addressBook.getContactList();
            assertEquals(1, contacts.length);
        }

    }

    @Nested
    @DisplayName(("Address Book Edit Tests"))
    class AddressBookEditTests {
        @Test
        @DisplayName("Edit Contact Should Successfully Call Contact Setter when given valid input")
        public void EditContactShouldSuccessfullyCallContactSetter() {
            // Arrange
            AddressBook addressBook = new AddressBook(mockValidator);
            Contact mockContact = mock(Contact.class);
            String[] input = {"07393664832", "John Doe", "07563888342", "john@apple.com"};
            getMockDetails(mockContact,null,input[0],null);
            // Act
            addressBook.addContact(mockContact);
            addressBook.editContact(input);
            // Assert
            assertAll(
                    () -> verify(mockContact, times(1)).setName(any()),
                    () -> verify(mockContact, times(1)).setPhoneNumber(any()),
                    () -> verify(mockContact, times(1)).setEmail(any())
            );
        }

        @Test
        @DisplayName("Edit Contact Should Successfully Call Contact Setter when given extreme valid input")
        public void EditContactShouldSuccessfullyCallContactSetterWithExtremeValidInput() {
            // Arrange
            AddressBook addressBook = new AddressBook(mockValidator);
            Contact mockContact = mock(Contact.class);
            String[] input = {"07393664832",
                    "RhoshandiatellyneshiaunneveshenkfdijldsfjiRhoshandiatellyneshiaunneveshenkfdijldsfji Rhoshandiatellyneshiaunneveshenkfdijldsfji",
                    "07563888342", "john@apple.com"};
            getMockDetails(mockContact,null,input[0],null);
            // Act
            addressBook.addContact(mockContact);
            addressBook.editContact(input);
            // Assert
            assertAll(
                    () -> verify(mockContact, times(1)).setName(any()),
                    () -> verify(mockContact, times(1)).setPhoneNumber(any()),
                    () -> verify(mockContact, times(1)).setEmail(any())
            );
        }

        @Test
        @DisplayName("Edit Contact Should Successfully Call Contact Setter when only one input is given")
        public void EditContactShouldSuccessfullyCallContactSetterWhenOnlyOneInputIsGiven() {
            // Arrange
            AddressBook addressBook = new AddressBook(mockValidator);
            Contact mockContact = mock(Contact.class);
            String[] input = {"07393664832", "", "", "john@apple.com"};
            getMockDetails(mockContact,null,input[0],null);
            // Act
            addressBook.addContact(mockContact);
            addressBook.editContact(input);
            // Assert
            assertAll(
                    () -> verify(mockContact, times(0)).setName(any()),
                    () -> verify(mockContact, times(0)).setPhoneNumber(any()),
                    () -> verify(mockContact, times(1)).setEmail(any())
            );
        }

        @Test
        @DisplayName("Edit Contact Should Successfully Call Contact Setter when only two inputs are given")
        public void EditContactShouldSuccessfullyCallContactSetterWhenOnlyTwoInputsAreGiven() {
            // Arrange
            AddressBook addressBook = new AddressBook(mockValidator);
            Contact mockContact = mock(Contact.class);
            String[] input = {"07393664832", "Jamie Dang", "", "john@apple.com"};
            Mockito.when(mockContact.getPhoneNumber()).thenReturn(input[0]);
            getMockDetails(mockContact,null,input[0],null);
            // Act
            addressBook.addContact(mockContact);
            addressBook.editContact(input);
            // Assert
            assertAll(
                    () -> verify(mockContact, times(1)).setName(any()),
                    () -> verify(mockContact, times(0)).setPhoneNumber(any()),
                    () -> verify(mockContact, times(1)).setEmail(any())
            );
        }

        @Test
        @DisplayName("Edit Contact Should do nothing when validator returns false")
        public void EditContactShouldDoNothingWhenValidatorReturnsFalse() {
            // Arrange
            AddressBook addressBook = new AddressBook(mockValidator);
            Contact mockContact = mock(Contact.class);
            String[] input = {"07393664832", "Jamie Dang", "", "john@apple.com"};
            setMockValidatorException();
            getMockDetails(mockContact,null,input[0],null);
            try {
                // Act
                addressBook.addContact(mockContact);
                addressBook.editContact(input);
            }
            catch (Exception ignored) {
            }
            finally {
                //Assert
                assertAll(
                        () -> verify(mockContact, times(0)).setName(any()),
                        () -> verify(mockContact, times(0)).setPhoneNumber(any()),
                        () -> verify(mockContact, times(0)).setEmail(any())
                );
            }

        }

    }

    @Nested
    @DisplayName(("Address Book View Tests"))
    class AddressBookViewTests {
        @Test
        @DisplayName("GetAllContacts Should Successfully Return All Contacts")
        public void GetAllContactsShouldSuccessfullyReturnAllContacts() {
            //Arrange
            Contact mockContact = mock(Contact.class);
            AddressBook addressBook = new AddressBook(mockValidator);
            //Act
            addressBook.addContact(mockContact);
            Contact[] contacts = addressBook.getContactList();
            //Assert
            assertEquals(1,contacts.length);
        }

        @Test
        @DisplayName("GetAllContacts Should return empty if contact list is empty")
        public void GetAllContactsShouldReturnEmptyIfContactListIsEmpty() {
            //Arrange
            AddressBook addressBook = new AddressBook(mockValidator);
            //Act
            Contact[] contacts = addressBook.getContactList();
            //Assert
            assertEquals(0,contacts.length);
        }

    }


}
