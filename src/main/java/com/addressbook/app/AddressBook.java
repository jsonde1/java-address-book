package com.addressbook.app;

import java.util.ArrayList;

public class AddressBook {
    protected ArrayList<Contact> contactList = new ArrayList<Contact>();

    public void addContact(Contact contact) {
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
}
