package com.addressbook.app;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //initialises object to receive user input
        Scanner sc = new Scanner(System.in);
        AddressBook addressBook = new AddressBook();
        String option;
        do {
            UI.mainMenu();
            //Prompts the user for input
            option = sc.nextLine();
            /* Will action AddressBook operation based on user input */
            switch (option) {
                case "1":
                    String[] contactDetails = UI.addContactUI(sc);
                    Contact contact = new Contact(contactDetails[0], contactDetails[1], contactDetails[2]);
                    addressBook.addContact(contact);
                    break;
                case "2":
                    //UI.searchbyName(scanner) to be done
                    String name = sc.nextLine();
                    UI.printContacts(addressBook.searchByName(name));
                    break;
                case "3":
                    String number = UI.deleteContactUI(sc);
                    addressBook.deleteContact(number);
                    break;
                case "4":
                    String[] details = UI.editContactUI(sc);
                    addressBook.editContact(details);
                    break;
                case "5":
                    UI.printContacts(addressBook.getContactList());
                    break;
                case "6":
                    UI.printLine("This Address Book will now be closed.");
                    break;
                default:
                    UI.printLine("Please Enter a Valid Option");
                    //VerifyOption(option, addressBook);
            }
        }
        // Will loop continuously until exited by the user
        while (!option.equals("6"));
    }
}
