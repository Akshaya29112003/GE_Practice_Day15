package Address_Book_System;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Add_Contact_UC2 {
    public ArrayList<Create_Contact_UC1> contact_list;

    public Add_Contact_UC2() {
        this.contact_list = new ArrayList<>();
    }

    // Getter to return the contact_list
    public ArrayList<Create_Contact_UC1> getContactList() {
        return contact_list;
    }

    public void addContact(Create_Contact_UC1 new_contact){
        contact_list.add(new_contact);
        System.out.println("Contact Added Successfully");
    }

    public void addMultipleContacts() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Do you want to add a contact? (yes/no): ");
            String response = sc.nextLine();
            if (response.equalsIgnoreCase("no")) {
                break;
            }

            System.out.println("Enter Contact Details:");
            System.out.print("First Name: ");
            String firstName = sc.nextLine();
            System.out.print("Last Name: ");
            String lastName = sc.nextLine();
            System.out.print("Address: ");
            String address = sc.nextLine();
            System.out.print("City: ");
            String city = sc.nextLine();
            System.out.print("State: ");
            String state = sc.nextLine();
            System.out.print("Zip: ");
            String zip = sc.nextLine();
            System.out.print("Phone Number: ");
            String phoneNumber = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();

            Create_Contact_UC1 new_contact = new Create_Contact_UC1(firstName, lastName, address, city, state, zip, phoneNumber, email);

            // Check for duplicate
            boolean duplicateExists = contact_list.stream()
                    .anyMatch(contact -> contact.equals(new_contact));

            if (duplicateExists) {
                System.out.println("Duplicate contact found. Contact not added.");
            } else {
                contact_list.add(new_contact);
                System.out.println("Contact added successfully.");
            }
        }
    }

    public void sortContactsByName() {
        if (contact_list.isEmpty()) {
            System.out.println("No contacts to sort in the Address Book.");
            return;
        }

        // Sort using Streams
        contact_list = contact_list.stream()
                .sorted(Comparator.comparing(Create_Contact_UC1::getFname))
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("Contacts sorted alphabetically by name:");
        displayContacts();
    }
    public void displayContacts() {
        if (contact_list.isEmpty()) {
            System.out.println("No contacts found in the Address Book.");
        } else {
            System.out.println("Contacts in the Address Book:");
            for (Create_Contact_UC1 contact : contact_list) {
                System.out.println(contact);
            }
        }
    }

    public void sortContactsByCity() {
        if (contact_list.isEmpty()) {
            System.out.println("No contacts to sort in the Address Book.");
            return;
        }

        contact_list = contact_list.stream()
                .sorted(Comparator.comparing(Create_Contact_UC1::getCity))
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("Contacts sorted alphabetically by City:");
        displayContacts();
    }
}