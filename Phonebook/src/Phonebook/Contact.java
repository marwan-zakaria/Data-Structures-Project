/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Phonebook;

/**
 *
 * @author marwan
 */
public class Contact implements Comparable<Contact>{
    private String firstName;
    private String lastName;
    private String contactNumber;

    public Contact(String firstName, String lastName, String contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
// override the toString method so that it returns the data of the contact
    @Override
    public String toString() {
        return "Contact{" + "firstName = " + firstName + ", "
                + ", lastName = " + lastName + 
                ", contactNumber = " + contactNumber + '}';
    }
// compare the first name of each contact 
    @Override
    public int compareTo(Contact o) {
        return firstName.compareTo(o.firstName);
    }
    
    
}
