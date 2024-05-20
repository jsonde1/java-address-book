package com.addressbook.app;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        //initialises object to receive user input
        Scanner sc = new Scanner(System.in);
        AddressBook addressBook = new AddressBook(new Validator());
        String option;
        do {
            UI.mainMenu();
            //Prompts the user for input
            option = sc.nextLine();
            /* Will action AddressBook operation based on user input */
            switch (option) {
                case "1": //AddContact
                    try {
                    String[] contactDetails = UI.addContactUI(sc);
                    Contact contact = new Contact(contactDetails[0], contactDetails[1], contactDetails[2]);
                    addressBook.addContact(contact);
                }
                    catch (IllegalStateException e) {
                        UI.printLine(e.getMessage());
                    }
                    break;
                case "2": //SearchByName
                    String name = UI.printLine("Please enter the name of the contact you are looking for: ", sc);
                    UI.printContacts(addressBook.searchByName(name));
                    break;
                case "3": //SearchByPhone
                    String phone = UI.printLine("Please enter the Phone Number of the contact you are looking for: ", sc);
                    UI.printContacts(addressBook.searchByPhone(phone));
                    break;
                case "4": //SearchByEmail
                    String email = UI.printLine("Please enter the Email of the contact you are looking for: ", sc);
                    UI.printContacts(addressBook.searchByEmail(email));
                    break;
                case "5": //DeleteContact
                    String number = UI.printLine("Please enter the number of the contact you would like to delete: ", sc);
                    addressBook.deleteContact(number);
                    break;
                case "6": //DeleteAllContact
                    boolean b = UI.deleteAllUI(sc);
                    addressBook.deleteAllContact(b);
                    break;
                case "7": //EditContact
                    try {
                        String[] details = UI.editContactUI(sc);
                        addressBook.editContact(details);
                    }
                    catch (IllegalStateException e) {
                        UI.printLine(e.getMessage());
                    }
                    break;
                case "8": //PrintAllContacts
                    UI.printContacts(addressBook.getContactList());
                    break;
                case "9": //Exit
                    UI.printLine("This Address Book will now be closed.");
                    break;
                default: //Illegal
                    UI.printLine("Please Enter a Valid Option");
            }
        }
        // Will loop continuously until exited by the user
        while (!option.equals("9"));
    }
}
