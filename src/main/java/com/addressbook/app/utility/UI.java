package com.addressbook.app.utility;


import com.addressbook.app.Contact;

import java.util.Scanner;

public class UI {
    private UI() {}

    public static void mainMenu() {
        System.out.println("\n Please type in the number of the option you would like to access! " +
                "\n 1.Add a Contact \n 2.Search for Contact by Name \n 3.Search for Contact by Phone Number \n 4.Search for Contact by Email \n 5.Delete Contact \n 6.Delete All Contact \n 7.Update Contact \n 8.Show All Contacts \n 9.Exit");
    }

    public static void printLine(String s) {
        System.out.println(s);
    }

    //Overload used where input is also needed
    public static String printLine(String s, Scanner sc) {
        System.out.println(s);
        return sc.nextLine();
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
        System.out.println("Please enter the new name for the contact or press enter to leave it unchanged.");
        String name = sc.nextLine();
        System.out.println("Please enter the new phone number for the contact or press enter to leave it unchanged.");
        String phone = sc.nextLine();
        System.out.println("Please enter the new email for the contact or press enter to leave it unchanged.");
        String email = sc.nextLine();
        return new String[]{oldNumber, name, phone, email};
    }

    public static void printContacts(Contact[] contacts) {
        for (Contact contact : contacts) {
            System.out.println("\nName: " + contact.getName() +
                    "\nPhone Number: " + contact.getPhoneNumber() +
                    "\nEmail: " + contact.getEmail());
        }
    }

    public static boolean deleteAllUI(Scanner sc) {
        System.out.println("Are you sure you want to delete all contacts? Type 'y' to continue or press enter to abort.");
        String confirm = sc.nextLine();
        return confirm.equals("y");
    }
}

