/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Phonebook;

/**
 *
 * @author marwan
 */
public class Node {
    Contact contact;
    Node prev, next;

    public Node(Contact contact) {
        this.contact = contact;
    }
    
}
