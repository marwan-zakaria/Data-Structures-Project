/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package expressiontree;

/**
 *
 * @author marwan
 */
public class Stack {

    char[] stk;
    int top;
    int count;
    int size;

    public Stack(int size) {
        this.size = size;
        stk = new char[size];
        top = -1;
        count = 0;
    }

    public boolean isFull() {
        return count == size;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(char data) {
        if (isFull()) {
            return;
        }
        top++;
        stk[top] = data;
        count++;
    }

    public char pop() {
        count--;
        if (isEmpty()) {
            return ' ';
        }
        return stk[top--];
    }

    public char top() {
        if (isEmpty()) {
            return ' ';
        }
        return stk[top];
    }

    public static int Priority(char c) {
        switch (c) {
            case '+', '-' -> {
                return 1;
            }
            case '*', '/', '%' -> {
                return 2;
            }
            default -> {
                return 0;
            }

        }
    }

    public static String InfixToPostfix(String exp) {
        String res = "";
        Stack stk = new Stack(exp.length());

        for (char i : exp.toCharArray()) {
            if (Character.isDigit(i)) {
                res = res + i;
            } else if (i == '(') {
                stk.push(i);
            } else if (i == ')') {
                while (stk.top() != '(') {
                    res = res + stk.pop();
                }
                stk.pop();
            } else if (Priority(i) > Priority(stk.top())) {
                stk.push(i);
            } else {
                while (Priority(i) <= Priority(stk.top())) {
                    res = res + stk.pop();
                }
                stk.push(i);
            }
        }
        while (!stk.isEmpty()) {
            res = res + stk.pop();
        }
        return res;
    }
    public static String reverse(String exp){
        String rev = "";
        for (int i = exp.length() - 1; i > -1; i--) {
            rev = rev + exp.charAt(i);
        }
        return rev;
    }
    public static String InfixToPrefix(String exp) {
        String pre = "";
        String rev = "";
        Stack stk = new Stack(exp.length());
        exp = reverse(exp);
        for (char i: exp.toCharArray()) {
            rev = switch (i) {
                case '(' -> rev + ')';
                case ')' -> rev + '(';
                default -> rev + i;
            };
        }
        for(char i: rev.toCharArray()){
            if (Character.isDigit(i)) {
                pre += i;
            }else if (i == '(') {
                stk.push(i);
            }else if (i == ')') {
                while(stk.top() != '('){
                    pre += stk.pop();
                }
                stk.pop();
            }else{
                while(Priority(i) < Priority(stk.top())){
                    pre += stk.pop();
                }
                stk.push(i);
            }
        }
        while(!stk.isEmpty()){
            pre += stk.pop();
        }
        
        pre = reverse(pre);
        return pre;
    }
}
