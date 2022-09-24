// Java program to generate all the balanced Parenthesis
// Example: n = 2 => ["()()", "(())"];

import java.util.ArrayList;
import java.util.Scanner;

public class GenerateAllBalancedParenthesis {

    static Scanner sc = new Scanner(System.in);

    static void generateAllBalancedParenthesis(int open, int close, ArrayList<String> arr, String op) {
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


    public static void main(String[] args) {
        int n = sc.nextInt();
        ArrayList<String> arr = new ArrayList<>();

        generateAllBalancedParenthesis(n, n, arr, "");

        for (String element: arr)
            System.out.println(element);
    }
}
