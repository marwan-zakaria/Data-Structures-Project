/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expressiontree;

/**
 *
 * @author marwan
 */
public class Tree {

    Node root;

    public Tree() {
        root = null;
    }

    public void insertPrefix(String exp) {
        if (exp.contains("(") || (Character.isDigit(exp.charAt(0))
                && !Character.isDigit(exp.charAt(1)))) {
            System.out.println("The infix expression: " + exp);
            exp = Stack.InfixToPrefix(exp);
        } else if (Character.isDigit(exp.charAt(0))) {
            insertPostfix(exp);
            return;
        }
        System.out.println("The prefix expression: " + exp);

        Node curr = root;

        for (char i : exp.toCharArray()) {
            if (root == null) {
                root = new Node(i);
                curr = root;
            } else {
                if (curr.left == null && Character.isDigit(i)) {
                    curr.left = new Node(i);
                }else if (curr.left == null) {
                    curr.left = new Node(i);
                    curr.left.parent = curr;
                    curr = curr.left;
                }else if (Character.isDigit(i)) {
                    curr.right = new Node(i);
                }else{
                    curr.right = new Node(i);
                    curr.right.parent = curr;
                    curr = curr.right;
                }
                while(curr.right != null && curr.parent != null){
                    curr = curr.parent;
                }
            }
        }
    }

    public void insertPostfix(String exp) {
        if (!Character.isDigit(exp.charAt(0))) {
            insertPrefix(exp);
            return;
        } else if (exp.contains("(") || !Character.isDigit(exp.charAt(1))) {
            System.out.println("The infix expression: " + exp);
            exp = Stack.InfixToPostfix(exp);
        }
        System.out.println("The postfix expression: " + exp);

        Node curr = root;
        for (int i = exp.length() - 1; i > -1; i--) {
            if (root == null) {
                root = new Node(exp.charAt(i));
                curr = root;
            } else {
                if (curr.right == null && Character.isDigit(exp.charAt(i))) {
                    curr.right = new Node(exp.charAt(i));
                }else if (curr.right == null) {
                    curr.right = new Node(exp.charAt(i));
                    curr.right.parent = curr;
                    curr = curr.right;
                }else if (Character.isDigit(exp.charAt(i))) {
                    curr.left = new Node(exp.charAt(i));
                }else{
                    curr.left = new Node(exp.charAt(i));
                    curr.left.parent = curr;
                    curr = curr.left;
                }
                while(curr.left != null && curr.parent != null){
                    curr = curr.parent;
                }
                
            }
        }
    }

    public int evaluate() {
        return evaluateHelper(root);
    }

    private int evaluateHelper(Node n) {
        if (root == null) {
            return 0;
        }
        switch (n.data) {
            case '+' -> {
                return evaluateHelper(n.left) + evaluateHelper(n.right);
            }
            case '-' -> {
                return evaluateHelper(n.left) - evaluateHelper(n.right);
            }
            case '/' -> {
                return evaluateHelper(n.left) / evaluateHelper(n.right);
            }
            case '*' -> {
                return evaluateHelper(n.left) * evaluateHelper(n.right);
            }
            case '%' -> {
                return evaluateHelper(n.left) % evaluateHelper(n.right);
            }
            default -> {
                return Integer.parseInt(n.data + "");
            }
        }
    }
}
