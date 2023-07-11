/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package EvaluationTree;

import java.util.Scanner;

/**
 *
 * @author marwan
 */
public class EvaluationTree {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Tree t = new Tree();
        
        
        System.out.println("Enter the expression: ");
        String e = s.nextLine();
        
        t.insert(e);
        System.out.println(t.evaluate());

    }

}
