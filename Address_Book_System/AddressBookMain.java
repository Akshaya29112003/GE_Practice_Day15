package Address_Book_System;

import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Add_Contact_UC2 add = new Add_Contact_UC2();
        Display_Contact display = new Display_Contact();
        Delete_Contact_UC4 delete = new Delete_Contact_UC4();
        Edit_Contact_UC3 edit = new Edit_Contact_UC3();

        while (true) {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: // Add contact
                    System.out.println("Enter First Name: ");
                    String fname = sc.nextLine();

                    System.out.println("Enter Last Name: ");
                    String lname = sc.nextLine();

                    System.out.println("Enter Address: ");
                    String address = sc.nextLine();

                    System.out.println("Enter City: ");
                    String city = sc.nextLine();

                    System.out.println("Enter State: ");
                    String state = sc.nextLine();

                    System.out.println("Enter Zip: ");
                    String zip = sc.nextLine();

                    System.out.println("Enter Phone Number: ");
                    String phone = sc.nextLine();

                    System.out.println("Enter Email: ");
                    String email = sc.nextLine();

                    Create_Contact_UC1 newContact = new Create_Contact_UC1(fname, lname, address, city, state, zip, phone, email);
                    add.addContact(newContact);
                    break;

                case 2: // Display contacts
                    display.displayContacts(add.getContactList());
                    break;

                case 3: // Edit contact
                    System.out.println("Enter First Name of contact to edit: ");
                    String editFname = sc.nextLine();
                    System.out.println("Enter Last Name of contact to edit: ");
                    String editLname = sc.nextLine();
                    edit.editContact(add.getContactList(), editFname, editLname);
                    break;

                case 4: // Delete contact
                    System.out.println("Enter First Name of contact to delete: ");
                    String delFname = sc.nextLine();
                    System.out.println("Enter Last Name of contact to delete: ");
                    String delLname = sc.nextLine();
                    delete.deleteContact(add.getContactList(), delFname, delLname);
                    break;

                case 5: // Exit
                    System.out.println("Exiting Address Book. Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
