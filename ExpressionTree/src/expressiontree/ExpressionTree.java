/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package expressiontree;

import java.util.Scanner;

/**
 *
 * @author marwan
 */
public class ExpressionTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        boolean cont = true;
        while(cont){
        Tree t = new Tree();
            System.out.println("Enter the expression: ");
            t.insertPrefix(s.next());
            System.out.println("The expression is equal to " + t.evaluate());
            
            System.out.println("Do you want to enter another expression?");
            System.out.println("Enter y for yes");
            if (!s.next().equals("y")) {
                cont = false;
            }
        
        }
    }
    
}
