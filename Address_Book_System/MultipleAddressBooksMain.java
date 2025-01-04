package Address_Book_System;

import java.util.*;
import java.util.stream.Collectors;

public class MultipleAddressBooksMain {
    private static Map<String, Add_Contact_UC2> addressBooks = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Welcome to the Multiple Address Books System!");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create New Address Book");
            System.out.println("2. Add Contacts to an Address Book");
            System.out.println("3. Display Contacts in an Address Book");
            System.out.println("4. Search Person by City");
            System.out.println("5. Search Person by State");
            System.out.println("6. Sort Contacts in an Address Book by Name");
            System.out.println("7. Sort By City");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the name of the new Address Book: ");
                    String bookName = sc.nextLine();
                    if (addressBooks.containsKey(bookName)) {
                        System.out.println("An Address Book with this name already exists.");
                    } else {
                        addressBooks.put(bookName, new Add_Contact_UC2());
                        System.out.println("Address Book '" + bookName + "' created successfully.");
                    }
                    break;

                case 2:
                    System.out.print("Enter the name of the Address Book to add contacts: ");
                    String targetBook = sc.nextLine();
                    Add_Contact_UC2 addressBook = addressBooks.get(targetBook);
                    if (addressBook != null) {
                        addressBook.addMultipleContacts();
                    } else {
                        System.out.println("Address Book not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter the name of the Address Book to display contacts: ");
                    String displayBookName = sc.nextLine();
                    Add_Contact_UC2 displayBook = addressBooks.get(displayBookName);
                    if (displayBook != null) {
                        ArrayList<Create_Contact_UC1> contacts = displayBook.getContactList();
                        if (contacts.isEmpty()) {
                            System.out.println("No contacts found in the Address Book.");
                        } else {
                            System.out.println("Contacts in Address Book '" + displayBookName + "':");
                            for (Create_Contact_UC1 contact : contacts) {
                                System.out.println(contact);
                            }
                        }
                    } else {
                        System.out.println("Address Book not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter the city to search: ");
                    String city = sc.nextLine();
                    searchByCity(city);
                    break;

                case 5:
                    System.out.print("Enter the state to search: ");
                    String state = sc.nextLine();
                    searchByState(state);
                    break;

                case 6:
                    System.out.print("Enter the name of the Address Book to sort by name: ");
                    String sortBookName1 = sc.nextLine();
                    Add_Contact_UC2 sortBook1 = addressBooks.get(sortBookName1);
                    if (sortBook1 != null) {
                        sortBook1.sortContactsByName();
                    } else {
                        System.out.println("Address Book not found.");
                    }
                    break;

                case 7:
                    System.out.print("Enter the name of the Address Book to sort: ");
                    String sortBookName2 = sc.nextLine();
                    Add_Contact_UC2 sortBook2 = addressBooks.get(sortBookName2);
                    sortBook2.sortContactsByCity();
                    break;

                case 8:
                    System.out.println("Exiting the program. Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void searchByCity(String city) {
        List<Create_Contact_UC1> results = addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContactList().stream())
                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            System.out.println("No persons found in the city: " + city);
        } else {
            System.out.println("Persons found in the city '" + city + "':");
            results.forEach(System.out::println);
            System.out.println("City : " + city + "Count : " + results.size());
        }
    }

    private static void searchByState(String state) {
        List<Create_Contact_UC1> results = addressBooks.values().stream()
                .flatMap(addressBook -> addressBook.getContactList().stream())
                .filter(contact -> contact.getState().equalsIgnoreCase(state))
                .collect(Collectors.toList());

        if (results.isEmpty()) {
            System.out.println("No persons found in the state: " + state);
        } else {
            System.out.println("Persons found in the state '" + state + "':");
            results.forEach(System.out::println);
            System.out.println("State : " + state + "Count : " + results.size());
        }
    }
}

