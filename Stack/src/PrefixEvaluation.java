// Java program to evaluate the prefix expression

// Java program to show the evaluation of postfix expression

import java.util.Scanner;
import java.util.Stack;

public class PrefixEvaluation {
    static Scanner sc = new Scanner(System.in);

    static int evaluationPrefixExpression(String expression) {
        Stack<Integer> st = new Stack<>();
        int result , num1, num2;

        for (int i = expression.length() - 1; i >= 0; i--) {
            if ('0' <= expression.charAt(i) && expression.charAt(i) <= '9') {
                st.push(Character.getNumericValue(expression.charAt(i)));
            } else {
                num1 = st.pop();
                num2 = st.pop();

                switch (expression.charAt(i)) {
                    case '^' -> {
                        result = num1 ^ num2;
                        st.push(result);
                    }
                    case '/' -> {
                        result = num1 / num2;
                        st.push(result);
                    }
                    case '*' -> {
                        result = num1 * num2;
                        st.push(result);
                    }
                    case '+' -> {
                        result = num1 + num2;
                        st.push(result);
                    }
                    case '-' -> {
                        result = num1 - num2;
                        st.push(result);
                    }
                }
            }
        }

        return st.pop();
    }

    public static void main(String[] args) {
        System.out.print("Enter the expression: ");
        String expression = sc.next();

        System.out.println(evaluationPrefixExpression(expression));

    }
}
