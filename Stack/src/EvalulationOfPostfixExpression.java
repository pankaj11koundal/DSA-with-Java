// Java program to show the evaluation of postfix expression

import java.util.Scanner;
import java.util.Stack;

public class EvalulationOfPostfixExpression {
     static Scanner sc = new Scanner(System.in);

    static int evaluationPostfixExpression(String expression) {
        Stack<Integer> st = new Stack<>();
        int result = 0, num1, num2;

        for (int i = 0; i < expression.length(); i++) {
            if ('0' <= expression.charAt(i) && expression.charAt(i) <= '9') {
                st.push(Character.getNumericValue(expression.charAt(i)));
            } else {
                num1 = st.pop();
                num2 = st.pop();
                System.out.println(num1 + num2);
                sc.nextLine();

                switch (expression.charAt(i)) {
                    case '^' -> {
                        result = num2 ^ num1;
                        st.push(result);
                    }
                    case '/' -> {
                        result = num2 / num1;
                        st.push(result);
                    }
                    case '*' -> {
                        result = num2 * num1;
                        st.push(result);
                    }
                    case '+' -> {
                        result = num2 + num1;
                        st.push(result);
                    }
                    case '-' -> {
                        result = num2 - num1;
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

        System.out.println(evaluationPostfixExpression(expression));

    }
}
