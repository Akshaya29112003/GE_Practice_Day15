package Address_Book_System;

import java.util.Objects;

public class Create_Contact_UC1 {
    public String fname;
    public String lname;
    public String address;
    public String city;
    public String state;
    public String zip;
    public String phone;
    public String email;

    public Create_Contact_UC1(String fname, String lname, String address, String city, String state, String zip, String phone, String email) {
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    public String getFname(){
        return fname;
    }

    public String getLname(){
        return lname;
    }

    public String getState() { return state; }
    public String getCity() { return city; }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Create_Contact_UC1 con = (Create_Contact_UC1) obj;
        return Objects.equals(fname, con.fname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fname);
    }
    public void updateDetails(String address, String city, String state, String zip, String phone, String email){
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }
    @Override
    public String toString(){
        return "Name: " + fname + " " + lname + "\nAddress: " + address + ", " + city + ", " + state + ", " + zip + "\nPhone: " + phone + "\nEmail: " + email;
    }
}
