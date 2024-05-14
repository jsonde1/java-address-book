package com.addressbook.app;

import java.util.ArrayList;

public class AddressBook {
    protected ArrayList<Contact> contactList = new ArrayList<Contact>();

    public void addContact(Contact contact) {
        this.contactList.add(contact);
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }
}
