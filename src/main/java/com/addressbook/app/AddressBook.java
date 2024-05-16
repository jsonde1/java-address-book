package com.addressbook.app;

import java.util.ArrayList;

public class AddressBook {
    protected ArrayList<Contact> contactList = new ArrayList<Contact>();

    private boolean duplicatePhoneNumber(Contact contact) {
        for (Contact c : contactList) {
            if (c.getPhoneNumber().equals(contact.getPhoneNumber())) {
                return true;
            }
        }
        return false;
    }

    public void addContact(Contact contact) {
        if (duplicatePhoneNumber(contact)) return;
        this.contactList.add(contact);
    }
    //Contact list is returned as Array as it is immutable
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

    public void deleteContact(String number) {
        for (Contact contact : this.contactList) {
            if(contact.getPhoneNumber().equals(number)) {
                contactList.remove(contact);
                break;
            }
        }
    }

    public void editContact(String oldNumber, String newNumber) {
        for (Contact contact : this.contactList) {
            if(contact.getPhoneNumber().equals(oldNumber)) {
                contact.setPhoneNumber(newNumber);
                break;
            }
        }
    }
}
