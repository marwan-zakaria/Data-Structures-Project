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
        Node parent = root;

        for (char i : exp.toCharArray()) {
            if (root == null) {
                root = new Node(i);
                curr = root;
                parent = root;
            } else {
                if (curr.left == null && Character.isDigit(i)) {
                    curr.left = new Node(i);
                } else if (curr.left == null) {
                    curr.left = new Node(i);
                    parent = curr;
                    curr = curr.left;
                } else if (Character.isDigit(i)) {
                    curr.right = new Node(i);
                    curr = parent;
                } else {
                    curr.right = new Node(i);
                    parent = curr;
                    curr = curr.right;
                }
                if (curr == parent && curr.right != null) {
                    curr = root;
                    parent = curr;
                    if (root.right == null) {
                        curr = root.left;
                        while (curr.right != null && curr.left != null) {
                            parent = curr;
                            curr = curr.right;
                        }
                        if (Character.isDigit(curr.data)) {
                            curr = root;
                            parent = root;
                        }
                    }else{
                        curr = root.right;
                        while (curr.right != null && curr.left != null) {
                            parent = curr;
                            curr = curr.right;
                        }
                    }

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
        Node parent = root;
        for (int i = exp.length() - 1; i > -1; i--) {
            if (root == null) {
                root = new Node(exp.charAt(i));
                curr = root;
                parent = root;
            } else {
                if (curr.right == null && Character.isDigit(exp.charAt(i))) {
                    curr.right = new Node(exp.charAt(i));
                } else if (curr.right == null) {
                    curr.right = new Node(exp.charAt(i));
                    parent = curr;
                    curr = curr.right;
                } else if (Character.isDigit(exp.charAt(i))) {
                    curr.left = new Node(exp.charAt(i));
                    curr = parent;
                } else {
                    curr.left = new Node(exp.charAt(i));
                    parent = curr;
                    curr = curr.left;
                }
                if (curr == parent && curr.left != null) {
                    curr = root;
                    parent = root;
                    if (root.left == null) {
                        while(curr.left == null && curr.right != null){
                            parent = curr;
                            curr = curr.right;
                        }
                        curr = parent;
                    }else{
                        curr = root.left;
                        while(curr.left == null && curr.right != null){
                            parent = curr;
                            curr = curr.right;
                        }
                        curr = parent;
                    }
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
