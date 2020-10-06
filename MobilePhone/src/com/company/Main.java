package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // scanner is used to introduce datas from System.in (in our case, keyboard)
    private static Scanner scanner = new Scanner(System.in);
    // I created a mobilePhone object
    private static MobilePhone mobilePhone = new MobilePhone("0741 125 582");

    public static void main(String[] args) {
        // The condition to quit application
        boolean quit = false;
        // This function display a specific message when app starts
        startPhone();
        // This function print the menu of actions you can execute
        printActions();
        int choice = 0;
        // Starting te base menu app
        while (!quit) {
            System.out.println("\nEnter choice: (6 to show available actions)");
            // Scans the data typed from keyboard and store it in var choice
            choice = scanner.nextInt();
            scanner.nextLine();

            // According to data store in var choice you can execute the next actions:
            switch (choice) {
                // To shut down application
                case 0:
                    shutDownPhone();
                    quit = true;
                    break;

                // To print all existing contacts from myContacts
                case 1:
                    mobilePhone.printContacts();
                    break;

                // To add a new contact to myContacts
                case 2:
                    addNewContact();
                    break;

                // To update an existing contact from myContacts
                case 3:
                    updateContact();
                    break;

                // To remove an existing contact from myContacts
                case 4:
                    removeContact();
                    break;

                // To query if an existing contact exists in myContacts
                case 5:
                    queryContact();
                    break;

                // To print the list of available actions you can execute
                case 6:
                    printActions();
                    break;
            }

        }
    }

    // This function display the next message when our app starts
    private static void startPhone() {
        System.out.println("Starting Contacts phone application...");
    }

    // This function display the next message when our app ends (when you press 0)
    private static void shutDownPhone() {
        System.out.println("The Contact phone application is shutting down...");

    }

    // This function allow us to add a new Contact if the name of the contact
    // is not allready inserted in myContacts list
    private static void addNewContact() {
        System.out.println("Type the name of the contact: ");
        String name = scanner.nextLine();
        System.out.println("now, type the phone number: ");
        String phone = scanner.nextLine();
        // Store the name and phone number we introduced above in newContact by call
        // createContact(String name, String phoneNumber) method from Contact class
        Contact newContact = Contact.createContact(name, phone);
        // Checking if the name allready exists in myContacts list by calling
        // addNewContact(Contact contact) method from MobilePhone class
        if (mobilePhone.addNewContact(newContact)) {
            // If the function mention above returns true, we add the new contact and
            // print this message:
            System.out.println("New contact added: name = " + name + ", phone = " + phone);
        } else {
            // Else the contact is not added to our list and display this message:
            System.out.println("Cannot add, " + name + " already on file.");
        }

    }

    // This function allow us to update an existing contact from myContacts
    private static void updateContact() {
        // Checking if the contact name exists in myContacts list
        System.out.println("Enter existing contact name:");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found");
            return;
        }
        // If not exists, add it to myContacts list
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter new contact phone number");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if (mobilePhone.updateContact(existingContactRecord, newContact)) {
            System.out.println("Succes updated record.");
        } else {
            System.out.println("Error updating record.");
        }
    }

    // This function allow us to remove an exisiting contact from myContacts
    private static void removeContact() {
        // Checking if the contact name exists in myContacts list
        System.out.println("Enter existing contact name:");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            // If not exists, print the next message:
            System.out.println("Contact not found");
            return;
        }
        // If exists, remove it and print the following message if:
        if (mobilePhone.removeContact(existingContactRecord)) {
            // - remove action succeded
            System.out.println("Successfully deleted.");
        } else {
            // - remove action failed
            System.out.println("Error deleting contact.");
        }
    }

    // This function is used to find a contact from myContacts by name
    private static void queryContact() {
        System.out.println("Ennter existing contact name:");
        String name = scanner.nextLine();
        Contact existingContactRecord = mobilePhone.queryContact(name);
        if (existingContactRecord == null) {
            // If contact was not found print this message and stop the next code executions
            System.out.println("Contact not found");
            return;
        }
        // If contact found, print this message
        System.out.println("Name: " + existingContactRecord.getName() + " phone number is " + existingContactRecord.getPhoneNumber());
    }

    // This function display all actions you can execute by typing a specific number
    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to exit\n" +
                "1 - to print existing contacts\n" +
                "2 - to add a new contact\n" +
                "3 - to update an existing contact\n" +
                "4 - to remove an existing contact\n" +
                "5 - query if an existing contact exists\n" +
                "6 - to print the list of available actions.");

    }


}
