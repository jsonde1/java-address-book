package com.addressbook.app;

//private Scanner scan;

import java.util.Scanner;

public class UI {

    private UI() {}

    public static void mainMenu() {
        System.out.println("Welcome to your AddressBook! \n Please type in the number of the option you would like to access! " +
                "\n 1.Add a Contact \n 2.Search for Contact \n 3.Delete Contact \n 4.Update Contact \n 5.Show All Contacts \n 6.Exit");
    }

    public static void printLine(String s) {
        System.out.println(s);
    }

    private void VerifyOption(Scanner sc, AddressBook addressBook ) {
        // code block
    }

    //returns array of user input to be passed into new Contact
    public static String[] addContactUI(Scanner sc) {
        System.out.println("Please enter the name of the contact you would like to add");
        String name = sc.next();
        System.out.println("Please enter the phone number of the contact you would like to add");
        String phone = sc.next();
        System.out.println("Please enter the email of the contact you would like to add");
        String email = sc.next();
        return new String[] {name, phone, email};
    }

    public static String deleteContactUI(Scanner sc) {
        System.out.println("Please enter the number of the contact you would like to delete");
        return sc.next();
    }

    public static void printContacts(Contact[] contacts) {
        for (Contact contact : contacts) {
            System.out.println("Name: " + contact.getName() +
                    "\nPhone Number: " + contact.getPhoneNumber() +
                    "\nEmail: " + contact.getEmail());
        }
    }

}

