/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Phonebook;

import java.util.Scanner;

/**
 *
 * @author marwan
 */
public class Linkedlist {

    Node head, tail;
    int count;

    public Linkedlist() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }
    //Add contact at the end of linkedlist
    public void addContact(Contact c) {
        Node newNode = new Node(c);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        count++;
    }
    // Remove the first Contact from linkedlist with the last name the user enters
    public void removeContact(String LName) {
        Node curr = head;
        while (curr != null) {
            if (curr.contact.getLastName().equals(LName)) {
                if (curr.prev == null) {
                    head = head.next;
                } else if (curr.next == null) {
                    curr.prev.next = null;
                } else {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }
                count--;
                System.out.println("The user " + LName + " has been removed");
                return;
            }
            curr = curr.next;
        }

        System.out.println("The person " + LName + " was not found");
    }
    // Add contact after the contact with the last name the user enters
    public void addContactAfter(Contact c, String LName) {
        Node curr = head;
        while (curr != null) {
            if (curr.contact.getLastName().equals(LName)) {
                Node newNode = new Node(c);
                if (curr.next != null) {
                    //if it was not the last node
                    newNode.next = curr.next;
                    curr.next.prev = newNode;
                    curr.next = newNode;
                    newNode.prev = curr;
                } else {// if Node is last
                    tail.next = newNode;
                    newNode.prev = tail;
                    tail = newNode;
                }
                count++;
                return;
            }
            curr = curr.next;
        }
    }
    // Search the linkedlist with the last name the user enters
    public void searchName(String LName) {
        Node curr = head;
        while (curr != null) {
            if (curr.contact.getLastName().equals(LName)) {
                System.out.println("The customer " + curr.contact);
                break;
            }
            curr = curr.next;
        }
    }
    // Return the node at the specified index similar to random access in an array
    public Node getNode(int i) {
        Node temp = head;
        for (int j = 0; j < count; j++) {
            if (j == i) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    // Sort the linkdelist using the getNode method and Bubble Sort
    public void bubbleSort() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (getNode(j).contact.compareTo(getNode(j+1).contact) > 0) {
                    Contact temp = getNode(j).contact;
                    getNode(j).contact = getNode(j + 1).contact;
                    getNode(j + 1).contact = temp;
                }
            }
        }
    }
    
    // Sort the linkdelist using the getNode method and Selection Sort
    public void selectionSort(){
        for (int i = 0; i < count - 1; i++) {
            int index = i;
            for (int j = i + 1; j < count; j++) {
                if (getNode(j).contact.compareTo(getNode(index).contact) < 0) {
                    index = j;
                }
            }
            Contact temp = getNode(index).contact;
            getNode(index).contact = getNode(i).contact;
            getNode(i).contact = temp;
        }
    }
    // Sort the linkdelist using the getNode method and Insertion Sort
    public void insertionSort(){
        for (int i = 1; i < count; i++) {
            Contact key = getNode(i).contact;
            int j = i - 1;
            
            while(j >= 0 && getNode(j).contact.compareTo(key) > 0){
                getNode(j + 1).contact = getNode(j).contact;
                j--;
            }
            getNode(j + 1).contact = key;
        }
    }
    // print the sorted linkedlist by first name
    public void print() {
        if (count == 0) {
            System.out.println("There are no contacts in the phonebook yet");
            return;
        }
        System.out.println("Choose the type of sorting: ");
        System.out.println("1-Bubble sort");
        System.out.println("2-Selection Sort");
        System.out.println("3-Insertion Sort");
        Scanner s = new Scanner(System.in);
        switch(s.nextInt()){
            case 1:
                bubbleSort();
                break;
            case 2:
                selectionSort();
                break;
            case 3:
                insertionSort();
                break;
        }
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.contact);
            curr = curr.next;
        }
    }
// print all the contacts whose first name starts with a given letter the user enters
    public void printStart(char c) {
        Node curr = head;
        boolean no = true;
        while (curr != null) {
            if (Character.toLowerCase(curr.contact.getFirstName().charAt(0)) == Character.toLowerCase(c)) {
                no = false;
                System.out.println(curr.contact);
            }
            curr = curr.next;
        }
        if (no) {
            System.out.println("There were no names starting with that letter");
        }
    }
}
