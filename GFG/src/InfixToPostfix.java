// Java program to implement the conversion of infix expression into postfix expression

import java.util.Stack;

public class InfixToPostfix {
    static int precedence(char ch) {
        if (ch == '^')
            return 3;
        else if (ch == '/' || ch == '*')
            return 2;
        else if (ch == '+' || ch == '-')
            return 1;
        else
            return 0;
    }

    static StringBuilder infixToPostfix(StringBuilder infixExpression) {
        StringBuilder str = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < infixExpression.length(); i++) {
            char ch = infixExpression.charAt(i);
            if (ch == '(') {
                st.push(ch);
                System.out.println("inside )" + ch);
            }
            else if (ch >= 'A' && ch <= 'Z' || ch >='a' && ch <='z') {
                str.append(ch);
                System.out.println("Inside char" + ch);
            }
            else if (ch == ')') {
                while (!st.empty() && st.peek() != '(')
                    str.append(st.pop());
                st.pop();
                System.out.println(st);
                System.out.println("Inside (" + ch);
            }
            else {
                while (!st.empty() && precedence(st.peek()) > precedence(ch))
                    str.append(st.pop());
                st.push(ch);
                System.out.println("else" + ch);
            }
        }

        System.out.println(str);
        System.out.println(st);
        while (!st.empty())
            str.append(st.pop());

        System.out.println(str);
        return str;
    }

    public static void main(String[] args) {
        System.out.println("Enter the infix expression: ");
        StringBuilder infixExpression = new StringBuilder("(a-b/c)*(a/k-l)");
        System.out.println(infixExpression);

        infixExpression = infixToPostfix(infixExpression);
        System.out.println(infixExpression);

    }
}
