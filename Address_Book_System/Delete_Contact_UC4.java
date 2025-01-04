package Address_Book_System;

import java.util.ArrayList;
import java.util.Iterator;

public class Delete_Contact_UC4 {
    public void deleteContact(ArrayList<Create_Contact_UC1> contact_list, String fname, String lname){
        Iterator<Create_Contact_UC1> iterator = contact_list.iterator();
        while (iterator.hasNext()) {
            Create_Contact_UC1 contact = iterator.next();
            if (contact.getFname().equalsIgnoreCase(fname) && contact.getLname().equalsIgnoreCase(lname)) {
                iterator.remove(); // Safe removal
                System.out.println("Contact Deleted Successfully");
            }
        }
    }
}
