/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EvaluationTree;

/**
 *
 * @author marwa
 */
public class Node {
    Node left, right;
    String data;

    public Node(String data) {
        this.data = data;
        left = null;
        right = null;
    }
    
}
