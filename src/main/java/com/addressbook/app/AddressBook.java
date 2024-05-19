package com.addressbook.app;

import java.util.ArrayList;

public class AddressBook {
    private final ArrayList<Contact> contactList = new ArrayList<>();

    //Checks that new contact obj contact details do not already exist in contact list
    private boolean duplicateContactDetails(Contact contact) {
        for (Contact c : contactList) {
            if (c.getPhoneNumber().equals(contact.getPhoneNumber())) return true;
            if (c.getEmail().equals(contact.getEmail())) return true;
        }
        return false;
    }

    public void addContact(Contact contact) {
        if (duplicateContactDetails(contact)) return;
        this.contactList.add(contact);
    }

    //Contact list is returned as Array so it is immutable
    public Contact[] getContactList() {
        return this.contactList.toArray(new Contact[0]);
    }

    public Contact[] searchByName(String name) {
        ArrayList<Contact> matchingContacts = new ArrayList<Contact>();
        for (Contact contact : this.contactList) {
            if(contact.getName().contains(name)) matchingContacts.add(contact);
        }
        //maybe put toArray into own function?
        return matchingContacts.toArray(matchingContacts.toArray(new Contact[0]));
    }

    //Look for matching number within contact list and deletes the associated Obj
    public void deleteContact(String number) {
        contactList.remove(getContactByNumber(number));
    }

    private void setDetails(Contact contact, String name, String phoneNumber, String email) {
            contact.setName(name);
            contact.setPhoneNumber(phoneNumber);
            contact.setEmail(email);
    }

    private Contact getContactByNumber(String number) {
        for (Contact contact : this.contactList) {
            if(contact.getPhoneNumber().equals(number)) {
                return contact;
            }
        }
        return null;
    }

    //Edit email and name functionality to be added
    public void editContact(String [] details) {
        Contact contact = getContactByNumber(details[0]);
        if (contact == null) UI.printLine("Contact could not be found"); //Check needs to be done by Validator
        else setDetails(contact, details[1], details[2], details[3]); //UI.PrintLine("No details have been given.");
    }
}
