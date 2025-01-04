package Address_Book_System;

import java.util.ArrayList;

public class Display_Contact {
    public void displayContacts(ArrayList<Create_Contact_UC1> contact_list){
        System.out.println("Contacts in Address Book:");
        for(Create_Contact_UC1 contact : contact_list){
            System.out.println(contact+ "\n");
        }
    }
}
