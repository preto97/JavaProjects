package com.company;

import java.util.ArrayList;

// I created the MobilePhone class with fields myNumber and myContacts list
public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    // This is MobilePhone constructor
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    // This function add a new Contact if in not allready introduced in myContacts list
    public boolean addNewContact(Contact contact){
        if (findContact(contact.getName()) >=0 ){
            System.out.println("Contact is already on file");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    // This function is updating an exisinting contact
    public boolean updateContact(Contact oldContact, Contact newContact ){
        // Checking if contact exists allready in myContacts, by name
        int foundPosition = findContact(oldContact);
        if (foundPosition < 0) {
            System.out.println(oldContact.getName() +", was not found. ");
            return false;
        // If not exists, we are checking if the new contact we want to insert is not allready in our myContacts list
        } else if (findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name " + newContact.getName() + " already exists.");
            return false;
        }

        // If all above condition has passed, make the changes and display a specific message
        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldContact.getName() + ", was replaced with " + newContact.getName());
        return true;
    }


    // This function is removing an exisinting contact
    public boolean removeContact (Contact contact){
        // Checking if contact exists in myContacts, by name
        int foundPosition = findContact(contact);
        if (foundPosition < 0) {
            // If not exists, display the next message and stop the next code executions, by returning false
            System.out.println(contact.getName() +", was not found. ");
            return false;
        }
        // If exists, remove the contact and print a specific message
        // Also return true
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + ", has deleted.");
        return true;
    }

    // This function return the position/index of contact that we asked for by contact
    private int findContact(Contact contact){
        return this.myContacts.indexOf(contact);
    }

    // This function return the position/index of contact that we asked for by contact name
    private int findContact(String contactName){
        for (int i = 0; i < this.myContacts.size(); i++){
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    // This function query for an existing contact, by name and returns the position if exists
    public Contact queryContact(String name){
        int position = findContact(name);
        if (position >=0){
            return this.myContacts.get(position);
        }
        // Else, it returns null
        return null;
    }

    // This function goes through myContacts list and prints each contact, line by line
    public void printContacts(){
        System.out.println("Contact list:");
        for (int i = 0; i < this.myContacts.size(); i++){
            System.out.println((i+1) + "."+
                        this.myContacts.get(i).getName() + " -> " +
                        this.myContacts.get(i).getPhoneNumber());
        }
    }
}
