// Java program to implement the parenthesis redundant problem

import java.util.Stack;
import java.util.Scanner;

public class ParenthesisRedundant {

    static boolean parenthesisRedundant(String str) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!((ch >= 'a' && ch <= 'z') || (ch >= 'A') && (ch <= 'Z')))
                if (ch == '(' || ch == '{' || ch == '[')
                    st.push(ch);
                else if (ch == ')')
                    if (st.peek() == '(')
                        st.pop();
                    else
                        return false;
                else if (ch == '}')
                    if (st.peek() == '{')
                        st.pop();
                    else
                        return false;
                else if (ch == ']')
                    if (st.peek() == '[')
                        st.pop();
                    else
                        return false;
        }

        return st.empty();
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string: ");
        String str = sc.next();

        if(parenthesisRedundant(str))
            System.out.println("The expression is parenthesis redundant");
        else
            System.out.println("The expression is not parenthesis redundant");
    }
}
