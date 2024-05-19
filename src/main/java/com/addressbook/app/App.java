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
                    //AddContact
                    String[] contactDetails = UI.addContactUI(sc);
                    Contact contact = new Contact(contactDetails[0], contactDetails[1], contactDetails[2]);
                    addressBook.addContact(contact);
                    break;
                case "2":
                    //SearchByName
                    String name = UI.printLine("Please enter the name of the contact you are looking for: ", sc);
                    UI.printContacts(addressBook.searchByName(name));
                    break;
                case "3":
                    //DeleteContact
                    String number = UI.printLine("Please enter the number of the contact you would like to delete: ", sc);
                    addressBook.deleteContact(number);
                    break;
                case "4":
                    //EditContact
                    String[] details = UI.editContactUI(sc);
                    addressBook.editContact(details);
                    break;
                case "5":
                    //PrintAllContacts
                    UI.printContacts(addressBook.getContactList());
                    break;
                case "6":
                    //Exit
                    UI.printLine("This Address Book will now be closed.");
                    break;
                default:
                    //Invalid
                    UI.printLine("Please Enter a Valid Option");
            }
        }
        // Will loop continuously until exited by the user
        while (!option.equals("6"));
    }
}
