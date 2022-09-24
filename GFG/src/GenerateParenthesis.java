// Java program to generate all the balanced Parenthesis
// Example: n = 2 => ["()()", "(())"];

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParenthesis {

    static Scanner sc = new Scanner(System.in);

    static void generateAllBalancedParenthesis(int open, int close, List<String> arr, String op) {
        if (open == 0 && close == 0)
            arr.add(op);
        else {
            if (open != 0) {
                generateAllBalancedParenthesis(open - 1, close, arr, op + '(');
            }
            if (close > open) {
                generateAllBalancedParenthesis(open, close - 1, arr, op + ')');
            }
        }
    }

    static List<String> AllParenthesis(int n) {
        List<String> l = new ArrayList<>();
        if (n != 0) {
            generateAllBalancedParenthesis(n, n, l, "");
        }
        return l;
    }

    public static void main(String[] args) {
        int n = sc.nextInt();

        List<String> l = AllParenthesis(n);

        for (String element: l)
            System.out.println(element);
    }
}
