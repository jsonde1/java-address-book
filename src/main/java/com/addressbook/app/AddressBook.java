package com.addressbook.app;

import java.util.ArrayList;
import java.util.Arrays;

public class AddressBook {
    private final ArrayList<Contact> contactList = new ArrayList<>();
    private final Validator validator;

    public AddressBook(Validator validator) {
        this.validator = validator;
    }

    //Checks that new contact obj contact details do not already exist in contact list
    private boolean duplicateContactDetails(Contact contact) {
        for (Contact c : contactList) {
            if (c.getPhoneNumber().equals(contact.getPhoneNumber())) return true;
            if (c.getEmail().equals(contact.getEmail())) return true;
        }
        return false;
    }

    public void addContact(Contact contact) {
        if (duplicateContactDetails(contact)) UI.printLine("Contact Already Exists\n");
        else {
            validatorChecks(contact.getName(), contact.getPhoneNumber(), contact.getEmail());
            this.contactList.add(contact);
            UI.printLine("Contact Added\n");
        }
    }

    //Contact list is returned as Array so it is immutable
    public Contact[] getContactList() {
        if (contactList.isEmpty()) UI.printLine("No Contacts in AddressBook\n");
        return this.contactList.toArray(new Contact[0]);
    }
    /* will return array of contacts that contain the string
    eg 'jo' will return Josh, Josephine, Banjo etc */
    public Contact[] searchByName(String name) {
        ArrayList<Contact> matchingContacts = new ArrayList<>();
        for (Contact contact : this.contactList) {
            //toLowerCase so it is case-insensitive
            if(contact.getName().toLowerCase().contains(name.toLowerCase())) matchingContacts.add(contact);
        }
        if (matchingContacts.isEmpty()) UI.printLine("No Matching Contacts Found\n");
        return matchingContacts.toArray(matchingContacts.toArray(new Contact[0]));
    }

    //Look for matching number within contact list and deletes the associated Obj
    public void deleteContact(String number) {
        contactList.remove(getContactByNumber(number));
    }

    // empty check is false so no contact attributes are empty for addContact
    private void validatorChecks(String name,
                                 String phoneNumber,
                                 String email) {
        boolean emptyCheck = false;
        validatorChecks(name, phoneNumber, email, emptyCheck);
    }

    /* option to pass in true for edit contact to allow only
    one parameter to be edited as per user request */
    private void validatorChecks(String name,
                                 String phoneNumber,
                                 String email, boolean emptyCheck) {
        boolean[] isEmpty = new boolean[3];
        if(!emptyCheck) Arrays.fill(isEmpty, false);
        else isEmpty = validator.checksEmpty(name, phoneNumber, email);
        if(!isEmpty[0]) validator.validName(name);
        if(!isEmpty[1]) validator.validPhoneNumber(phoneNumber);
        if(!isEmpty[2]) validator.validEmail(email);
    }


    private void setDetails(Contact contact, String name, String phoneNumber, String email) {
        validatorChecks(name, phoneNumber, email,true);
        if(!name.isEmpty()) contact.setName(name);
        if(!phoneNumber.isEmpty()) contact.setPhoneNumber(phoneNumber);
        if(!email.isEmpty()) contact.setEmail(email);
    }
    /* will search for exact Phone Number match
    Phone Number is unique so will only ever have one match */
    private Contact getContactByNumber(String number) {
        for (Contact contact : this.contactList) {
            if(contact.getPhoneNumber().equals(number)) {
                return contact;
            }
        }
        UI.printLine("Contact not found\n");
        return null;
    }

    //Checks that contact is in address book before invoking setDetails on said contact
    public void editContact(String [] details) {
        Contact contact = getContactByNumber(details[0]);
        if(contact != null) setDetails(contact, details[1], details[2], details[3]);
    }
}
