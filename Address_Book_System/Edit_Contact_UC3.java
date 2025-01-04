package Address_Book_System;

import java.util.ArrayList;
import java.util.Scanner;

public class Edit_Contact_UC3 {
    public void editContact(ArrayList<Create_Contact_UC1> contact_list, String fname, String lname){
        Scanner sc = new Scanner(System.in);

        for(Create_Contact_UC1 contact : contact_list){
            if(contact.getFname().equalsIgnoreCase(fname) && contact.getLname().equalsIgnoreCase(lname)){
                System.out.println("Enter new details to the existing Contact");

                System.out.println("Address :");
                String address = sc.nextLine();

                System.out.print("City: ");
                String city = sc.nextLine();

                System.out.print("State: ");
                String state = sc.nextLine();

                System.out.print("Zip: ");
                String zip = sc.nextLine();

                System.out.print("Phone Number: ");
                String phone = sc.nextLine();

                System.out.print("Email: ");
                String email = sc.nextLine();

                contact.updateDetails(address, city, state, zip, phone, email);
                System.out.println("Contact updated Successfully");
            }
        }
    }
}
