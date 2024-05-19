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

    //Overload used where input is also needed
    public static String printLine(String s, Scanner sc) {
        System.out.println(s);
        return sc.nextLine();
    }

    private void VerifyOption(Scanner sc, AddressBook addressBook ) {
        // code block
    }

    //returns array of user input to be passed into new Contact
    public static String[] addContactUI(Scanner sc) {
        System.out.println("Please enter the name of the contact you would like to add");
        String name = sc.nextLine();
        System.out.println("Please enter the phone number of the contact you would like to add");
        String phone = sc.nextLine();
        System.out.println("Please enter the email of the contact you would like to add");
        String email = sc.nextLine();
        return new String[] {name, phone, email};
    }
    public static String[] editContactUI(Scanner sc) {
        System.out.println("Please enter the saved number of the contact you would like to edit");
        String oldNumber = sc.nextLine();
        System.out.println("Please enter the new name for the contact\ror press enter to leave it unchanged.");
        String name = sc.nextLine();
        System.out.println("Please enter the new phone number for the contact\ror press enter to leave it unchanged.");
        String phone = sc.nextLine();
        System.out.println("Please enter the new email for the contact\ror press enter to leave it unchanged.");
        String email = sc.nextLine();
        return new String[] {name, phone, email};
    }
    public static String deleteContactUI(Scanner sc) {
        System.out.println("Please enter the number of the contact you would like to delete");
        return sc.nextLine();
    }

    public static void printContacts(Contact[] contacts) {
        for (Contact contact : contacts) {
            System.out.println("Name: " + contact.getName() +
                    "\nPhone Number: " + contact.getPhoneNumber() +
                    "\nEmail: " + contact.getEmail());
        }
    }

}

