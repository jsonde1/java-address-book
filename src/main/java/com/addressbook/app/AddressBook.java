package com.addressbook.app;

import java.util.ArrayList;

public class AddressBook {
    protected ArrayList<Contact> contactList = new ArrayList<Contact>();

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
        return this.contactList.toArray(new Contact[this.contactList.size()]);
    }

    public Contact[] searchByName(String name) {
        ArrayList<Contact> contactList = new ArrayList<Contact>();
        for (Contact contact : this.contactList) {
            if(contact.getName().contains(name)) contactList.add(contact);
        }
        return contactList.toArray(contactList.toArray(new Contact[contactList.size()]));
    }

    //Look for matching number within contact list and deletes the associated Obj
    public void deleteContact(String number) {
        for (Contact contact : this.contactList) {
            if(contact.getPhoneNumber().equals(number)) {
                contactList.remove(contact);
                break;
            }
        }
    }

    //Edit email and name functionality to be added
    public void editContact(String oldNumber, String newNumber) {
        for (Contact contact : this.contactList) {
            if(contact.getPhoneNumber().equals(oldNumber)) {
                contact.setPhoneNumber(newNumber);
                break;
            }
        }
    }
}
