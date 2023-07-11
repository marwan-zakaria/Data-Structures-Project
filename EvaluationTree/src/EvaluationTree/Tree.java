/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EvaluationTree;

/**
 *
 * @author marwa
 */
public class Tree {

    Node root;

    public Tree() {
        this.root = null;
    }

    //checks to see if the character is operator
    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*")
                || s.equals("/") || s.equals("%");
    }

    public double evaluate() {
        return evaluateHelper(root);
    }

    // evaluate the expression
    private double evaluateHelper(Node l) {
        //Checks to see if its an operator
        if (isOperator(l.data)) {
            //check to see the type of the operator
            switch (l.data) {
                case "+" -> {
                    return evaluateHelper(l.left) + evaluateHelper(l.right);
                }
                case "-" -> {
                    return evaluateHelper(l.left) - evaluateHelper(l.right);
                }
                case "*" -> {
                    return evaluateHelper(l.left) * evaluateHelper(l.right);
                }
                case "/" -> {
                    return evaluateHelper(l.left) / evaluateHelper(l.right);
                }
                case "%" -> {
                    if (l.right == null) {
                        return evaluateHelper(l.left) / 100;
                    }
                    return evaluateHelper(l.left) % evaluateHelper(l.right);
                }
            }
            // After determining the type of the operator
            // Implement the operation between the left and right node
        }
        //if the above condition is false this means we have a number return the value of this number
        return Double.parseDouble(l.data);

    }

    public void insert(String data) {
        data = data.replaceAll(" ", "");
        String[] exp = data.split("");
        Node curr = root;
        for (String i : exp) {
            if (root == null) {
                root = new Node(i);
                curr = root;
            } else {
                Node n = new Node(i);
                if (isOperator(i) && !isOperator(root.data)) {
                    n.left = root;
                    root = n;
                    curr = root;
                } else if (isOperator(i)) {
                    if (i.equals("+") || i.equals("-")
                            || root.data.equals("*") || root.data.equals("/")
                            || root.data.equals("%")) {
                        n.left = root;
                        root = n;
                        curr = root;
                    }else{
                        n.left = root.right;
                        root.right = n;
                        curr = n;
                    }
                }else{
                    if (!isOperator(curr.data)) {
                        curr.data = curr.data + i;
                    }else{
                        curr.right = n;
                        curr = curr.right;
                    }
                }
            }
        }
    }

}
