/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Phonebook;

import java.util.Scanner;

/**
 *
 * @author marwan
 */
public class Phonebook {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        // boolean variable to indicate if the loop will continue or not
        boolean cont = true;
        
        
        Contact c1 =  new Contact("Marwan", "Ahmed", "0203345667");
        Contact c2 =  new Contact("Yousef", "Mohamed", "01143265967");
        Contact c3 =  new Contact("Hamza", "Ziad", "010234345667");
        Contact c4 =  new Contact("Khalid", "Hassan", "010234345667");
        
        Linkedlist phonebook = new Linkedlist();
        
        phonebook.addContact(c1);
        phonebook.addContact(c2);
        phonebook.addContact(c3);
        phonebook.addContact(c4);
        
        while(cont){
            // print the menu the user will choose from
            printMenu();
            
            
            switch(s.nextInt()){
                case 1 -> // print the sorted the linkedlist by first name
                    phonebook.print();
                case 2 -> {
                    // print all the contacts whose first name starts with a given letter the user enters
                    System.out.print("Enter the letter: ");
                    phonebook.printStart(s.next().charAt(0));
                }
                case 3 -> {
                    // search for the contact with the last name the user enters
                    System.out.print("Enter the last name: ");
                    phonebook.searchName(s.next());
                }
                case 4 -> {
                    // ask the user to enter the data of the new contact
                    System.out.println("Enter the first name: ");
                    String fname = s.next();
                    System.out.println("Enter the last name: ");
                    String lname = s.next();
                    System.out.println("Enter the contact number: ");
                    String contactNumber = s.next();
                    Contact c5 = new Contact(fname, lname, contactNumber);
                    phonebook.addContact(c5);
                }
                case 5 -> {
                    //remove the contact with the last name the user enters 
                    System.out.print("Enter the last name of the person to be removed: ");
                    phonebook.removeContact(s.next());
                }
                case 6 -> {
                    // ask the user to enter the data of the new contact and the last name it should be added after
                    System.out.print("Enter the first name: ");
                    String Fname = s.next();
                    System.out.print("Enter the last name: ");
                    String Lname = s.next();
                    System.out.print("Enter the contact number: ");
                    String ContactNumber = s.next();
                    Contact c6 = new Contact(Fname, Lname, ContactNumber);
                    System.out.print("Enter the last name of the contact you want to add after: ");
                    String lname2 = s.next();
                    phonebook.addContactAfter(c6, lname2);
                }
                case 7 -> // cont will be false and exit the loop and stop the program
                    cont = false;
            }
        }
        
        
    }
    
    public static void printMenu(){
        System.out.println("Choose one of the following: ");
        System.out.println();
        System.out.println("1. Display all names and phone numbers sorted by First name");
        System.out.println("2. Display all names and phone numbers starting with a given letter");
        System.out.println("3. Search for a name (by last name)");
        System.out.println("4. Add a new contact as last element in the phone book");
        System.out.println("5. Delete a person from the list (using his/her last name)");
        System.out.println("6. Add a new contact after a specific contact (last name)");
        System.out.println("7. Exit the phonebook");
    }
}
